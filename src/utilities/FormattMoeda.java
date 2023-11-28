package utilities;

import javafx.util.StringConverter;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

public class FormattMoeda {

    // Método para formatar um valor Long como moeda
    public static String formatarMoeda(Long value) {
        if (value == null) {
            return "";
        }

        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
        return currencyFormat.format(value);
    }

    // Método para converter uma string formatada de moeda para Long
    public static Long converterMoeda(String string) {
        if (string == null || string.isEmpty()) {
            return null;
        }

        try {
            // Remove caracteres não numéricos e substitui a vírgula por ponto, se necessário
            String cleanString = string.replaceAll("[^\\d,]", "").replace(',', '.');

            // Converte a string formatada de moeda para Long
            return (long) (NumberFormat.getNumberInstance(new Locale("pt", "BR")).parse(cleanString).doubleValue() * 100); // Multiplica por 100 para tratar centavos
        } catch (ParseException e) {
            // Em caso de erro de conversão, você pode lidar com isso da maneira desejada.
            // Neste exemplo, você pode imprimir uma mensagem de erro.
            System.err.println("Erro ao converter moeda para Long: " + e.getMessage());
            return null;
        }
    }

    // Método que retorna um StringConverter para formatação de moeda
    public static StringConverter<Long> criarStringConverter() {
        return new StringConverter<>() {
            @Override
            public String toString(Long value) {
                return formatarMoeda(value);
            }

            @Override
            public Long fromString(String string) {
                return converterMoeda(string);
            }
        };
    }
}
