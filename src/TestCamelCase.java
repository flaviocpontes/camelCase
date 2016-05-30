import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

public class TestCamelCase {

    CamelCase c;

    @Before
    public void AssignCamelCase() {
        c = new CamelCase();
    }

    @Test
    public void testStringVazia() {
        List<String> palavras = c.converterCamelCase("");
        assertTrue(c.converterCamelCase("").isEmpty());
    }

    @Test
    public void testStringNomeLowerCase() {
        List<String> palavras = c.converterCamelCase("nome");
        List<String> esperado = new ArrayList<>();
        esperado.add("nome");
        assertTrue(esperado.equals(palavras));
    }

}