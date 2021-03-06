/*
 * Copyright 2016 EPAM Systems
 *
 *
 * This file is part of EPAM Report Portal.
 * https://github.com/reportportal/commons-dao
 *
 * Report Portal is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Report Portal is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Report Portal.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.epam.ta.reportportal.database.entity.settings;

import com.google.common.base.MoreObjects;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * @author Andrei Varabyeu
 */
public class OAuth2LoginDetails implements Serializable {

	private String clientId;

	private String accessTokenUri;

	private String userAuthorizationUri;

	private List<String> scope;

	private String clientSecret;

	private String authenticationScheme;

	private String clientAuthenticationScheme;

	private String grantType;

	private String tokenName = "access_token";

	private Map<String, String> restrictions;

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public String getAccessTokenUri() {
		return accessTokenUri;
	}

	public void setAccessTokenUri(String accessTokenUri) {
		this.accessTokenUri = accessTokenUri;
	}

	public List<String> getScope() {
		return scope;
	}

	public void setScope(List<String> scope) {
		this.scope = scope;
	}

	public String getClientSecret() {
		return clientSecret;
	}

	public void setClientSecret(String clientSecret) {
		this.clientSecret = clientSecret;
	}

	public String getAuthenticationScheme() {
		return authenticationScheme;
	}

	public void setAuthenticationScheme(String authenticationScheme) {
		this.authenticationScheme = authenticationScheme;
	}

	public String getGrantType() {
		return grantType;
	}

	public void setGrantType(String grantType) {
		this.grantType = grantType;
	}

	public String getTokenName() {
		return tokenName;
	}

	public void setTokenName(String tokenName) {
		this.tokenName = tokenName;
	}

	public Map<String, String> getRestrictions() {
		return restrictions;
	}

	public void setRestrictions(Map<String, String> restrictions) {
		this.restrictions = restrictions;
	}

	public String getUserAuthorizationUri() {
		return userAuthorizationUri;
	}

	public void setUserAuthorizationUri(String userAuthorizationUri) {
		this.userAuthorizationUri = userAuthorizationUri;
	}

	public String getClientAuthenticationScheme() {
		return clientAuthenticationScheme;
	}

	public void setClientAuthenticationScheme(String clientAuthenticationScheme) {
		this.clientAuthenticationScheme = clientAuthenticationScheme;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		OAuth2LoginDetails that = (OAuth2LoginDetails) o;
		return Objects.equals(clientId, that.clientId) && Objects.equals(accessTokenUri, that.accessTokenUri)
				&& Objects.equals(userAuthorizationUri, that.userAuthorizationUri) && Objects.equals(scope, that.scope) && Objects
				.equals(clientSecret, that.clientSecret) && Objects.equals(authenticationScheme, that.authenticationScheme) && Objects
				.equals(clientAuthenticationScheme, that.clientAuthenticationScheme) && Objects.equals(grantType, that.grantType) && Objects
				.equals(tokenName, that.tokenName) && Objects.equals(restrictions, that.restrictions);
	}

	@Override
	public int hashCode() {
		return Objects.hash(clientId, accessTokenUri, userAuthorizationUri, scope, clientSecret, authenticationScheme,
				clientAuthenticationScheme, grantType, tokenName, restrictions);
	}

	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this).add("clientId", clientId).add("accessTokenUri", accessTokenUri)
				.add("userAuthorizationUri", userAuthorizationUri).add("scope", scope).add("clientSecret", clientSecret)
				.add("authenticationScheme", authenticationScheme).add("clientAuthenticationScheme", clientAuthenticationScheme)
				.add("grantType", grantType).add("tokenName", tokenName).add("restrictions", restrictions).toString();
	}
}
