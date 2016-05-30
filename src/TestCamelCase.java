import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

public class TestCamelCase {

    @Test
    public void testStringVazia() {
        CamelCase c = new CamelCase();
        List<String> palavras = c.converterCamelCase("");
        assertTrue(c.converterCamelCase("").isEmpty());
    }

    @Test
    public void testStringNomeLowerCase() {
        CamelCase c = new CamelCase();
        List<String> palavras = c.converterCamelCase("nome");
        List<String> esperado = new ArrayList<>();
        esperado.add("nome");
        assertTrue(esperado.equals(palavras));
    }

}