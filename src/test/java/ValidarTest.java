import org.junit.jupiter.api.Test;
import org.kodigo.Utils.Validar;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ValidarTest {
    @Test
    public void testValidar(){
        boolean result = Validar.esNumero("2");
        assertTrue(result);
    }
}
