package utilities;

import java.text.DecimalFormat;

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


    public static Long formatTelefoneLong(Long telefone) {
            String telefoneStr = Long.toString(telefone); // Converte o long para uma string
            int length = telefoneStr.length();

            if (length == 10) { // 1234567890 (XX) XXXX-XXXX
                String formattedTelefone = "(" + telefoneStr.substring(0, 2) + ") " + telefoneStr.substring(2, 6) + "-" + telefoneStr.substring(6);
                return Long.parseLong(formattedTelefone); // Converte a string formatada de volta para long
            } else if (length == 11) { // 12345678901 (XX) XXXXX-XXXX
                String formattedTelefone = "(" + telefoneStr.substring(0, 2) + ") " + telefoneStr.substring(2, 7) + "-" + telefoneStr.substring(7);
                return Long.parseLong(formattedTelefone); // Converte a string formatada de volta para long
            }

            return telefone; // Retorna o número sem formatação se não corresponder a nenhum padrão
        }


    }