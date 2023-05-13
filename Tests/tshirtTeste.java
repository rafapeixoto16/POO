package Tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import model.TShirt;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class tshirtTeste {

    public tshirtTeste(){}

    @BeforeEach
    public void setUp() {}

    @AfterEach
    public void tearDown() {}

    @Test
    public void testConstructor(){
        TShirt tshirt = new TShirt();
        assertTrue(tshirt!=null);
        tshirt = new TShirt(true,1,10,"adidas",50,0,0,"mail",1);
        assertTrue(tshirt!=null);
    }

    @Test
    public void testGets(){
        TShirt tshirt = new TShirt(true,1,10,"adidas",50,0,0,"mail",1);
        assertTrue(tshirt.isNovo() == true);
        assertTrue(tshirt.getNumDonos() == 1);
        assertTrue(tshirt.getAvaliacao() == 10);
        assertTrue(tshirt.getDescricao().equals("adidas"));
        assertTrue(tshirt.getPrecoBase() == 50);
        assertTrue(tshirt.getTamanho() == 0);
        assertTrue(tshirt.getPadrao() == 0);
        assertTrue(tshirt.getEmailUtilizador().equals("mail"));
    }

    @Test
    public void testEquals(){
        TShirt tshirt1 = new TShirt(true,1,10,"adidas",50,0,0,"mail",1);
        TShirt tshirt2 = new TShirt(true,1,10,"nike",50,0,0,"mail2",1);
        assertFalse(tshirt1.equals(tshirt2));
    }
}













