package com.epam.ta.reportportal.grabage.item;

/**
 * DB<->DTO conversion utils for TestItem
 *
 * @author Andrei Varabyeu
 * @author Andrei_Ramanchuk
 */
class TestItemUtils {
//	/**
//	 * Converts DTO to DB model
//	 *
//	 * @param userName Name of user
//	 * @return Conversion function
//	 */
//	static Function<Issue.ExternalSystemIssue, TestItemIssue.ExternalSystemIssue> externalIssueDtoConverter(String userName) {
//		return issue -> {
//			TestItemIssue.ExternalSystemIssue externalSystemIssue = new TestItemIssue.ExternalSystemIssue();
//			externalSystemIssue.setTicketId(issue.getTicketId().trim());
//			externalSystemIssue.setSubmitDate(new Date().getTime());
//			externalSystemIssue.setSubmitter(userName);
//			externalSystemIssue.setExternalSystemId(issue.getExternalSystemId());
//			externalSystemIssue.setUrl(issue.getUrl());
//			return externalSystemIssue;
//		};
//	}
//
//	/**
//	 * Converts DTO model to DB keeping specified external system ID
//	 *
//	 * @param externalSystemId External system ID to use
//	 * @param userName         Name of user
//	 * @return Conversion function
//	 */
//	static Function<Issue.ExternalSystemIssue, TestItemIssue.ExternalSystemIssue> externalIssueDtoConverter(String externalSystemId,
//			String userName) {
//		return externalIssueDtoConverter(userName).andThen(externalSystemIssue -> {
//			externalSystemIssue.setExternalSystemId(externalSystemId);
//			return externalSystemIssue;
//		});
//	}

}