/*
 * This file is generated by jOOQ.
*/
package com.epam.ta.reportportal.jooq;

import com.epam.ta.reportportal.jooq.routines.UpdateLastLaunchNumber;
import org.jooq.Configuration;
import org.jooq.Field;

import javax.annotation.Generated;


/**
 * Convenience access to all stored procedures and functions in public
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.10.4"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Routines {

    /**
     * @deprecated Unknown data type. Please define an explicit {@link org.jooq.Binding} to specify how this type should be handled. Deprecation can be turned off using <deprecationOnUnknownTypes/> in your code generator configuration.
     */
    @java.lang.Deprecated
    public static Object updateLastLaunchNumber(Configuration configuration) {
        UpdateLastLaunchNumber f = new UpdateLastLaunchNumber();

        f.execute(configuration);
        return f.getReturnValue();
    }

    /**
     * @deprecated Unknown data type. Please define an explicit {@link org.jooq.Binding} to specify how this type should be handled. Deprecation can be turned off using <deprecationOnUnknownTypes/> in your code generator configuration.
     */
    @java.lang.Deprecated
    public static Field<Object> updateLastLaunchNumber() {
        UpdateLastLaunchNumber f = new UpdateLastLaunchNumber();

        return f.asField();
    }
}