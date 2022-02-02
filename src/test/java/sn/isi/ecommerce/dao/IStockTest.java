package sn.isi.ecommerce.dao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import sn.isi.ecommerce.entities.Stock;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class IStockTest {

    @Test
    void add() {

        IStock stockdao = new StockImpl();
        IProduit produitdao = new ProduitImpl();
        Stock s = new Stock();
        s.setQte(5);
        s.setProduit(produitdao.get(1));
        int result = stockdao.add(s);
        if(result == 1)
            Assertions.assertEquals(9, stockdao.add(s), "succesfull");
        else
            Assertions.assertEquals(9, stockdao.add(s), "La methode addClient a echoué");
    }

    @Test
    void getAll() {
        IStock stockdao = new StockImpl();
        Assertions.assertNotNull( stockdao.getAll(), "La methode getAllClients a echoué");
    }
}