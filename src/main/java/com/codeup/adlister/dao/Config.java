package com.codeup.adlister.dao;

class Config {
    public static String getUrl() {
        return "jdbc:mysql://localhost/adlister_db?serverTimezone=UTC&useSSL=false";
    }
    public static String getUsername() {
        return "someuser";
    }
    public static String getPassword() {
        return "strongpassword";
    }


}