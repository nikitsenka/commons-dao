/*
 * This file is generated by jOOQ.
*/
package com.epam.ta.reportportal.jooq.tables.records;

import com.epam.ta.reportportal.jooq.tables.JWidgetOptionValue;
import org.jooq.Field;
import org.jooq.Record2;
import org.jooq.Row2;
import org.jooq.impl.TableRecordImpl;

import javax.annotation.Generated;


/**
 * This class is generated by jOOQ.
 */
@Generated(value = { "http://www.jooq.org", "jOOQ version:3.10.5" }, comments = "This class is generated by jOOQ")
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class JWidgetOptionValueRecord extends TableRecordImpl<JWidgetOptionValueRecord> implements Record2<Long, String> {

	private static final long serialVersionUID = 308375955;

	/**
	 * Setter for <code>public.widget_option_value.id</code>.
	 */
	public void setId(Long value) {
		set(0, value);
	}

	/**
	 * Getter for <code>public.widget_option_value.id</code>.
	 */
	public Long getId() {
		return (Long) get(0);
	}

	/**
	 * Setter for <code>public.widget_option_value.value</code>.
	 */
	public void setValue(String value) {
		set(1, value);
	}

	/**
	 * Getter for <code>public.widget_option_value.value</code>.
	 */
	public String getValue() {
		return (String) get(1);
	}

	// -------------------------------------------------------------------------
	// Record2 type implementation
	// -------------------------------------------------------------------------

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Row2<Long, String> fieldsRow() {
		return (Row2) super.fieldsRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Row2<Long, String> valuesRow() {
		return (Row2) super.valuesRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<Long> field1() {
		return JWidgetOptionValue.WIDGET_OPTION_VALUE.ID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<String> field2() {
		return JWidgetOptionValue.WIDGET_OPTION_VALUE.VALUE;
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
	public JWidgetOptionValueRecord value1(Long value) {
		setId(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public JWidgetOptionValueRecord value2(String value) {
		setValue(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public JWidgetOptionValueRecord values(Long value1, String value2) {
		value1(value1);
		value2(value2);
		return this;
	}

	// -------------------------------------------------------------------------
	// Constructors
	// -------------------------------------------------------------------------

	/**
	 * Create a detached JWidgetOptionValueRecord
	 */
	public JWidgetOptionValueRecord() {
		super(JWidgetOptionValue.WIDGET_OPTION_VALUE);
	}

	/**
	 * Create a detached, initialised JWidgetOptionValueRecord
	 */
	public JWidgetOptionValueRecord(Long id, String value) {
		super(JWidgetOptionValue.WIDGET_OPTION_VALUE);

		set(0, id);
		set(1, value);
	}
}