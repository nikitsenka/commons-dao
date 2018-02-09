/*
 * This file is generated by jOOQ.
*/
package com.epam.ta.reportportal.jooq.tables.records;

import com.epam.ta.reportportal.jooq.enums.AccessTokenTypeEnum;
import com.epam.ta.reportportal.jooq.tables.OauthAccessToken;
import org.jooq.Field;
import org.jooq.Record2;
import org.jooq.Record3;
import org.jooq.Row3;
import org.jooq.impl.UpdatableRecordImpl;

import javax.annotation.Generated;
import javax.persistence.*;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.10.4"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
@Entity
@Table(name = "oauth_access_token", schema = "public", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"user_id", "token_type"})
}, indexes = {
    @Index(name = "access_tokens_pk", unique = true, columnList = "user_id ASC, token_type ASC")
})
public class OauthAccessTokenRecord extends UpdatableRecordImpl<OauthAccessTokenRecord> implements Record3<Long, String, AccessTokenTypeEnum> {

    private static final long serialVersionUID = 1853465505;

    /**
     * Setter for <code>public.oauth_access_token.user_id</code>.
     */
    public void setUserId(Long value) {
        set(0, value);
    }

    /**
     * Getter for <code>public.oauth_access_token.user_id</code>.
     */
    @Column(name = "user_id", nullable = false, precision = 64)
    public Long getUserId() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>public.oauth_access_token.token</code>.
     */
    public void setToken(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>public.oauth_access_token.token</code>.
     */
    @Column(name = "token", nullable = false)
    public String getToken() {
        return (String) get(1);
    }

    /**
     * Setter for <code>public.oauth_access_token.token_type</code>.
     */
    public void setTokenType(AccessTokenTypeEnum value) {
        set(2, value);
    }

    /**
     * Getter for <code>public.oauth_access_token.token_type</code>.
     */
    @Column(name = "token_type", nullable = false)
    public AccessTokenTypeEnum getTokenType() {
        return (AccessTokenTypeEnum) get(2);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Record2<Long, AccessTokenTypeEnum> key() {
        return (Record2) super.key();
    }

    // -------------------------------------------------------------------------
    // Record3 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row3<Long, String, AccessTokenTypeEnum> fieldsRow() {
        return (Row3) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row3<Long, String, AccessTokenTypeEnum> valuesRow() {
        return (Row3) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field1() {
        return OauthAccessToken.OAUTH_ACCESS_TOKEN.USER_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field2() {
        return OauthAccessToken.OAUTH_ACCESS_TOKEN.TOKEN;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<AccessTokenTypeEnum> field3() {
        return OauthAccessToken.OAUTH_ACCESS_TOKEN.TOKEN_TYPE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long component1() {
        return getUserId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component2() {
        return getToken();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AccessTokenTypeEnum component3() {
        return getTokenType();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long value1() {
        return getUserId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value2() {
        return getToken();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AccessTokenTypeEnum value3() {
        return getTokenType();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public OauthAccessTokenRecord value1(Long value) {
        setUserId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public OauthAccessTokenRecord value2(String value) {
        setToken(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public OauthAccessTokenRecord value3(AccessTokenTypeEnum value) {
        setTokenType(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public OauthAccessTokenRecord values(Long value1, String value2, AccessTokenTypeEnum value3) {
        value1(value1);
        value2(value2);
        value3(value3);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached OauthAccessTokenRecord
     */
    public OauthAccessTokenRecord() {
        super(OauthAccessToken.OAUTH_ACCESS_TOKEN);
    }

    /**
     * Create a detached, initialised OauthAccessTokenRecord
     */
    public OauthAccessTokenRecord(Long userId, String token, AccessTokenTypeEnum tokenType) {
        super(OauthAccessToken.OAUTH_ACCESS_TOKEN);

        set(0, userId);
        set(1, token);
        set(2, tokenType);
    }
}