package co.edu.unbosque.utils;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class GenerarDatosUsuario {
	
	private static final String LOWERCASE = "abcdefghijklmnopqrstuvwxyz";
    private static final String UPPERCASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String DIGITS = "0123456789";
    private static final int MIN_LENGTH = 6;
    private static final int MAX_LENGTH = 8;
    
    private static SecureRandom random = new SecureRandom();

    public static String generateStrongPassword() {
        int length = MIN_LENGTH + random.nextInt(MAX_LENGTH - MIN_LENGTH + 1);
        List<Character> chars = new ArrayList<>();
        
        chars.add(LOWERCASE.charAt(random.nextInt(LOWERCASE.length())));
        chars.add(UPPERCASE.charAt(random.nextInt(UPPERCASE.length())));
        chars.add(DIGITS.charAt(random.nextInt(DIGITS.length())));
        
        String allChars = LOWERCASE + UPPERCASE + DIGITS;
        for (int i = 3; i < length; i++) {
            chars.add(allChars.charAt(random.nextInt(allChars.length())));
        }
        
        Collections.shuffle(chars);
        
        StringBuilder password = new StringBuilder();
        for (char c : chars) {
            password.append(c);
        }
        
        return password.toString();
    }
    
    public static boolean validateStrongPassword(String password) {

        if (password == null || password.length() < MIN_LENGTH || password.length() > MAX_LENGTH) {
            return false;
        }

        boolean hasLower = false;
        boolean hasUpper = false;
        boolean hasDigit = false;

        for (char c : password.toCharArray()) {
            if (Character.isLowerCase(c)) hasLower = true;
            else if (Character.isUpperCase(c)) hasUpper = true;
            else if (Character.isDigit(c)) hasDigit = true;
        }

        return hasLower && hasUpper && hasDigit;
    }
    
    public static String generateUsernameFromEmail(String email) {
        return email.split("@")[0]; 
    }
}
	   