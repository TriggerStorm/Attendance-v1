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
   
    public static final Pattern VALID_EMAIL_ADDRESS_REGEX = 
    Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
    
    
     

    public boolean isValidEmail(String email) {
    //  Returns true if email string is is in valid email format. Works pretty well. Not 100% (eg: abc@xyz..com)
    
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX .matcher(email);
        return matcher.find();
    }


    public boolean isValidPhoneNumber(String phoneNumber) {
    //  Returns true if phoneNumber is 8 chars long and contains only numbers
        return isValidNumber(phoneNumber, 8);
    }
     
    
    public boolean isValidAddress(String address) {
    //  Returns true if address is between 4 and 64 chars long and contains at least 2 letters (numbers are not essential)
        address = address.trim();
        int hasLetters = 0;
        if ((address.length() < 4) && (address.length() > 64)) {
            return false;
        }
        for (int i = 0; i < address.length(); i++) {
            char ch = address.charAt(i);
            if (!(Character.isLetterOrDigit(ch) || Character.isSpaceChar(ch))) {
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
        return isValidNumber(postCode, 4);
    }

    
    public boolean isValidCity(String city) {
    //  Returns true if city is between 2 and 64 chars long and contains only letters
        return areValidWordsWithSpace(city, 2, 64);
    }
    
    
    
    
    
    
    
// Test word valididator methods
    
    public boolean isValidWord(String word, int min, int max) {  // not yet used
       //  Returns true if word is between 1 and 64 chars long and contains only letters
        word = word.trim();
        if ((word.length() < min) || (word.length() > max)) {
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
    
    public boolean isValidWordWithNumbers(String word, int min, int max) {  // not yet used
       //  Returns true if word is between 1 and 64 chars long and contains only letters and/or numbers
        word = word.trim();
        if ((word.length() < min) || (word.length() > max)) {
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
    
    
    public boolean areValidWordsWithSpace(String word, int min, int max) {  // not yet used
       //  Returns true if word is between 1 and 64 chars long and contains only letters or spaces
        word = word.trim();
        if ((word.length() < min) || (word.length() > max)) {
            return false;
        }
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (!(Character.isLetter(ch) || Character.isSpaceChar(ch))) {
            return false;
            }
        }
        return true;
    }
    
    
   public boolean isValidNumber(String word, int noOfChars) {  // not yet used
       //  Returns true if word is between 1 and 64 chars long and contains only letters
        word = word.trim();
        if (!(word.length() == noOfChars)) {
            return false;
        }
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
              if (!Character.isDigit(ch)){
            return false;
            }
        }
        return true;
    }
   
  
  
}
    
