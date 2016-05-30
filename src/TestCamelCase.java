import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

public class TestCamelCase {

    @Test
    public void testConverteStringVazia() {
        List<String> palavras = CamelCase.converterCamelCase("");
        assertTrue(CamelCase.converterCamelCase("").isEmpty());
    }

    @Test
    public void testConverteUmaPalavraLowercase() {
        List<String> palavras = CamelCase.converterCamelCase("nome");
        List<String> esperado = new ArrayList<>();
        esperado.add("nome");
        assertTrue(esperado.equals(palavras));
    }

    @Test
    public void testConverteUmaPalavraCapitalized() {
        List<String> palavras = CamelCase.converterCamelCase("Nome");
        List<String> esperado = new ArrayList<>();
        esperado.add("nome");
        assertTrue(esperado.equals(palavras));
    }

    @Test
    public void testConverteDuasPalavras() {
        List<String> palavras = CamelCase.converterCamelCase("nomeComposto");
        List<String> esperado = new ArrayList<>();
        esperado.add("nome");
        esperado.add("composto");
        assertTrue(esperado.equals(palavras));
    }

    @Test
    public void testConverteUmaSigla() {
        List<String> palavras = CamelCase.converterCamelCase("CPF");
        List<String> esperado = new ArrayList<>();
        esperado.add("CPF");
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
    public void testEncontraPalavraUmaPalavraLowercase() {
        List<String> palavras = new ArrayList<>();
        List<String> esperado = new ArrayList<>();
        esperado.add("nome");
        String restante = CamelCase.acharProximaPalavra(palavras, "nome");
        assertTrue(restante.equals(""));
        assertTrue(esperado.equals(palavras));
    }

    @Test
    public void testEncontraPalavraUmaPalavraCapitalized() {
        List<String> palavras = new ArrayList<>();
        List<String> esperado = new ArrayList<>();
        esperado.add("nome");
        String restante = CamelCase.acharProximaPalavra(palavras, "Nome");
        assertTrue(restante.equals(""));
        assertTrue(esperado.equals(palavras));
    }

    @Test
    public void testEncontraPalavraDuasPalavrasLowercase() {
        List<String> palavras = new ArrayList<>();
        List<String> esperado = new ArrayList<>();
        esperado.add("nome");
        String restante = CamelCase.acharProximaPalavra(palavras, "nomeComposto");
        assertTrue(restante.equals("Composto"));
        assertTrue(esperado.equals(palavras));
    }

    @Test
    public void testEncontraUmaSigla() {
        List<String> palavras = new ArrayList<>();
        List<String> esperado = new ArrayList<>();
        esperado.add("CPF");
        String restante = CamelCase.acharProximaPalavra(palavras, "CPF");
        assertTrue(restante.equals(""));
        assertTrue(esperado.equals(palavras));
    }

    @Test
    public void testEncontraUmaSiglaComposta() {
        List<String> palavras = new ArrayList<>();
        List<String> esperado = new ArrayList<>();
        esperado.add("CPF");
        String restante = CamelCase.acharProximaPalavra(palavras, "CPFContribuinte");
        assertTrue(restante.equals(""));
        assertTrue(esperado.equals(palavras));
    }

    @Test
    public void testAjustaCapitalizaçãoUmaPalavraLowercase() {
        String esperado = "nome";
        assertTrue(esperado.equals(CamelCase.ajustaCapitalizacao("nome")));
    }

    @Test
    public void testAjustaCapitalizaçãoUmaPalavraCapitalized() {
        String esperado = "nome";
        assertTrue(esperado.equals(CamelCase.ajustaCapitalizacao("Nome")));
    }

    @Test
    public void testAjustaCapitalizaçãoSigla() {
        String esperado = "CPF";
        assertTrue(esperado.equals(CamelCase.ajustaCapitalizacao("CPF")));
    }

}