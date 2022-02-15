package com.tomasmartinez.cursobackend.security;

public enum UserPermission {
    PRODUCT_READ("product:read"),
    PRODUCT_WRITE("product:write"),
    CATEGORY_READ("category:read"),
    CATEGORY_WRITE("category:write"),
    USER_READ("user:read"),
    USER_WRITE("user:write");

    private final String permission;

    UserPermission(String permission){
        this.permission = permission;
    }

    public String getPermission(){ return permission; }
}
