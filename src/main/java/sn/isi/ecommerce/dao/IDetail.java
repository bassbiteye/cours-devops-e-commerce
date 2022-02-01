package sn.isi.ecommerce.dao;

import sn.isi.ecommerce.entities.Detail;

import java.util.List;

public interface IDetail {

    public int addDetail(Detail detail);
    public int deleteDetail(int idDetail);
    public Detail getDetail(int idDetail);
    public List<Detail> getAllDetail();
}
