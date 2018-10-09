/*
 * This file is generated by jOOQ.
 */
package com.epam.ta.reportportal.jooq.tables;


import com.epam.ta.reportportal.jooq.JPublic;
import com.epam.ta.reportportal.jooq.tables.records.JNormalRandRecord;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
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
public class JNormalRand extends TableImpl<JNormalRandRecord> {

    private static final long serialVersionUID = 227161028;

    /**
     * The reference instance of <code>public.normal_rand</code>
     */
    public static final JNormalRand NORMAL_RAND = new JNormalRand();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<JNormalRandRecord> getRecordType() {
        return JNormalRandRecord.class;
    }

    /**
     * The column <code>public.normal_rand.normal_rand</code>.
     */
    public final TableField<JNormalRandRecord, Double> NORMAL_RAND_ = createField("normal_rand", org.jooq.impl.SQLDataType.DOUBLE, this, "");

    /**
     * Create a <code>public.normal_rand</code> table reference
     */
    public JNormalRand() {
        this(DSL.name("normal_rand"), null);
    }

    /**
     * Create an aliased <code>public.normal_rand</code> table reference
     */
    public JNormalRand(String alias) {
        this(DSL.name(alias), NORMAL_RAND);
    }

    /**
     * Create an aliased <code>public.normal_rand</code> table reference
     */
    public JNormalRand(Name alias) {
        this(alias, NORMAL_RAND);
    }

    private JNormalRand(Name alias, Table<JNormalRandRecord> aliased) {
        this(alias, aliased, new Field[3]);
    }

    private JNormalRand(Name alias, Table<JNormalRandRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""));
    }

    public <O extends Record> JNormalRand(Table<O> child, ForeignKey<O, JNormalRandRecord> key) {
        super(child, key, NORMAL_RAND);
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
    public JNormalRand as(String alias) {
        return new JNormalRand(DSL.name(alias), this, parameters);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public JNormalRand as(Name alias) {
        return new JNormalRand(alias, this, parameters);
    }

    /**
     * Rename this table
     */
    @Override
    public JNormalRand rename(String name) {
        return new JNormalRand(DSL.name(name), null, parameters);
    }

    /**
     * Rename this table
     */
    @Override
    public JNormalRand rename(Name name) {
        return new JNormalRand(name, null, parameters);
    }

    /**
     * Call this table-valued function
     */
    public JNormalRand call(Integer __1, Double __2, Double __3) {
        return new JNormalRand(DSL.name(getName()), null, new Field[] { 
              DSL.val(__1, org.jooq.impl.SQLDataType.INTEGER)
            , DSL.val(__2, org.jooq.impl.SQLDataType.DOUBLE)
            , DSL.val(__3, org.jooq.impl.SQLDataType.DOUBLE)
        });
    }

    /**
     * Call this table-valued function
     */
    public JNormalRand call(Field<Integer> __1, Field<Double> __2, Field<Double> __3) {
        return new JNormalRand(DSL.name(getName()), null, new Field[] { 
              __1
            , __2
            , __3
        });
    }
}