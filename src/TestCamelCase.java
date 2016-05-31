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
    public void testConvertePalavrasComSiglaInclusa() {
        List<String> palavras = CamelCase.converterCamelCase("numeroCPFContribuinte");
        List<String> esperado = new ArrayList<>();
        esperado.add("numero");
        esperado.add("CPF");
        esperado.add("contribuinte");
        assertTrue(esperado.equals(palavras));
    }

    @Test
    public void testConvertePalavrasComNumeroIncluso() {
        List<String> palavras = CamelCase.converterCamelCase("recupera10Primeiros");
        List<String> esperado = new ArrayList<>();
        esperado.add("recupera");
        esperado.add("10");
        esperado.add("primeiros");
        assertTrue(esperado.equals(palavras));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConverterPalavraComecaNumero() {
        List<String> palavras = CamelCase.converterCamelCase("10Primeiros");
    }

    @Test
    public void testEncontraPalavraVazia() {
        List<String> palavras = new ArrayList<>();
        String restante = CamelCase.acharProximaPalavra(palavras, "");
        assertTrue(restante.equals(""));
        assertTrue(palavras.isEmpty());
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
        assertTrue(restante.equals("Contribuinte"));
        assertTrue(esperado.equals(palavras));
    }

    @Test
    public void testEncontraNumeroApensado() {
        List<String> palavras = new ArrayList<>();
        List<String> esperado = new ArrayList<>();
        esperado.add("recupera");
        String restante = CamelCase.acharProximaPalavra(palavras, "recupera10Primeiros");
        assertTrue(restante.equals("10Primeiros"));
        assertTrue(esperado.equals(palavras));
    }

    @Test
    public void testEncontraNumeroNoInicio() {
        List<String> palavras = new ArrayList<>();
        List<String> esperado = new ArrayList<>();
        esperado.add("10");
        String restante = CamelCase.acharProximaPalavra(palavras, "10Primeiros");
        assertTrue(restante.equals("Primeiros"));
        assertTrue(esperado.equals(palavras));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testEncontrarPalavraCaracterIlegal() {
        List<String> palavras = CamelCase.converterCamelCase("nome#Composto");
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

    @Test
    public void testInicioPalavraUmaPalavra() {
        assertFalse(CamelCase.inicioPalavra("nome", 0));
        assertFalse(CamelCase.inicioPalavra("nome", 1));
        assertFalse(CamelCase.inicioPalavra("nome", 2));
        assertFalse(CamelCase.inicioPalavra("nome", 3));
    }

    @Test
    public void testInicioPalavraDuasPalavras() {
        assertFalse(CamelCase.inicioPalavra("nomeComposto", 2));
        assertFalse(CamelCase.inicioPalavra("nomeComposto", 8));
        assertTrue(CamelCase.inicioPalavra("nomeComposto", 4));
        assertFalse(CamelCase.inicioPalavra("nomeComposto", 11));
    }

    @Test
    public void testInicioPalavraSiglaInicio() {
        assertFalse(CamelCase.inicioPalavra("CPFContribuinte", 1));
        assertTrue(CamelCase.inicioPalavra("CPFContribuinte", 3));
        assertFalse(CamelCase.inicioPalavra("CPFContribuinte", 14));
    }

    @Test
    public void testInicioPalavraSiglaIntercalada() {
        assertFalse(CamelCase.inicioPalavra("numeroCPFContribuinte", 0));
        assertFalse(CamelCase.inicioPalavra("numeroCPFContribuinte", 5));
        assertTrue(CamelCase.inicioPalavra("numeroCPFContribuinte", 6));
        assertFalse(CamelCase.inicioPalavra("numeroCPFContribuinte", 8));
        assertTrue(CamelCase.inicioPalavra("numeroCPFContribuinte", 9));
        assertFalse(CamelCase.inicioPalavra("numeroCPFContribuinte", 10));
        assertFalse(CamelCase.inicioPalavra("numeroCPFContribuinte", 20));
    }

    @Test
    public void testInicioPalavraNumeroIntercalado() {
        assertFalse(CamelCase.inicioPalavra("recupera10Primeiros", 1));
        assertTrue(CamelCase.inicioPalavra("recupera10Primeiros", 8));
        assertFalse(CamelCase.inicioPalavra("recupera10Primeiros", 9));
        assertTrue(CamelCase.inicioPalavra("recupera10Primeiros", 10));
        assertFalse(CamelCase.inicioPalavra("recupera10Primeiros", 14));
        assertFalse(CamelCase.inicioPalavra("recupera10Primeiros", 18));
    }

}