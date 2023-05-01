package Tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import src.TShirt;

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
        tshirt = new TShirt(true,1,10,"adidas",50,0,0,0,"mail");
        assertTrue(tshirt!=null);
    }

    @Test
    public void testGets(){
        TShirt tshirt
    }
}













