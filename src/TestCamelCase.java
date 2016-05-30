import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

public class TestCamelCase {

    @Test
    public void testStringVazia() {
        List<String> palavras = CamelCase.converterCamelCase("");
        assertTrue(CamelCase.converterCamelCase("").isEmpty());
    }

    @Test
    public void testStringNomeLowerCase() {
        List<String> palavras = CamelCase.converterCamelCase("nome");
        List<String> esperado = new ArrayList<>();
        esperado.add("nome");
        assertTrue(esperado.equals(palavras));
    }

    @Test
    public void testStringNomeCapitalized() {
        List<String> palavras = CamelCase.converterCamelCase("Nome");
        List<String> esperado = new ArrayList<>();
        esperado.add("nome");
        assertTrue(esperado.equals(palavras));
    }

    @Test
    public void testStringNomeComposto() {
        List<String> palavras = CamelCase.converterCamelCase("nomeComposto");
        List<String> esperado = new ArrayList<>();
        esperado.add("nome");
        esperado.add("composto");
        assertTrue(esperado.equals(palavras));
    }

    @Test
    public void testEncontraPalavraVazia() {
        List<String> palavras = new ArrayList<>();
        List<String> esperado = new ArrayList<>();
        String restante = CamelCase.acharProximaPalavra(palavras, "");
        assertTrue(restante.equals(""));
        assertTrue(esperado.equals(palavras));
    }

    @Test
    public void testEncontraPalavraNomeLowercase() {
        List<String> palavras = new ArrayList<>();
        List<String> esperado = new ArrayList<>();
        esperado.add("nome");
        String restante = CamelCase.acharProximaPalavra(palavras, "nome");
        assertTrue(restante.equals(""));
        assertTrue(esperado.equals(palavras));
    }

}