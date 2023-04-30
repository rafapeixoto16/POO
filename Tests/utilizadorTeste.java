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
        utilizador = new Utilizador("email","Peixoto","Avenida das Cruzes",309144557);
        assertTrue(utilizador!=null);
    }

    @Test
    public void testGetMail(){
        Utilizador utilizador = new Utilizador("email","Peixoto","Avenida das Cruzes",309144557);
        assertTrue(utilizador.getEmail().equals("email"));
    }





}
