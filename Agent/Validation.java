package Agent;
import java.util.regex.*;

public class Validation {
    public String errorMsg(Agent agent) {

        if (agent.getFirstName().isBlank() || agent.getFirstName().equals("First Name") || agent.getFirstName().equals("নাম")) {
            return "First Name cannot be empty!";
        }
        else if (!isString(agent.getFirstName())) {
            return "Name can only be alphabets!";
        }
        else if (agent.getLastName().isBlank() || agent.getLastName().equals("পদবী")) {
            return "Last Name cannot be empty!";
        } 
        else if (!isString(agent.getLastName())) {
            return "Name can only be alphabets!";
        }
        else if (agent.getEmail().isBlank() || agent.getEmail().equals("ইমেইল")) {
            return "Email cannot be empty!";
        }
        else if (!isValidEmailAddress(agent.getEmail())) {
            return "Invalid Email!";
        }
        else if (agent.getMobile().length() > 11 && agent.getMobile().length() < 11) {
            return "Invalid Mobile Number!";
        }
        else if (!isDigit(agent.getMobile())) {
            return "Invalid Mobile Number!";
        }
        else if (new String(agent.getPassword()).isBlank() || new String(agent.getPassword()).equals("Password") || new String(agent.getPassword()).equals("পাসওয়ার্ড")) {
            return "Password cannot be empty!";
        }
        else if (agent.getDate().equals("Date") || agent.getDate().equals("দিন")) {
            return "Date cannot be empty!";
        }
        else if (agent.getMonth().equals("Month") || agent.getMonth().equals("মাস") ) {
            return "Month cannot be empty!";
        }
        else if (agent.getYear().equals("Year") || agent.getYear().equals("বছর")) {
            return "Year cannot be empty!";
        }
        else if (!isValidMobile(agent.getMobile())) {
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
