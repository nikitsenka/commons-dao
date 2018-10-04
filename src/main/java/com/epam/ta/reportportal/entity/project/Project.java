package com.epam.ta.reportportal.entity.project;

import com.epam.ta.reportportal.commons.JsonbMetaDataType;
import com.epam.ta.reportportal.entity.integration.Integration;
import com.epam.ta.reportportal.entity.item.issue.IssueType;
import com.epam.ta.reportportal.entity.project.email.EmailSenderCase;
import com.epam.ta.reportportal.entity.user.ProjectUser;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.google.common.base.MoreObjects;
import com.google.common.collect.Sets;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * @author Ivan Budayeu
 */
@Entity
@EntityListeners(AuditingEntityListener.class)
@TypeDef(name = "JsonbMetaDataType", typeClass = JsonbMetaDataType.class)
@Table(name = "project", schema = "public")
public class Project implements Serializable {

	private static final long serialVersionUID = -263516611;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false, precision = 64)
	private Long id;

	@Column(name = "name")
	private String name;

	@OneToMany(mappedBy = "project", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY, orphanRemoval = true)
	@JsonBackReference
	private Set<Integration> integrations = Sets.newHashSet();

	@Column(name = "additional_info")
	private String addInfo;

	@Transient
	@JsonSerialize
	private Map<String, String> configuration;

	@OneToMany(mappedBy = "project", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonIgnore
	private Set<ProjectAttribute> projectAttributes;

	@OneToMany(mappedBy = "project")
	@JsonBackReference
	private List<DemoDataPostfix> demoDataPostfix;

	@Column(name = "creation_date")
	private Date creationDate;

	@Type(type = "JsonbMetaDataType")
	@Column(name = "metadata")
	private Map<String, String> metadata;

	@ManyToMany(cascade = { CascadeType.ALL })
	@JoinTable(name = "issue_type_project", joinColumns = { @JoinColumn(name = "project_id") }, inverseJoinColumns = {
			@JoinColumn(name = "issue_type_id") })
	private List<IssueType> issueTypes;

	@OneToMany(mappedBy = "project", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<EmailSenderCase> emailCases;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "project", cascade = CascadeType.ALL)
	@JsonBackReference
	private Set<ProjectUser> users;

	public Project(Long id, String name) {
		this.id = id;
		this.name = name;
	}

	public Project() {
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAddInfo() {
		return addInfo;
	}

	public void setAddInfo(String addInfo) {
		this.addInfo = addInfo;
	}

	public Set<ProjectUser> getUsers() {
		return users;
	}

	public void setUsers(Set<ProjectUser> users) {
		this.users = users;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Integration> getIntegrations() {
		return integrations;
	}

	public void setIntegrations(Set<Integration> integrations) {
		this.integrations = integrations;
	}

	public Set<ProjectAttribute> getProjectAttributes() {
		return projectAttributes;
	}

	public List<IssueType> getIssueTypes() {
		return issueTypes;
	}

	public void setIssueTypes(List<IssueType> issueTypes) {
		this.issueTypes = issueTypes;
	}

	public void setProjectAttributes(Set<ProjectAttribute> projectAttributes) {
		this.projectAttributes = projectAttributes;
	}

	public Set<EmailSenderCase> getEmailCases() {
		return emailCases;
	}

	public void setEmailCases(Set<EmailSenderCase> emailCases) {
		this.emailCases = emailCases;
	}

	/**
	 * NULL-safe getter
	 *
	 * @return the configuration
	 */
	public Map<String, String> getConfiguration() {
		return ofNullable(projectAttributes).map(attributes -> attributes.stream()
				.collect(Collectors.toMap(pa -> pa.getAttribute().getName(), ProjectAttribute::getValue))).orElseGet(Collections::emptyMap);
	}

	/**
	 * @param configuration the configuration to set
	 */
	public void setConfiguration(Map<String, String> configuration) {
		this.configuration = configuration;
	}

	/**
	 * NULL-safe getter
	 *
	 * @return the list of demo-data postfix
	 */
	public List<DemoDataPostfix> getDemoDataPostfix() {
		return demoDataPostfix == null ? demoDataPostfix = Collections.emptyList() : demoDataPostfix;
	}

	public void setDemoDataPostfix(List<DemoDataPostfix> demoDataPostfix) {
		this.demoDataPostfix = demoDataPostfix;
	}

	public Map<String, String> getMetadata() {
		return metadata;
	}

	public void setMetadata(Map<String, String> metadata) {
		this.metadata = metadata;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Project project = (Project) o;
		return Objects.equals(name, project.name) && Objects.equals(addInfo, project.addInfo) && Objects.equals(configuration,
				project.configuration
		) && Objects.equals(users, project.users) && Objects.equals(creationDate, project.creationDate) && Objects.equals(
				metadata,
				project.metadata
		);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, addInfo, configuration, users, creationDate);
	}

	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this)
				.add("name", name)
				.add("addInfo", addInfo)
				.add("configuration", configuration)
				.add("users", users)
				.add("creationDate", creationDate)
				.toString();
	}
}
