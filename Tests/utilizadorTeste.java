package Tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import src.Utilizador;

public class utilizadorTeste {
    public utilizadorTeste(){}

    @BeforeEach
    public void setUp() {}

    @AfterEach
    public void tearDown() {}

    @Test
    public void testConstructor() {
        Utilizador utilizador = new Utilizador();
        assertTrue(utilizador!=null);
        utilizador = new Utilizador("email","Peixoto","Avenida das Cruzes Frades",309144557);
        assertTrue(utilizador!=null);
    }

    @Test
    public void testGets(){
        Utilizador utilizador = new Utilizador("email","Peixoto","Avenida das Cruzes Frades",309144557);
        assertTrue(utilizador.getEmail().equals("email"));
        assertTrue(utilizador.getNome().equals("Peixoto"));
        utilizador.setNome("Peixotao");
        assertFalse(utilizador.getNome().equals("Peixoto"));
    }

    @Test
    public void testEquals(){
        Utilizador utilizador = new Utilizador("email","Peixoto","Avenida das Cruzes Frades",309144557);
        Utilizador utilizador2 = new Utilizador("email2","Anao","GarfeMid",409142222);
        assertFalse(utilizador.equals(utilizador2));
        assertTrue(utilizador.equals(utilizador));
    }
    @Test
    public void testEncTotalDinheiro(){
        Utilizador utilizador = new Utilizador("email","Peixoto","Avenida das Cruzes Frades",309144557);
        utilizador.incrementaDinheiroTotal(69);
        assertTrue(utilizador.getDinheiroVendas() == 69);
    }
}
