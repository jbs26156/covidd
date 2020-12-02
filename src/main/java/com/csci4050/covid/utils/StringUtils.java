package com.csci4050.covid.utils;

public class StringUtils {
    public static boolean isYes(String string) {
        String str = string.toLowerCase();
        return str.equals( "yes" );
    }

    public static boolean isNo(String string) {
        String str = string.toLowerCase();
        return str.equals( "no" );
    }

    public static boolean isEmptyString(String string) {
        return string.equals( "" );
    }

    public static boolean isStringNull(String string) {
        return string == null;
    }

    public static boolean yesOrNo(String string) {
        return isYes( string ) || isNo( string );
    }

    public static boolean isEmptyOrNull(String string) {
        return isEmptyString( string ) || isStringNull( string );
    }
}
