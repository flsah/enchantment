package com.enchantment.eaas;

import org.apache.commons.lang.builder.HashCodeBuilder;

/**
 * Created by liushuang on 9/22/16.
 */
public class Utils {
    public static synchronized String buildHashCode(Object obj) {
        int hashCode = Math.abs(HashCodeBuilder.reflectionHashCode(obj));

        return "0101".concat(Integer.toString(hashCode));
    }
}
