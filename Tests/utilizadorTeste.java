package Tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import src.Encomenda;
import src.Sapatilha;
import src.TShirt;
import src.Utilizador;
import src.*;

import java.time.LocalDate;

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

    @Test
    public void  testAddListaUtilizador(){
        Utilizador utilizador = new Utilizador("email","Peixoto","Avenida das Cruzes Frades",309144557);
        TShirt tshirt = new TShirt(true,1,10,"adidas",50,0,0,"mail");
        Sapatilha sapatilha1 = new Sapatilha(true,1,10,"airForce", 99.99,40,true, LocalDate.of(2023,1,1),"Branco","mail");
        Sapatilha sapatilha2 = new Sapatilha(false, 3, 5,"StanSmith",80,39,true,LocalDate.now(),"Verde","email@");
        utilizador.addArtigosPorVender(tshirt);
        utilizador.addArtigosPorVender(sapatilha1);
        utilizador.addArtigosVendidos(sapatilha2);
        assertTrue(utilizador.temArtigoPorVender(tshirt));
        utilizador.removeArtigosPorVender(tshirt);
        assertFalse(utilizador.temArtigoPorVender(tshirt));
        assertTrue(utilizador.existeArtigosVendidos(sapatilha2));
    }

    @Test
    public void testEncomendasUtilizador(){
        Utilizador utilizador = new Utilizador("email","Peixoto","Avenida das Cruzes Frades",309144557);
        Encomenda encomenda = new Encomenda();
        Encomenda encomenda2 = new Encomenda();
        Encomenda encomenda3 = new Encomenda();
        utilizador.adicionaEncomendasUtilizador(encomenda);
        utilizador.adicionaEncomendasUtilizador(encomenda2);
        utilizador.adicionaEncomendasUtilizador(encomenda3);
        assertTrue(utilizador.encomendaUtilizador(encomenda));
        utilizador.removeEncomendasUtilizador(encomenda);
        assertFalse(utilizador.encomendaUtilizador(encomenda));
        assertTrue(utilizador.encomendaUtilizador(encomenda2));
        assertTrue(utilizador.encomendaUtilizador(encomenda3));
        utilizador.removeEncomendasUtilizador(encomenda2);
        assertFalse(utilizador.encomendaUtilizador(encomenda2));
    }
}
