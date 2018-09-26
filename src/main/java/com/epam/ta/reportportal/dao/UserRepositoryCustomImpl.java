package com.epam.ta.reportportal.dao;

import com.epam.ta.reportportal.BinaryData;
import com.epam.ta.reportportal.entity.user.User;
import com.epam.ta.reportportal.exception.ReportPortalException;
import com.epam.ta.reportportal.filesystem.DataStore;
import com.epam.ta.reportportal.ws.model.ErrorType;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.apache.commons.io.IOUtils;
import org.apache.tika.io.TikaInputStream;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.mime.MediaType;
import org.apache.tika.parser.AutoDetectParser;
import org.apache.tika.parser.image.ImageParser;
import org.jooq.Record;
import org.jooq.RecordMapper;
import org.jooq.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

import static com.epam.ta.reportportal.commons.validation.Suppliers.formattedSupplier;
import static com.epam.ta.reportportal.jooq.tables.JUsers.USERS;
import static java.util.Optional.ofNullable;

/**
 * @author Pavel Bortnik
 */
@Repository
public class UserRepositoryCustomImpl implements UserRepositoryCustom {

	private final DataStore dataStore;

	public static final RecordMapper<? super Record, User> USER_RECORD_MAPPER = record -> record.into(User.class);

	public static final Function<Result<? extends Record>, List<User>> USER_FETCHER = result -> {
		Map<Long, User> userMap = Maps.newHashMap();
		result.forEach(res -> {
			Long userId = res.get(USERS.ID);
			if (!userMap.containsKey(userId)) {
				userMap.put(userId, USER_RECORD_MAPPER.map(res));
			}
		});

		return Lists.newArrayList(userMap.values());
	};

	@Autowired
	public UserRepositoryCustomImpl(DataStore dataStore) {
		this.dataStore = dataStore;
	}

	@Override
	public String uploadUserPhoto(String login, BinaryData binaryData) {
		return dataStore.save(login, binaryData.getInputStream());
	}

	@Override
	public String replaceUserPhoto(String login, BinaryData binaryData) {
		return dataStore.save(login, binaryData.getInputStream());
	}

	@Override
	public String replaceUserPhoto(User user, BinaryData binaryData) {
		return dataStore.save(user.getLogin(), binaryData.getInputStream());
	}

	@Override
	public BinaryData findUserPhoto(User user) {
		String path = ofNullable(user.getAttachment()).orElseThrow(() -> new ReportPortalException(ErrorType.BAD_REQUEST_ERROR,
				formattedSupplier("User - '{}' does not have a photo.", user.getLogin())
		));
		InputStream inputStream = dataStore.load(path);
		try {
			byte[] bytes = IOUtils.toByteArray(inputStream);
			String contentType = resolveContentType(bytes);

			return new BinaryData(contentType, (long) bytes.length, inputStream);
		} catch (IOException e) {
			//TODO add new exception type
			throw new ReportPortalException(ErrorType.BAD_REQUEST_ERROR);
		}
	}

	@Override
	public void deleteUserPhoto(User user) {
		String path = ofNullable(user.getAttachment()).orElseThrow(() -> new ReportPortalException(ErrorType.BAD_REQUEST_ERROR,
				formattedSupplier("User - '{}' does not have a photo.", user.getLogin())
		));
		dataStore.delete(path);
	}

	private String resolveContentType(byte[] data) {
		AutoDetectParser parser = new AutoDetectParser(new ImageParser());
		try {
			return parser.getDetector().detect(TikaInputStream.get(data), new Metadata()).toString();
		} catch (IOException e) {
			return MediaType.OCTET_STREAM.toString();
		}
	}
}
