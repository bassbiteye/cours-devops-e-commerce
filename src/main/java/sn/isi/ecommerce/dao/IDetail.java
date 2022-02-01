package sn.isi.ecommerce.dao;

import sn.isi.ecommerce.entities.Detail;

import java.util.List;

public interface IDetail {

    public Detail addDetail(Detail detail);
    public void deleteDetail(int idDetail);
    public Detail getDetail(int idDetail);
    public List<Detail> getAllDetail();
}
