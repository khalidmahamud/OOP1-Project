package Customer;
import java.util.regex.*;

public class Validation {
    public String errorMsg(User user) {

        if (user.getFirstName().isBlank() || user.getFirstName().equals("First Name") || user.getFirstName().equals("নাম")) {
            return "First Name cannot be empty!";
        }
        else if (!isString(user.getFirstName())) {
            return "Name can only be alphabets!";
        }
        else if (user.getLastName().isBlank() || user.getLastName().equals("পদবী")) {
            return "Last Name cannot be empty!";
        } 
        else if (!isString(user.getLastName())) {
            return "Name can only be alphabets!";
        }
        else if (user.getEmail().isBlank() || user.getEmail().equals("ইমেইল")) {
            return "Email cannot be empty!";
        }
        else if (!isValidEmailAddress(user.getEmail())) {
            return "Invalid Email!";
        }
        else if (user.getMobile().length() > 11 && user.getMobile().length() < 11) {
            return "Invalid Mobile Number!";
        }
        else if (!isDigit(user.getMobile())) {
            return "Invalid Mobile Number!";
        }
        else if (new String(user.getPassword()).isBlank() || new String(user.getPassword()).equals("Password") || new String(user.getPassword()).equals("পাসওয়ার্ড")) {
            return "Password cannot be empty!";
        }
        else if (user.getDate().equals("Date") || user.getDate().equals("দিন")) {
            return "Date cannot be empty!";
        }
        else if (user.getMonth().equals("Month") || user.getMonth().equals("মাস") ) {
            return "Month cannot be empty!";
        }
        else if (user.getYear().equals("Year") || user.getYear().equals("বছর")) {
            return "Year cannot be empty!";
        }
        else if (!isValidMobile(user.getMobile())) {
            return "Invalid Mobile Number!";
        }
        return null;
    }


    public boolean isValidEmailAddress(String email) {
        String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
        java.util.regex.Matcher m = p.matcher(email);
        return m.matches();
    }

   //https://stackoverflow.com/a/15806080/876739
   public boolean isString(String name) {
        String ePattern = "^[\\p{L} '-]+$";
        Pattern p = java.util.regex.Pattern.compile(ePattern);
        java.util.regex.Matcher m = p.matcher(name);
        return m.matches();
    }

//https://stackoverflow.com/a/3802238/876739
    /*public boolean isStrongPassword(String text) {
        String ePattern = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$";
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
        java.util.regex.Matcher m = p.matcher(text);
        return m.matches();
    }*/

    
    //https://stackoverflow.com/a/34253764/876739
    public boolean isDigit(String mobileNo) {
        boolean digits = mobileNo.chars().allMatch(Character::isDigit);
        return digits;
    }

    public boolean isValidMobile(String mobileNo) {
        Pattern ptrn = Pattern.compile("(^([+]{1}[8]{2}|0088)?(01){1}[3-9]{1}\\d{8})$");   
        java.util.regex.Matcher match = ptrn.matcher(mobileNo);  
        return (match.find() && match.group().equals(mobileNo)); 
    }
}
