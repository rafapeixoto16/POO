package Tests;

import Exceptions.TransportadoraJaExistente;
import model.Transportadora;
import model.TransportadoraPremium;
import model.Vintage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class transpTest {

    public transpTest(){}


    @BeforeEach
    public void setUp() {

    }

    @AfterEach
    public void tearDown() {}

    @Test
    public void testConstructor() throws TransportadoraJaExistente {
        Transportadora transportadoraPremi= new TransportadoraPremium();
        Vintage ola = new Vintage();
        ola.getListaTransportadoras().addTransportadora(transportadoraPremi);
        assertTrue(ola.existeTranspPremium());
    }

}
