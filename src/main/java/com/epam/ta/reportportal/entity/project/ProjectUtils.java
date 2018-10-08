/*
 *  Copyright (C) 2018 EPAM Systems
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package com.epam.ta.reportportal.entity.project;

import com.epam.ta.reportportal.commons.SendCase;
import com.epam.ta.reportportal.entity.project.email.EmailSenderCase;
import com.epam.ta.reportportal.entity.project.email.ProjectEmailConfig;
import com.epam.ta.reportportal.entity.user.User;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;
import static java.util.stream.StreamSupport.stream;

/**
 * Project related utility methods
 *
 * @author Andrei_Ramanchuk
 */
public class ProjectUtils {
	private static final String INIT_FROM = "reportportal@example.com";
	private static final String OWNER = "OWNER";

	private ProjectUtils() {

	}

	/**
	 * Setup default project email configuration
	 *
	 * @param project
	 * @return project object with default email config
	 */
	public static Project setDefaultEmailConfiguration(Project project) {
		EmailSenderCase defaultOne = new EmailSenderCase(Lists.newArrayList(OWNER), SendCase.ALWAYS, Sets.newHashSet(), Sets.newHashSet());
		ProjectEmailConfig config = new ProjectEmailConfig(false, INIT_FROM);
		defaultOne.setProject(project);
		project.getConfiguration().setProjectEmailConfig(config);
		return project;
	}

	/**
	 * Exclude specified project recipients
	 *
	 * @param users
	 * @param project
	 * @return
	 */
	public static Project excludeProjectRecipients(Iterable<User> users, Project project) {
		if (users != null) {
			Set<String> toExclude = stream(users.spliterator(), false).map(
					user -> asList(user.getEmail().toLowerCase(), user.getLogin().toLowerCase())).flatMap(List::stream).collect(toSet());
			/* Current recipients of specified project */
			Set<EmailSenderCase> cases = project.getEmailCases();
			if (null != cases) {
				cases.stream().forEach(c -> {
					// saved - list of saved user emails before changes
					List<String> saved = c.getRecipients();
					c.setRecipients(saved.stream().filter(it -> !toExclude.contains(it.toLowerCase())).collect(toList()));
				});
				project.setEmailCases(cases);
			}
		}
		return project;
	}

	/**
	 * Update specified project recipient
	 *
	 * @param oldEmail
	 * @param newEmail
	 * @param project
	 * @return
	 */
	public static Project updateProjectRecipients(String oldEmail, String newEmail, Project project) {
		Set<EmailSenderCase> cases = project.getEmailCases();
		if ((null != cases) && (null != oldEmail) && (null != newEmail)) {
			cases.stream().forEach(c -> {
				List<String> saved = c.getRecipients();
				if (saved.stream().anyMatch(email -> email.equalsIgnoreCase(oldEmail))) {
					c.setRecipients(saved.stream().filter(processRecipientsEmails(Lists.newArrayList(oldEmail))).collect(toList()));
					c.getRecipients().add(newEmail);
				}
			});
			project.setEmailCases(cases);
		}
		return project;
	}

	/**
	 * Checks if the user is assigned on project
	 *
	 * @param project Specified project
	 * @param user    User login
	 * @return True, if exists
	 */
	public static boolean doesHaveUser(Project project, String user) {
		return project.getUsers().stream().anyMatch(it -> user.equals(it.getUser().getLogin()));
	}

	/**
	 * Finds UserConfig for specified login. Returns null
	 * if it doesn't exists.
	 *
	 * @param user Login for search
	 * @return UserConfig for specified login
	 */
	@Nullable
	public static Project.UserConfig findUserConfigByLogin(Project project, String user) {
		return project.getUsers().stream().filter(it -> user.equals(it.getUser().getLogin())).findAny().orElse(null);
	}

	private static Predicate<String> processRecipientsEmails(final Iterable<String> emails) {
		return input -> stream(emails.spliterator(), false).noneMatch(email -> email.equalsIgnoreCase(input));
	}

	public static String getOwner() {
		return OWNER;
	}
}