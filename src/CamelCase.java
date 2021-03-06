import java.util.ArrayList;
import java.util.List;

public class CamelCase {
    public static List<String> converterCamelCase(String original) throws IllegalArgumentException{
        if ((original.length() > 0) && (Character.isDigit(original.charAt(0)))) throw new IllegalArgumentException("CamelCase não pode começar com dígitos!");
        List<String> palavras = new ArrayList<>();
        String restante = original;
        do {restante = acharProximaPalavra(palavras, restante);
        } while (restante.length() > 0);
        return palavras;
    }

    public static String acharProximaPalavra(List<String> palavras, String s) throws IllegalArgumentException{
        for (int i = 0; i < s.length(); i++) {
            if ((s.length() > 0) && (!Character.isLetterOrDigit(s.charAt(i)))) throw new IllegalArgumentException("CamelCase só suporta letras e dígitos!");
            if (inicioPalavra(s, i)) {
                palavras.add(ajustaCapitalizacao(s.substring(0, i)));
                return s.substring(i);
            }
        }
        if (s.length() > 0) palavras.add(ajustaCapitalizacao(s));
        return "";
    }

    public static String ajustaCapitalizacao(String s) {
        if (Character.isUpperCase(s.charAt(0))) {
            if (s.length() > 1 && (Character.isUpperCase(s.charAt(1)))) return s;
            else return s.toLowerCase();
        }
        return s;
    }

    public static boolean inicioPalavra(String s, int i) {
        if (Character.isUpperCase(s.charAt(i)) && i > 0) {
            if ((i < s.length() - 2) && Character.isLowerCase(s.charAt(i + 1))) return true;
            if (Character.isLowerCase(s.charAt(i - 1))) return true;
        }
        return ((Character.isDigit(s.charAt(i)) && i > 0) && !(Character.isDigit(s.charAt(i - 1))));
    }
}