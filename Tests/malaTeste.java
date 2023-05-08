package Tests;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import model.Mala;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class malaTeste {

    public malaTeste(){}

    @BeforeEach
    public void setUp() {}

    @AfterEach
    public void tearDown() {}

    @Test
    public void testConstructor(){
        Mala mala = new Mala();
        assertTrue(mala!=null);
        mala = new Mala(true,1,10,"Cavalinho",70,4,"couro", LocalDate.of(2023,1,1),"mail");
        assertTrue(mala!=null);
    }

    @Test
    public void testGets(){
        Mala mala = new Mala(true,1,10,"Cavalinho",70,4,"couro", LocalDate.of(2023,1,1),"mail");
        assertTrue(mala.isNovo() == true);
        assertTrue(mala.getNumDonos() == 1);
        assertTrue(mala.getAvaliacao() == 10);
        assertTrue(mala.getDescricao().equals("Cavalinho"));
        assertTrue(mala.getPrecoBase() == 70);
        assertTrue(mala.getDim() == 4);
        assertTrue(mala.getMaterial().equals("couro"));
        assertTrue(mala.getAno_colecao().equals(LocalDate.of(2023,1,1)));
        assertTrue(mala.getEmailUtilizador().equals("mail"));
    }

    @Test
    public void testEquals(){
        Mala mala1 = new Mala(true,1,10,"Cavalinho",70,4,"couro", LocalDate.of(2023,1,1),"mail");
        Mala mala2 = new Mala(true,1,10,"Cavalinho",70,4,"couro", LocalDate.of(2023,1,1),"mail");
        assertFalse(mala1.equals(mala2));
        assertTrue(mala1.equals(mala1));
    }
}
