import java.util.ArrayList;
import java.util.List;

public class CamelCase {
    public static List<String> converterCamelCase(String original) {
        List<String> palavras = new ArrayList<>();
        String restante = original;
        do {
            restante = acharProximaPalavra(palavras, restante);
        } while (restante.length() > 0);
        return palavras;
    }

    public static String acharProximaPalavra(List<String> palavras, String s) {
        for (int i = 0; i < s.length(); i++) {
            if ((Character.isUpperCase(s.charAt(i))  && i > 0) && (((i < s.length() - 2) && Character.isLowerCase(s.charAt(i + 1))) || (Character.isLowerCase(s.charAt(i - 1))))){
                palavras.add(ajustaCapitalizacao(s.substring(0, i)));
                return s.substring(i);
            } else if ((Character.isDigit(s.charAt(i)) && i > 0) && !(Character.isDigit(s.charAt(i-1)))) {
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
}