/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.util.regex.Pattern;

/**
 *
 * @author PhamDai
 */
public class RegexExpression {
    
    private static final String REGEX_USERNAME = "^[\\w_\\.]{6,25}$";
    private static final String REGEX_PASSWORD = "^([\\w_\\.!@#$%^&*()]+){6,25}$";
    private static final String REGEX_DATETIME = "^\\d{4}\\-(0[1-9]|1[012])\\-(0[1-9]|[12][0-9]|3[01])$";
    private static final String REGEX_PHONENUMBER = "^\\d{10}$";
    private static final String REGEX_CNMD ="^(\\d{9})|(\\d{12})$";
    
    public static boolean checkUserName(String userName){
        return Pattern.compile(REGEX_USERNAME).matcher(userName).matches();
    }
    
    
    public static boolean checkPassWord(String passWord){
        return Pattern.compile(REGEX_PASSWORD).matcher(passWord).matches();
    }
    
    public static String toUpperCaseFirstCharacter(String text){
        StringBuilder upperCase = new StringBuilder();
        String[] arr = text.split(" ");
        for(String s:arr){
            s = s.substring(0,1).toUpperCase() + s.substring(1);
            upperCase.append(s);
            upperCase.append(" ");
        }
        return upperCase.toString();
    }
    
    public static boolean checkDateTime(String dateTime){
        return Pattern.compile(REGEX_DATETIME).matcher(dateTime).matches();
    } 
    
    public static boolean checkPhoneNumber(String phoneNumber){
        return Pattern.compile(REGEX_PHONENUMBER).matcher(phoneNumber).matches();
    }
    
    public static boolean checkcmnd(String id){
        return Pattern.compile(REGEX_CNMD).matcher(id).matches();
    }
    static boolean isValidemail(String email) {
      String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
      return email.matches(regex);}
}
