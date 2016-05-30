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

}