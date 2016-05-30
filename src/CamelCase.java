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
            if ((Character.isUpperCase(s.charAt(i)) && i > 0) && !(Character.isUpperCase(s.charAt(Math.min(i+1, s.length()-1))))){
                String palavra = s.substring(0, i);
                if (Character.isLowerCase(palavra.charAt(1))) palavra = palavra.toLowerCase();
                palavras.add(palavra);
                return s.substring(i);
            }
        }
        if (s.length() > 0) {
            if (Character.isLowerCase(s.charAt(1))) s = s.toLowerCase();
            palavras.add(s);
        }
        return "";
    }

    public static String ajustaCapitalizacao(String s) {
        return s;
    }
}