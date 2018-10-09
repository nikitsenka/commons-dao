/*
 * This file is generated by jOOQ.
 */
package com.epam.ta.reportportal.jooq.tables;


import com.epam.ta.reportportal.jooq.Indexes;
import com.epam.ta.reportportal.jooq.JPublic;
import com.epam.ta.reportportal.jooq.Keys;
import com.epam.ta.reportportal.jooq.tables.records.JEmailSenderCaseRecord;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.Index;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;


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
public class JEmailSenderCase extends TableImpl<JEmailSenderCaseRecord> {

    private static final long serialVersionUID = -1645354098;

    /**
     * The reference instance of <code>public.email_sender_case</code>
     */
    public static final JEmailSenderCase EMAIL_SENDER_CASE = new JEmailSenderCase();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<JEmailSenderCaseRecord> getRecordType() {
        return JEmailSenderCaseRecord.class;
    }

    /**
     * The column <code>public.email_sender_case.id</code>.
     */
    public final TableField<JEmailSenderCaseRecord, Long> ID = createField("id", org.jooq.impl.SQLDataType.BIGINT.nullable(false).defaultValue(org.jooq.impl.DSL.field("nextval('email_sender_case_id_seq'::regclass)", org.jooq.impl.SQLDataType.BIGINT)), this, "");

    /**
     * The column <code>public.email_sender_case.send_case</code>.
     */
    public final TableField<JEmailSenderCaseRecord, String> SEND_CASE = createField("send_case", org.jooq.impl.SQLDataType.VARCHAR(64), this, "");

    /**
     * The column <code>public.email_sender_case.project_id</code>.
     */
    public final TableField<JEmailSenderCaseRecord, Long> PROJECT_ID = createField("project_id", org.jooq.impl.SQLDataType.BIGINT.nullable(false).defaultValue(org.jooq.impl.DSL.field("nextval('email_sender_case_project_id_seq'::regclass)", org.jooq.impl.SQLDataType.BIGINT)), this, "");

    /**
     * Create a <code>public.email_sender_case</code> table reference
     */
    public JEmailSenderCase() {
        this(DSL.name("email_sender_case"), null);
    }

    /**
     * Create an aliased <code>public.email_sender_case</code> table reference
     */
    public JEmailSenderCase(String alias) {
        this(DSL.name(alias), EMAIL_SENDER_CASE);
    }

    /**
     * Create an aliased <code>public.email_sender_case</code> table reference
     */
    public JEmailSenderCase(Name alias) {
        this(alias, EMAIL_SENDER_CASE);
    }

    private JEmailSenderCase(Name alias, Table<JEmailSenderCaseRecord> aliased) {
        this(alias, aliased, null);
    }

    private JEmailSenderCase(Name alias, Table<JEmailSenderCaseRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""));
    }

    public <O extends Record> JEmailSenderCase(Table<O> child, ForeignKey<O, JEmailSenderCaseRecord> key) {
        super(child, key, EMAIL_SENDER_CASE);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Schema getSchema() {
        return JPublic.PUBLIC;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Index> getIndexes() {
        return Arrays.<Index>asList(Indexes.EMAIL_SENDER_CASE_PK);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Identity<JEmailSenderCaseRecord, Long> getIdentity() {
        return Keys.IDENTITY_EMAIL_SENDER_CASE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<JEmailSenderCaseRecord> getPrimaryKey() {
        return Keys.EMAIL_SENDER_CASE_PK;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<JEmailSenderCaseRecord>> getKeys() {
        return Arrays.<UniqueKey<JEmailSenderCaseRecord>>asList(Keys.EMAIL_SENDER_CASE_PK);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<ForeignKey<JEmailSenderCaseRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<JEmailSenderCaseRecord, ?>>asList(Keys.EMAIL_SENDER_CASE__EMAIL_SENDER_CASE_PROJECT_ID_FKEY);
    }

    public JProject project() {
        return new JProject(this, Keys.EMAIL_SENDER_CASE__EMAIL_SENDER_CASE_PROJECT_ID_FKEY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public JEmailSenderCase as(String alias) {
        return new JEmailSenderCase(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public JEmailSenderCase as(Name alias) {
        return new JEmailSenderCase(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public JEmailSenderCase rename(String name) {
        return new JEmailSenderCase(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public JEmailSenderCase rename(Name name) {
        return new JEmailSenderCase(name, null);
    }
}