/*
 * This file is generated by jOOQ.
*/
package com.epam.ta.reportportal.jooq.tables;


import com.epam.ta.reportportal.jooq.Indexes;
import com.epam.ta.reportportal.jooq.JPublic;
import com.epam.ta.reportportal.jooq.Keys;
import com.epam.ta.reportportal.jooq.tables.records.JProjectAnalyzerConfigurationRecord;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Identity;
import org.jooq.Index;
import org.jooq.Name;
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
        "jOOQ version:3.10.5"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class JProjectAnalyzerConfiguration extends TableImpl<JProjectAnalyzerConfigurationRecord> {

    private static final long serialVersionUID = 1944002201;

    /**
     * The reference instance of <code>public.project_analyzer_configuration</code>
     */
    public static final JProjectAnalyzerConfiguration PROJECT_ANALYZER_CONFIGURATION = new JProjectAnalyzerConfiguration();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<JProjectAnalyzerConfigurationRecord> getRecordType() {
        return JProjectAnalyzerConfigurationRecord.class;
    }

    /**
     * The column <code>public.project_analyzer_configuration.id</code>.
     */
    public final TableField<JProjectAnalyzerConfigurationRecord, Long> ID = createField("id", org.jooq.impl.SQLDataType.BIGINT.nullable(false).defaultValue(org.jooq.impl.DSL.field("nextval('project_analyzer_configuration_id_seq'::regclass)", org.jooq.impl.SQLDataType.BIGINT)), this, "");

    /**
     * The column <code>public.project_analyzer_configuration.min_doc_freq</code>.
     */
    public final TableField<JProjectAnalyzerConfigurationRecord, Integer> MIN_DOC_FREQ = createField("min_doc_freq", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>public.project_analyzer_configuration.min_term_freq</code>.
     */
    public final TableField<JProjectAnalyzerConfigurationRecord, Integer> MIN_TERM_FREQ = createField("min_term_freq", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>public.project_analyzer_configuration.min_should_match</code>.
     */
    public final TableField<JProjectAnalyzerConfigurationRecord, Integer> MIN_SHOULD_MATCH = createField("min_should_match", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>public.project_analyzer_configuration.number_of_log_lines</code>.
     */
    public final TableField<JProjectAnalyzerConfigurationRecord, Integer> NUMBER_OF_LOG_LINES = createField("number_of_log_lines", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>public.project_analyzer_configuration.indexing_running</code>.
     */
    public final TableField<JProjectAnalyzerConfigurationRecord, Boolean> INDEXING_RUNNING = createField("indexing_running", org.jooq.impl.SQLDataType.BOOLEAN, this, "");

    /**
     * The column <code>public.project_analyzer_configuration.enabled</code>.
     */
    public final TableField<JProjectAnalyzerConfigurationRecord, Boolean> ENABLED = createField("enabled", org.jooq.impl.SQLDataType.BOOLEAN, this, "");

    /**
     * The column <code>public.project_analyzer_configuration.analyzermode</code>.
     */
    public final TableField<JProjectAnalyzerConfigurationRecord, String> ANALYZERMODE = createField("analyzermode", org.jooq.impl.SQLDataType.VARCHAR(64), this, "");

    /**
     * Create a <code>public.project_analyzer_configuration</code> table reference
     */
    public JProjectAnalyzerConfiguration() {
        this(DSL.name("project_analyzer_configuration"), null);
    }

    /**
     * Create an aliased <code>public.project_analyzer_configuration</code> table reference
     */
    public JProjectAnalyzerConfiguration(String alias) {
        this(DSL.name(alias), PROJECT_ANALYZER_CONFIGURATION);
    }

    /**
     * Create an aliased <code>public.project_analyzer_configuration</code> table reference
     */
    public JProjectAnalyzerConfiguration(Name alias) {
        this(alias, PROJECT_ANALYZER_CONFIGURATION);
    }

    private JProjectAnalyzerConfiguration(Name alias, Table<JProjectAnalyzerConfigurationRecord> aliased) {
        this(alias, aliased, null);
    }

    private JProjectAnalyzerConfiguration(Name alias, Table<JProjectAnalyzerConfigurationRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, "");
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
        return Arrays.<Index>asList(Indexes.PROJECT_ANALYZER_CONFIGURATION_PK);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Identity<JProjectAnalyzerConfigurationRecord, Long> getIdentity() {
        return Keys.IDENTITY_PROJECT_ANALYZER_CONFIGURATION;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<JProjectAnalyzerConfigurationRecord> getPrimaryKey() {
        return Keys.PROJECT_ANALYZER_CONFIGURATION_PK;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<JProjectAnalyzerConfigurationRecord>> getKeys() {
        return Arrays.<UniqueKey<JProjectAnalyzerConfigurationRecord>>asList(Keys.PROJECT_ANALYZER_CONFIGURATION_PK);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public JProjectAnalyzerConfiguration as(String alias) {
        return new JProjectAnalyzerConfiguration(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public JProjectAnalyzerConfiguration as(Name alias) {
        return new JProjectAnalyzerConfiguration(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public JProjectAnalyzerConfiguration rename(String name) {
        return new JProjectAnalyzerConfiguration(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public JProjectAnalyzerConfiguration rename(Name name) {
        return new JProjectAnalyzerConfiguration(name, null);
    }
}
