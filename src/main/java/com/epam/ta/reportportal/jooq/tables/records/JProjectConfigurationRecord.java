/*
 * This file is generated by jOOQ.
*/
package com.epam.ta.reportportal.jooq.tables.records;

import com.epam.ta.reportportal.jooq.enums.JProjectTypeEnum;
import com.epam.ta.reportportal.jooq.tables.JProjectConfiguration;
import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record9;
import org.jooq.Row9;
import org.jooq.impl.UpdatableRecordImpl;

import javax.annotation.Generated;
import java.sql.Timestamp;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.10.5"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class JProjectConfigurationRecord extends UpdatableRecordImpl<JProjectConfigurationRecord>
		implements Record9<Long, JProjectTypeEnum, Object, Object, Object, Boolean, Object, Long, Timestamp> {

	private static final long serialVersionUID = 429425007;

    /**
     * Setter for <code>public.project_configuration.id</code>.
     */
    public void setId(Long value) {
        set(0, value);
    }

    /**
     * Getter for <code>public.project_configuration.id</code>.
     */
    public Long getId() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>public.project_configuration.project_type</code>.
     */
    public void setProjectType(JProjectTypeEnum value) {
        set(1, value);
    }

    /**
     * Getter for <code>public.project_configuration.project_type</code>.
     */
    public JProjectTypeEnum getProjectType() {
        return (JProjectTypeEnum) get(1);
    }

    /**
     * @deprecated Unknown data type. Please define an explicit {@link org.jooq.Binding} to specify how this type should be handled. Deprecation can be turned off using <deprecationOnUnknownTypes/> in your code generator configuration.
     */
	@java.lang.Deprecated
	public void setInterruptTimeout(Object value) {
        set(2, value);
    }

    /**
     * @deprecated Unknown data type. Please define an explicit {@link org.jooq.Binding} to specify how this type should be handled. Deprecation can be turned off using <deprecationOnUnknownTypes/> in your code generator configuration.
     */
	@java.lang.Deprecated
	public Object getInterruptTimeout() {
        return get(2);
    }

    /**
     * @deprecated Unknown data type. Please define an explicit {@link org.jooq.Binding} to specify how this type should be handled. Deprecation can be turned off using <deprecationOnUnknownTypes/> in your code generator configuration.
     */
	@java.lang.Deprecated
	public void setKeepLogsInterval(Object value) {
        set(3, value);
    }

    /**
     * @deprecated Unknown data type. Please define an explicit {@link org.jooq.Binding} to specify how this type should be handled. Deprecation can be turned off using <deprecationOnUnknownTypes/> in your code generator configuration.
     */
	@java.lang.Deprecated
	public Object getKeepLogsInterval() {
        return get(3);
    }

    /**
     * @deprecated Unknown data type. Please define an explicit {@link org.jooq.Binding} to specify how this type should be handled. Deprecation can be turned off using <deprecationOnUnknownTypes/> in your code generator configuration.
     */
	@java.lang.Deprecated
	public void setKeepScreenshotsInterval(Object value) {
        set(4, value);
    }

    /**
     * @deprecated Unknown data type. Please define an explicit {@link org.jooq.Binding} to specify how this type should be handled. Deprecation can be turned off using <deprecationOnUnknownTypes/> in your code generator configuration.
     */
	@java.lang.Deprecated
	public Object getKeepScreenshotsInterval() {
        return get(4);
    }

    /**
     * Setter for <code>public.project_configuration.aa_enabled</code>.
     */
    public void setAaEnabled(Boolean value) {
        set(5, value);
    }

    /**
     * Getter for <code>public.project_configuration.aa_enabled</code>.
     */
    public Boolean getAaEnabled() {
        return (Boolean) get(5);
    }

    /**
     * @deprecated Unknown data type. Please define an explicit {@link org.jooq.Binding} to specify how this type should be handled. Deprecation can be turned off using <deprecationOnUnknownTypes/> in your code generator configuration.
     */
	@java.lang.Deprecated
	public void setMetadata(Object value) {
        set(6, value);
    }

    /**
     * @deprecated Unknown data type. Please define an explicit {@link org.jooq.Binding} to specify how this type should be handled. Deprecation can be turned off using <deprecationOnUnknownTypes/> in your code generator configuration.
     */
	@java.lang.Deprecated
	public Object getMetadata() {
        return get(6);
    }

    /**
     * Setter for <code>public.project_configuration.email_configuration_id</code>.
     */
    public void setEmailConfigurationId(Long value) {
        set(7, value);
    }

    /**
     * Getter for <code>public.project_configuration.email_configuration_id</code>.
     */
    public Long getEmailConfigurationId() {
        return (Long) get(7);
    }

    /**
     * Setter for <code>public.project_configuration.created_on</code>.
     */
    public void setCreatedOn(Timestamp value) {
        set(8, value);
    }

    /**
     * Getter for <code>public.project_configuration.created_on</code>.
     */
    public Timestamp getCreatedOn() {
        return (Timestamp) get(8);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Record1<Long> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record9 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row9<Long, JProjectTypeEnum, Object, Object, Object, Boolean, Object, Long, Timestamp> fieldsRow() {
        return (Row9) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row9<Long, JProjectTypeEnum, Object, Object, Object, Boolean, Object, Long, Timestamp> valuesRow() {
        return (Row9) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field1() {
        return JProjectConfiguration.PROJECT_CONFIGURATION.ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<JProjectTypeEnum> field2() {
        return JProjectConfiguration.PROJECT_CONFIGURATION.PROJECT_TYPE;
    }

    /**
     * @deprecated Unknown data type. Please define an explicit {@link org.jooq.Binding} to specify how this type should be handled. Deprecation can be turned off using <deprecationOnUnknownTypes/> in your code generator configuration.
     */
	@java.lang.Deprecated
	@Override
    public Field<Object> field3() {
        return JProjectConfiguration.PROJECT_CONFIGURATION.INTERRUPT_TIMEOUT;
    }

    /**
     * @deprecated Unknown data type. Please define an explicit {@link org.jooq.Binding} to specify how this type should be handled. Deprecation can be turned off using <deprecationOnUnknownTypes/> in your code generator configuration.
     */
	@java.lang.Deprecated
	@Override
    public Field<Object> field4() {
        return JProjectConfiguration.PROJECT_CONFIGURATION.KEEP_LOGS_INTERVAL;
    }

    /**
     * @deprecated Unknown data type. Please define an explicit {@link org.jooq.Binding} to specify how this type should be handled. Deprecation can be turned off using <deprecationOnUnknownTypes/> in your code generator configuration.
     */
	@java.lang.Deprecated
	@Override
    public Field<Object> field5() {
        return JProjectConfiguration.PROJECT_CONFIGURATION.KEEP_SCREENSHOTS_INTERVAL;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Boolean> field6() {
        return JProjectConfiguration.PROJECT_CONFIGURATION.AA_ENABLED;
    }

    /**
     * @deprecated Unknown data type. Please define an explicit {@link org.jooq.Binding} to specify how this type should be handled. Deprecation can be turned off using <deprecationOnUnknownTypes/> in your code generator configuration.
     */
	@java.lang.Deprecated
	@Override
    public Field<Object> field7() {
        return JProjectConfiguration.PROJECT_CONFIGURATION.METADATA;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field8() {
        return JProjectConfiguration.PROJECT_CONFIGURATION.EMAIL_CONFIGURATION_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Timestamp> field9() {
        return JProjectConfiguration.PROJECT_CONFIGURATION.CREATED_ON;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long component1() {
        return getId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public JProjectTypeEnum component2() {
        return getProjectType();
    }

    /**
     * @deprecated Unknown data type. Please define an explicit {@link org.jooq.Binding} to specify how this type should be handled. Deprecation can be turned off using <deprecationOnUnknownTypes/> in your code generator configuration.
     */
	@java.lang.Deprecated
	@Override
    public Object component3() {
        return getInterruptTimeout();
    }

    /**
     * @deprecated Unknown data type. Please define an explicit {@link org.jooq.Binding} to specify how this type should be handled. Deprecation can be turned off using <deprecationOnUnknownTypes/> in your code generator configuration.
     */
	@java.lang.Deprecated
	@Override
    public Object component4() {
        return getKeepLogsInterval();
    }

    /**
     * @deprecated Unknown data type. Please define an explicit {@link org.jooq.Binding} to specify how this type should be handled. Deprecation can be turned off using <deprecationOnUnknownTypes/> in your code generator configuration.
     */
	@java.lang.Deprecated
	@Override
    public Object component5() {
        return getKeepScreenshotsInterval();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Boolean component6() {
        return getAaEnabled();
    }

    /**
     * @deprecated Unknown data type. Please define an explicit {@link org.jooq.Binding} to specify how this type should be handled. Deprecation can be turned off using <deprecationOnUnknownTypes/> in your code generator configuration.
     */
	@java.lang.Deprecated
	@Override
    public Object component7() {
        return getMetadata();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long component8() {
        return getEmailConfigurationId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp component9() {
        return getCreatedOn();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long value1() {
        return getId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public JProjectTypeEnum value2() {
        return getProjectType();
    }

    /**
     * @deprecated Unknown data type. Please define an explicit {@link org.jooq.Binding} to specify how this type should be handled. Deprecation can be turned off using <deprecationOnUnknownTypes/> in your code generator configuration.
     */
	@java.lang.Deprecated
	@Override
    public Object value3() {
        return getInterruptTimeout();
    }

    /**
     * @deprecated Unknown data type. Please define an explicit {@link org.jooq.Binding} to specify how this type should be handled. Deprecation can be turned off using <deprecationOnUnknownTypes/> in your code generator configuration.
     */
	@java.lang.Deprecated
	@Override
    public Object value4() {
        return getKeepLogsInterval();
    }

    /**
     * @deprecated Unknown data type. Please define an explicit {@link org.jooq.Binding} to specify how this type should be handled. Deprecation can be turned off using <deprecationOnUnknownTypes/> in your code generator configuration.
     */
	@java.lang.Deprecated
	@Override
    public Object value5() {
        return getKeepScreenshotsInterval();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Boolean value6() {
        return getAaEnabled();
    }

    /**
     * @deprecated Unknown data type. Please define an explicit {@link org.jooq.Binding} to specify how this type should be handled. Deprecation can be turned off using <deprecationOnUnknownTypes/> in your code generator configuration.
     */
	@java.lang.Deprecated
	@Override
    public Object value7() {
        return getMetadata();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long value8() {
        return getEmailConfigurationId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp value9() {
        return getCreatedOn();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public JProjectConfigurationRecord value1(Long value) {
        setId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public JProjectConfigurationRecord value2(JProjectTypeEnum value) {
        setProjectType(value);
        return this;
    }

    /**
     * @deprecated Unknown data type. Please define an explicit {@link org.jooq.Binding} to specify how this type should be handled. Deprecation can be turned off using <deprecationOnUnknownTypes/> in your code generator configuration.
     */
	@java.lang.Deprecated
	@Override
    public JProjectConfigurationRecord value3(Object value) {
        setInterruptTimeout(value);
        return this;
    }

    /**
     * @deprecated Unknown data type. Please define an explicit {@link org.jooq.Binding} to specify how this type should be handled. Deprecation can be turned off using <deprecationOnUnknownTypes/> in your code generator configuration.
     */
	@java.lang.Deprecated
	@Override
    public JProjectConfigurationRecord value4(Object value) {
        setKeepLogsInterval(value);
        return this;
    }

    /**
     * @deprecated Unknown data type. Please define an explicit {@link org.jooq.Binding} to specify how this type should be handled. Deprecation can be turned off using <deprecationOnUnknownTypes/> in your code generator configuration.
     */
	@java.lang.Deprecated
	@Override
    public JProjectConfigurationRecord value5(Object value) {
        setKeepScreenshotsInterval(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public JProjectConfigurationRecord value6(Boolean value) {
        setAaEnabled(value);
        return this;
    }

    /**
     * @deprecated Unknown data type. Please define an explicit {@link org.jooq.Binding} to specify how this type should be handled. Deprecation can be turned off using <deprecationOnUnknownTypes/> in your code generator configuration.
     */
	@java.lang.Deprecated
	@Override
    public JProjectConfigurationRecord value7(Object value) {
        setMetadata(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public JProjectConfigurationRecord value8(Long value) {
        setEmailConfigurationId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public JProjectConfigurationRecord value9(Timestamp value) {
        setCreatedOn(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public JProjectConfigurationRecord values(Long value1, JProjectTypeEnum value2, Object value3, Object value4, Object value5, Boolean value6, Object value7, Long value8, Timestamp value9) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        value8(value8);
        value9(value9);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached JProjectConfigurationRecord
     */
    public JProjectConfigurationRecord() {
        super(JProjectConfiguration.PROJECT_CONFIGURATION);
    }

    /**
     * Create a detached, initialised JProjectConfigurationRecord
     */
    public JProjectConfigurationRecord(Long id, JProjectTypeEnum projectType, Object interruptTimeout, Object keepLogsInterval, Object keepScreenshotsInterval, Boolean aaEnabled, Object metadata, Long emailConfigurationId, Timestamp createdOn) {
        super(JProjectConfiguration.PROJECT_CONFIGURATION);

        set(0, id);
        set(1, projectType);
        set(2, interruptTimeout);
        set(3, keepLogsInterval);
        set(4, keepScreenshotsInterval);
        set(5, aaEnabled);
        set(6, metadata);
        set(7, emailConfigurationId);
        set(8, createdOn);
    }
}