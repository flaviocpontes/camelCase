import java.util.ArrayList;
import java.util.List;

public class CamelCase {
    public static List<String> converterCamelCase(String original) {
        List<String> palavras = new ArrayList<>();
        if (original.length() > 0) {
            String palavra = "";
            for ( char c : original.toCharArray()) {
                if (Character.isUpperCase(c) && palavra.length() > 0) {
                    palavras.add(palavra.toLowerCase());
                    palavra = "";
                }
                palavra = palavra + c;
            }
            palavras.add(palavra.toLowerCase());
        }
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