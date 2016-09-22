package com.enchantment.eaas;

/**
 * Created by liushuang on 9/22/16.
 */
public class Constants {
    /* HTTP Response Status Code*/
    public static final int RESPONSE_STATUS_SUC = 1;
    public static final int RESPONSE_STATUS_FAL = 0;

    /* Entity Status Code */
    public static final int STAT_INIT = 0;
    public static final int STAT_VALID   = 1; // binary 0001
    public static final int STAT_LOCK    = 3; // binary 0011
    public static final int STAT_OVERDUE = 5; // binary 0101

    /* Operation Code */
    public static final int OPER_N = 1; // new
    public static final int OPER_M = 2; // modify
    public static final int OPER_R = 3; // remove
    public static final int OPER_S = 9; // super operation

    public static final String TOKEN_CUID = "cuid";
}
