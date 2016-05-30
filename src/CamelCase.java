import java.util.ArrayList;
import java.util.List;

public class CamelCase {
    public static List<String> converterCamelCase(String original) {
        List<String> palavras = new ArrayList<>();
        String restante = original;
        do {restante = acharProximaPalavra(palavras, restante);} while (restante.length() > 0);
        return palavras;
    }

    public static String acharProximaPalavra(List<String> palavras, String s) {
        for (int i = 0; i < s.length(); i++) {
            if (Character.isUpperCase(s.charAt(i)) && i > 0){
                palavras.add(s.substring(0, i).toLowerCase());
                return s.substring(i);
            }
        }
        if (s.length() > 0) palavras.add(s.toLowerCase());
        return "";
    }
}