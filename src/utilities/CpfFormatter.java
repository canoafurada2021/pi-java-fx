package utilities;

public class CpfFormatter {
    public static String formatCpf(String cpf) {
        // Remove caracteres não numéricos
        String numericCpf = cpf.replaceAll("\\D", "");

        // Aplica a máscara
        StringBuilder maskedCpf = new StringBuilder();
        for (int i = 0; i < numericCpf.length(); i++) {
            maskedCpf.append(numericCpf.charAt(i));
            if (i == 2 || i == 5) {
                maskedCpf.append('.');
            } else if (i == 8) {
                maskedCpf.append('-');
            }
        }
        return maskedCpf.toString();
    }
}
