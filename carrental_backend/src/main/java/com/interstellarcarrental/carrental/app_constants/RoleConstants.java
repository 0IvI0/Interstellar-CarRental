package com.interstellarcarrental.carrental.app_constants;

public class RoleConstants {

    public static final String ROLE_EMPLOYEE = "EMPLOYEE";
    public static final String ROLE_CUSTOMER = "CUSTOMER";

    public static final String ROLE_EMPL_DESCRIPTION = "Employee of the company. The employee can manage - view, create, update, delete, lock and unlock - customers. The employee can manage - view, create, update, delete - cars.";

    public static final String ROLE_CUST_DESCRIPTION = "Customer of the company. The customer is able to register, to login or logout. The customer is able to view the cars for rent. The customer can rent one or more cars.";

    
    private RoleConstants() {
        throw new IllegalStateException("Class for static constants");
    }
}