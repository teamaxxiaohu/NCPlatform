package com.gov.nc.utils;


/**
 * StringUtil  -- Provide some commonly used methods
 * @author Vincent
 * @version 1.0
 *
 */
public class StringUtil {

    /**
     * Whether the given String object is blank or not.
     * @param str  String object to validate.
     * @return <code>true</code> blank , <code>false</code> not blank
     */
    public static boolean isBlank(String str){
        if(null == str || "".equals(str) || "NULL".equalsIgnoreCase(str)){
            return true;
        }
        return false;
    }

    /**
     * Whether the given String object is blank or not.
     * @param str  String object to validate.
     * @return <code>true</code> not blank , <code>false</code> blank
     */
    public static boolean isNotBlank(String str){
        return !isBlank(str);
    }

    /**
     * Given two variables are equal or not.
     * @param textA
     * @param textB
     * @return <code>true</code> equal , <code>false</code> not equal
     */
    public static boolean isEqual(String textA ,String textB){
        boolean rt=false;
        try {
            rt= textA.equals(textB);
        } catch (NullPointerException e) {
            try {
                rt=textB.equals(textA);
            } catch (NullPointerException e2) {
                rt=true;
            }
        }
        return rt;
    }

    public static boolean hasLength(String text) {
        if (isBlank(text)) {
            return false;
        }
        if (text.length()>0) {
            return true;
        }else {
            return false;
        }
    }
    /**
     * convert Object to String.
     * @param object
     * @return
     */
    public static String objectToString(Object object) {
        String rt=null;
        try {
            rt=object.toString();
        } catch (NullPointerException e) {
        }
        return rt;
    }
}