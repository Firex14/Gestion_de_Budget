package com.yaba.monbudget.utils.validations;

public class PatternValidation {
    public static final String EMAIL_PATTERN = "^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$";
    public static final String PHONE_NUMBER_PATTERN = "^(00221)?(77|78|75|76|33)\\d{7}$";
    public static final String PASSWORD_PATTERN = "^[a-zA-Z0-9@/#-~_\\?!.]{4,255}$";
    public static final String DATE_PATTERN = "yyyy-MM-dd hh:mm:ss";
}
