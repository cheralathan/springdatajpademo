package com.endurance.springdatajpademo.util;

public final class  Constants {

    private Constants() { }

    public static final String CUSTOMER_TABLE = "Customers";
    public static final String ADDRESS_TABLE = "Addresses";
    public static final String COLMN_ID = "id";
    public static final String COLMN_FIRST_NAME = "first_name";
    public static final String COLMN_LAST_NAME = "last_name";
    public static final String COLMN_EMAIL = "email";
    public static final String COLMN_CUSTOMER_ID = "customer_id";
    public static final String ADDRESS_BY_CUST_ID = "customerIdReference";

    public static final String BASE_URL = "/customers";
    public static final String GET_LAST_NAME = "/{lastName}";

    public static final String MSG_INPUT_MISSING = " - Required method input parameter validation failed";

}
