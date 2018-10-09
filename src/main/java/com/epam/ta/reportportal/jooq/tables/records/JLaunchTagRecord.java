/*
 * This file is generated by jOOQ.
 */
package com.epam.ta.reportportal.jooq.tables.records;

import com.epam.ta.reportportal.jooq.tables.JLaunchTag;
import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record4;
import org.jooq.Row4;
import org.jooq.impl.UpdatableRecordImpl;

import javax.annotation.Generated;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.11.4"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class JLaunchTagRecord extends UpdatableRecordImpl<JLaunchTagRecord> implements Record4<Long, String, Long, Long> {

    private static final long serialVersionUID = 115615748;

    /**
     * Setter for <code>public.launch_tag.id</code>.
     */
    public void setId(Long value) {
        set(0, value);
    }

    /**
     * Getter for <code>public.launch_tag.id</code>.
     */
    public Long getId() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>public.launch_tag.value</code>.
     */
    public void setValue(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>public.launch_tag.value</code>.
     */
    public String getValue() {
        return (String) get(1);
    }

    /**
     * Setter for <code>public.launch_tag.email_sender_case_id</code>.
     */
    public void setEmailSenderCaseId(Long value) {
        set(2, value);
    }

    /**
     * Getter for <code>public.launch_tag.email_sender_case_id</code>.
     */
    public Long getEmailSenderCaseId() {
        return (Long) get(2);
    }

    /**
     * Setter for <code>public.launch_tag.launch_id</code>.
     */
    public void setLaunchId(Long value) {
        set(3, value);
    }

    /**
     * Getter for <code>public.launch_tag.launch_id</code>.
     */
    public Long getLaunchId() {
        return (Long) get(3);
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
    // Record4 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row4<Long, String, Long, Long> fieldsRow() {
        return (Row4) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row4<Long, String, Long, Long> valuesRow() {
        return (Row4) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field1() {
        return JLaunchTag.LAUNCH_TAG.ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field2() {
        return JLaunchTag.LAUNCH_TAG.VALUE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field3() {
        return JLaunchTag.LAUNCH_TAG.EMAIL_SENDER_CASE_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field4() {
        return JLaunchTag.LAUNCH_TAG.LAUNCH_ID;
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
    public String component2() {
        return getValue();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long component3() {
        return getEmailSenderCaseId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long component4() {
        return getLaunchId();
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
    public String value2() {
        return getValue();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long value3() {
        return getEmailSenderCaseId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long value4() {
        return getLaunchId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public JLaunchTagRecord value1(Long value) {
        setId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public JLaunchTagRecord value2(String value) {
        setValue(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public JLaunchTagRecord value3(Long value) {
        setEmailSenderCaseId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public JLaunchTagRecord value4(Long value) {
        setLaunchId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public JLaunchTagRecord values(Long value1, String value2, Long value3, Long value4) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached JLaunchTagRecord
     */
    public JLaunchTagRecord() {
        super(JLaunchTag.LAUNCH_TAG);
    }

    /**
     * Create a detached, initialised JLaunchTagRecord
     */
    public JLaunchTagRecord(Long id, String value, Long emailSenderCaseId, Long launchId) {
        super(JLaunchTag.LAUNCH_TAG);

        set(0, id);
        set(1, value);
        set(2, emailSenderCaseId);
        set(3, launchId);
    }
}
