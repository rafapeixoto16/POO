package Tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import src.Sapatilha;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class sapatilhaTeste {
    public sapatilhaTeste(){}

    @BeforeEach
    public void setUp() {

    }

    @AfterEach
    public void tearDown() {}

    @Test
    public void testConstructor(){
        Sapatilha sapatilha = new Sapatilha();
        assertTrue(sapatilha!=null);
        sapatilha = new Sapatilha(true,1,10,"airForce", 99.99, 0,40,true,LocalDate.of(2023,1,1),"Branco","mail");
        assertTrue(sapatilha!=null);
    }

    @Test
    public void testGets(){
        Sapatilha sapatilha = new Sapatilha(true,1,10,"airForce", 99.99, 0,40,true,LocalDate.of(2023,1,1),"Branco","mail");
        assertTrue(sapatilha.isNovo() == true);
        assertTrue(sapatilha.getNumDonos() == 1);
        assertTrue(sapatilha.getAvaliacao() == 10);
        assertTrue(sapatilha.getDescricao().equals("airForce"));
        assertTrue(sapatilha.getPrecoBase() == 99.99);
        assertTrue(sapatilha.getCorrecaoPreco() == 0);
        assertTrue(sapatilha.getTamanho() == 40);
        assertTrue(sapatilha.getData().equals(LocalDate.of(2023,1,1)));
        assertTrue(sapatilha.getCor().equals("Branco"));
        assertTrue(sapatilha.getEmailUtilizador().equals("mail"));
    }

    @Test
    public void testEquals(){
        Sapatilha sapatilha1 = new Sapatilha(true,1,10,"airForce", 99.99, 0,40,true,LocalDate.of(2023,1,1),"Branco","mail");
        Sapatilha sapatilha2 = new Sapatilha(false, 3, 5,"StanSmith",80,20,39,true,LocalDate.now(),"Verde","email@");
        assertFalse(sapatilha1.equals(sapatilha2));
        assertTrue(sapatilha1.equals(sapatilha1));
    }
}
