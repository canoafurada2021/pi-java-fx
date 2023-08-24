package utilities;

public class TelefoneFormatter {
    
    public static String formatTelefoneBrasil(String telefone) {
        if (telefone == null || telefone.isEmpty()) {
            return ""; // Return empty string for null or empty input
        }
        
        // Remove non-digit characters from the input string
        String telefoneStr = telefone.replaceAll("[^0-9]", "");
        
        if (telefoneStr.length() == 10) { // (XX) XXXX-XXXX
            return "(" + telefoneStr.substring(0, 2) + ") " + telefoneStr.substring(2, 6) + "-"
                    + telefoneStr.substring(6);
        } else if (telefoneStr.length() == 11) { // (XX) XXXXX-XXXX
            return "(" + telefoneStr.substring(0, 2) + ") " + telefoneStr.substring(2, 7) + "-"
                    + telefoneStr.substring(7);
        }
        return telefoneStr; // Return without formatting if it doesn't match any pattern
    }
}