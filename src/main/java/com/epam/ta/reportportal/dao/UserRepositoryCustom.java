package com.epam.ta.reportportal.dao;

import com.epam.ta.reportportal.entity.user.User;

import java.io.InputStream;

/**
 * @author Pavel Bortnik
 */
public interface UserRepositoryCustom {

	String uploadUserPhoto(String login, InputStream binaryData);

	String replaceUserPhoto(String login, InputStream binaryData);

	String replaceUserPhoto(User user, InputStream binaryData);

	InputStream findUserPhoto(User user);

	void deleteUserPhoto(User user);


}
