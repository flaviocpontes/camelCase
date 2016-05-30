import java.util.ArrayList;
import java.util.List;

public class CamelCase {
    public static List<String> converterCamelCase(String original) {
        List<String> palavras = new ArrayList<>();
        if (original.length() > 0) palavras.add(original.toLowerCase());
        return palavras;
    }
}