package utilities;

public class CnpjFormatter {
	  public static String formatCnpj(String cnpj) {
	        // Remove caracteres não numéricos
	        String numericCnpj = cnpj.replaceAll("\\D", "");

	        // Aplica a máscara
	        StringBuilder maskedCnpj = new StringBuilder();
	        for (int i = 0; i < numericCnpj.length(); i++) {
	            maskedCnpj.append(numericCnpj.charAt(i));
	            if (i == 1 || i == 4) {
	                maskedCnpj.append('.');
	            } else if (i == 7) {
	                maskedCnpj.append('/');
	            } else if (i == 11) {
	                maskedCnpj.append('-');
	            }
	        }
	        return maskedCnpj.toString();
	    }
}
