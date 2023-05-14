package Tests;

import model.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class vintageTeste {

    @BeforeEach
    public void setUp() {}

    @AfterEach
    public void tearDown() {}

    @Test
    public void TesteVintage(){
        Vintage vintage = new Vintage();
        Vintage.setDataAtual(LocalDate.now());
        Encomenda encomenda = new Encomenda();
        List<Artigo> artigos = new ArrayList<>();
        Transportadora transportadora = new Transportadora(10,10,1);
        transportadora.setDiasEntrega(1);

        Mala mala = new Mala(true,1,10,"Cavalinho",70,4,"couro", LocalDate.of(2023,1,1),"mail",transportadora.getCodTransportadora());
        artigos.add(mala);
        encomenda.addEncomenda(transportadora,artigos);


        for (int i = 1 ; i <=3; i++)
            Vintage.incDia();

        Assertions.assertTrue(encomenda.validoCancelamentoEncomenda());
    }
}
