package sn.isi.ecommerce.dao;

import sn.isi.ecommerce.entities.Stock;

import java.util.List;

public interface IStock {
        public int add(Stock stock);
        public List<Stock> getAll();
}
