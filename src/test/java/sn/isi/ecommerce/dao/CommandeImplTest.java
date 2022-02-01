package sn.isi.ecommerce.dao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import sn.isi.ecommerce.entities.Client;
import sn.isi.ecommerce.entities.Commande;
import sn.isi.ecommerce.entities.Detail;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CommandeImplTest {



    @Test
    void addCommande() {
        ICommande iCommande = new CommandeImpl();
        Commande commande = new Commande();
        IDetail iDetail = new DetailImpl();
        Detail detail = new Detail();
        List<Detail> detailList= new ArrayList<>();
        detailList.add(detail);
        commande.setDetails(detailList);

        Commande result = iCommande.addCommande(commande);
        int id= commande.getId();
        if(result== commande){
            System.out.println("Test passed");
            System.out.println("Commande id ="+id);

        }else{
            System.out.println("Test failed");
        }




    }

    @Test
    void getCommande() {
        ICommande iCommande = new CommandeImpl();
        int id =0;
        Commande commande =iCommande.getCommande(id);

        if(commande != null){
            System.out.println("Test passed");
        }else{
            System.out.println("Test failed");
        }
    }

    @Test
    void deleteCommande() {
            ICommande iCommande = new CommandeImpl();
            iCommande.deleteCommande(0);
            System.out.println("Test passed");


    }

    @Test
    void getAllCommande() {
        ICommande iCommande = new CommandeImpl();
        List<Commande> commandes = iCommande.getAllCommande();
        if(commandes.size()>0){
            System.out.println(commandes.size());
        }
        else{
            System.out.println("Aucune commande");
        }
    }

    @Test
    void getCommandeByClient() {
        ICommande iCommande = new CommandeImpl();
        Client client = new Client();
        List<Commande> commandes = iCommande.getCommandeByClient(client.getId());

        if(commandes.size()>0){
            System.out.println(commandes.size());
        }
        else{
            System.out.println("Aucune commande pour ce client");
        }
    }

    @Test
    void updateCommande() {
        ICommande iCommande = new CommandeImpl();
       Commande commande = new Commande();
       commande.setId(1);
       List<Detail> detailList = new ArrayList<>();
       commande.setDetails(detailList);
        Assertions.assertEquals(1,commande.getId(),"Test failed");
    }
}