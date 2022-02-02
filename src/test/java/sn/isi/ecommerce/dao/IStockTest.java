package sn.isi.ecommerce.dao;

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
            System.out.println("Test passed");
        else
            System.out.println("Test failed");
    }

    @Test
    void getAll() {
        IStock stockdao = new StockImpl();
        List<Stock> stocks = stockdao.getAll();
        if(stocks.size() > 0)
            System.out.println("List contains " + stocks.size() + " produits");
        else
            System.out.println("List empty");
    }
}