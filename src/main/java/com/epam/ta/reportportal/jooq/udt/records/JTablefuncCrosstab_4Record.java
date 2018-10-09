/*
 * This file is generated by jOOQ.
 */
package com.epam.ta.reportportal.jooq.udt.records;


import com.epam.ta.reportportal.jooq.udt.JTablefuncCrosstab_4;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record5;
import org.jooq.Row5;
import org.jooq.impl.UDTRecordImpl;


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
public class JTablefuncCrosstab_4Record extends UDTRecordImpl<JTablefuncCrosstab_4Record> implements Record5<String, String, String, String, String> {

    private static final long serialVersionUID = 1792608221;

    /**
     * Setter for <code>public.tablefunc_crosstab_4.row_name</code>.
     */
    public void setRowName(String value) {
        set(0, value);
    }

    /**
     * Getter for <code>public.tablefunc_crosstab_4.row_name</code>.
     */
    public String getRowName() {
        return (String) get(0);
    }

    /**
     * Setter for <code>public.tablefunc_crosstab_4.category_1</code>.
     */
    public void setCategory_1(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>public.tablefunc_crosstab_4.category_1</code>.
     */
    public String getCategory_1() {
        return (String) get(1);
    }

    /**
     * Setter for <code>public.tablefunc_crosstab_4.category_2</code>.
     */
    public void setCategory_2(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>public.tablefunc_crosstab_4.category_2</code>.
     */
    public String getCategory_2() {
        return (String) get(2);
    }

    /**
     * Setter for <code>public.tablefunc_crosstab_4.category_3</code>.
     */
    public void setCategory_3(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>public.tablefunc_crosstab_4.category_3</code>.
     */
    public String getCategory_3() {
        return (String) get(3);
    }

    /**
     * Setter for <code>public.tablefunc_crosstab_4.category_4</code>.
     */
    public void setCategory_4(String value) {
        set(4, value);
    }

    /**
     * Getter for <code>public.tablefunc_crosstab_4.category_4</code>.
     */
    public String getCategory_4() {
        return (String) get(4);
    }

    // -------------------------------------------------------------------------
    // Record5 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row5<String, String, String, String, String> fieldsRow() {
        return (Row5) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row5<String, String, String, String, String> valuesRow() {
        return (Row5) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field1() {
        return JTablefuncCrosstab_4.ROW_NAME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field2() {
        return JTablefuncCrosstab_4.CATEGORY_1;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field3() {
        return JTablefuncCrosstab_4.CATEGORY_2;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field4() {
        return JTablefuncCrosstab_4.CATEGORY_3;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field5() {
        return JTablefuncCrosstab_4.CATEGORY_4;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component1() {
        return getRowName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component2() {
        return getCategory_1();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component3() {
        return getCategory_2();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component4() {
        return getCategory_3();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component5() {
        return getCategory_4();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value1() {
        return getRowName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value2() {
        return getCategory_1();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value3() {
        return getCategory_2();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value4() {
        return getCategory_3();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value5() {
        return getCategory_4();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public JTablefuncCrosstab_4Record value1(String value) {
        setRowName(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public JTablefuncCrosstab_4Record value2(String value) {
        setCategory_1(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public JTablefuncCrosstab_4Record value3(String value) {
        setCategory_2(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public JTablefuncCrosstab_4Record value4(String value) {
        setCategory_3(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public JTablefuncCrosstab_4Record value5(String value) {
        setCategory_4(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public JTablefuncCrosstab_4Record values(String value1, String value2, String value3, String value4, String value5) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached JTablefuncCrosstab_4Record
     */
    public JTablefuncCrosstab_4Record() {
        super(JTablefuncCrosstab_4.TABLEFUNC_CROSSTAB_4);
    }

    /**
     * Create a detached, initialised JTablefuncCrosstab_4Record
     */
    public JTablefuncCrosstab_4Record(String rowName, String category_1, String category_2, String category_3, String category_4) {
        super(JTablefuncCrosstab_4.TABLEFUNC_CROSSTAB_4);

        set(0, rowName);
        set(1, category_1);
        set(2, category_2);
        set(3, category_3);
        set(4, category_4);
    }
}