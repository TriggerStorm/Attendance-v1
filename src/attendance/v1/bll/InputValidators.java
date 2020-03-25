/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendance.v1.bll;

    import java.io.Serializable;
    import java.util.regex.Matcher;
    import java.util.regex.Pattern;

/**
 *
 * @author Trigger, Filip, Cecillia and Alan
      
 */

public class InputValidators  implements Serializable {
    private static final int MAX_EMAIL_LENGTH = 64;
    private static final String SPECIAL_CHARS = "\\p{Cntrl}\\(\\)<>@,;:'\\\\\\\"\\.\\[\\]";
    private static final String VALID_CHARS = "(\\\\.)|[^\\s" + SPECIAL_CHARS + "]";
    private static final String QUOTED_USER = "(\"(\\\\\"|[^\"])*\")";
    private static final String WORD = "((" + VALID_CHARS + "|')+|" + QUOTED_USER + ")";
    private static final String EMAIL_REGEX = "^\\s*" + WORD + "(\\." + WORD + ")*$";
    private static final Pattern EMAIL_PATTERN = Pattern.compile(EMAIL_REGEX);

    private static final int PHONE_NUMBER_LENGTH = 8;
    private static final int POSTCODE_LENGTH = 4;
    private static final int MIN_ADDRESS_LENGTH = 4;
    private static final int MAX_ADDRESS_LENGTH = 64;
    private static final int MIN_CITY_LENGTH = 2;

    
    
    public boolean isValidEmail(String email) {
    //  Returns true if email is less than 64 chars long and follows the email pattern
    
    String[] parts1 = email.split("@");
    String username = parts1[0];
    if (!IsValidWordWithNumbers(username)) {
        return false;
    }
   // String rest = parts[1];
    String parts2[] = parts1[1].split(".");
    String domain = parts2[0];
    if (!IsValidWordWithNumbers(domain)) {
        return false;
    }
    String suffix = parts2[1];
    if (!IsValidWordWith(suffix)) {
        return false;
    }
    return true;
     /*   if (email == null || email.length() > MAX_EMAIL_LENGTH) {
            return false;
        }
        return EMAIL_PATTERN.matcher(email).matches();*/
     
    }

    
    public boolean isValidPhoneNumber(String phoneNumber) {
    //  Returns true if phoneNumber is 8 chars long and contains only numbers
        if (phoneNumber.length() != PHONE_NUMBER_LENGTH) {
            return false;
        }
        for (int i = 0; i < PHONE_NUMBER_LENGTH; i++) {
            char ch = phoneNumber.charAt(i);
              if (!Character.isDigit(ch)){
            return false;
            }
        }
        return true;
    }
     
    
   public boolean isValidAddress(String address) {
    //  Returns true if address is between 4 and 64 chars long and contains at least 2 letters (numbers are not essential)
        int hasLetters = 0;
        if ((address.length() < MIN_ADDRESS_LENGTH) && (address.length() > MAX_ADDRESS_LENGTH)) {
            return false;
        }
        for (int i = 0; i < address.length(); i++) {
            char ch = address.charAt(i);
            if ((!Character.isLetterOrDigit(ch)) || (!Character.isSpaceChar(ch))) {
                return false;
            } else {
                if (Character.isLetter(ch)) {
                     hasLetters += 1;
                }
            }
        }
        if (hasLetters < 2) {
            return false;
        }
        return true;
    }
    
    
    public boolean isValidPostCode(String postCode) {
    //  Returns true if postCode is 4 chars long and contains only numbers
        if (postCode.length() != POSTCODE_LENGTH) {
            return false;
        }
        for (int i = 0; i < POSTCODE_LENGTH; i++) {
            char ch = postCode.charAt(i);
              if (!Character.isDigit(ch)){
            return false;
            }
        }
        return true;
    }

    
    public boolean isValidCity(String city) {
    //  Returns true if city is between 2 and 64 chars long and contains only letters
        if (city.length() < MIN_CITY_LENGTH) {
            return false;
        }
        for (int i = 0; i < city.length(); i++) {
            char ch = city.charAt(i);
              if (!Character.isLetter(ch)){
            return false;
            }
        }
        return true;
    }
    
     public boolean IsValidWordWithNumbers(String word) {  // not yet used
       //  Returns true if word is between 1 and 64 chars long and contains only letters and/or numbers
        if ((word.length() < 1) && (word.length() > MAX_EMAIL_LENGTH)) {
            return false;
        }
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
              if (!Character.isLetterOrDigit(ch)){
            return false;
            }
        }
        return true;
    }
    
    
     public boolean IsValidWordWith(String word) {  // not yet used
       //  Returns true if word is between 1 and 64 chars long and contains only letters
        if ((word.length() < 1) && (word.length() > MAX_EMAIL_LENGTH)) {
            return false;
        }
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
              if (!Character.isLetter(ch)){
            return false;
            }
        }
        return true;
    }
    
 
}
    
