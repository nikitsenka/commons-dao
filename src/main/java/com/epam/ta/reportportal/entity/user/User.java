package com.epam.ta.reportportal.entity.user;

import com.epam.ta.reportportal.commons.JsonbUserType;
import com.epam.ta.reportportal.entity.meta.MetaData;
import com.epam.ta.reportportal.entity.project.Project;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

/**
 * @author Andrei Varabyeu
 */
@Entity
@EntityListeners(AuditingEntityListener.class)
@TypeDef(name = "jsonb", typeClass = JsonbUserType.class)
@Table(name = "users", schema = "public")
public class User implements Serializable {

	private static final long serialVersionUID = 923392981;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false, precision = 64)
	private Long id;

	@Column(name = "login")
	private String login;

	@Column(name = "password")
	private String password;

	@Column(name = "email")
	private String email;

	@Column(name = "role")
	@Enumerated(EnumType.STRING)
	private UserRole role;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "default_project_id")
	private Project defaultProject;

	@Column(name = "full_name")
	private String fullName;

	@Column(name = "expired")
	private boolean isExpired;

	@Type(type = "jsonb")
	@Column(name = "metadata")
	private MetaData metadata;

	@Column(name = "photo_path")
	private String photoPath;

	@Column(name = "type")
	private UserType userType;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "project")
	@Fetch(value = FetchMode.JOIN)
	private Set<ProjectUser> projects;

	public User() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public UserRole getRole() {
		return role;
	}

	public void setRole(UserRole role) {
		this.role = role;
	}

	public Set<ProjectUser> getProjects() {
		return projects;
	}

	public void setProjects(Set<ProjectUser> projects) {
		this.projects = projects;
	}

	public Project getDefaultProject() {
		return this.defaultProject;
	}

	public void setDefaultProject(Project defaultProjectId) {
		this.defaultProject = defaultProjectId;
	}

	public String getFullName() {
		return this.fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public boolean isExpired() {
		return isExpired;
	}

	public void setExpired(boolean expired) {
		isExpired = expired;
	}

	public String getPhotoPath() {
		return photoPath;
	}

	public void setPhotoPath(String photoPath) {
		this.photoPath = photoPath;
	}

	public UserType getUserType() {
		return userType;
	}

	public void setUserType(UserType userType) {
		this.userType = userType;
	}

	public MetaData getMetadata() {
		return metadata;
	}

	public void setMetadata(MetaData metadata) {
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
		User user = (User) o;
		return isExpired == user.isExpired && Objects.equals(id, user.id) && Objects.equals(login, user.login) && Objects.equals(
				password,
				user.password
		) && Objects.equals(email, user.email) && role == user.role && Objects.equals(defaultProject, user.defaultProject)
				&& Objects.equals(fullName, user.fullName) && Objects.equals(metadata, user.metadata) && Objects.equals(
				photoPath, user.photoPath) && userType == user.userType;
	}

	@Override
	public int hashCode() {

		return Objects.hash(id, login, password, email, role, defaultProject, fullName, isExpired, metadata, photoPath, userType);
	}

}