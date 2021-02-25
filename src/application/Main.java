package application;

import db.DB;
import entities.*;

import java.util.Date;

public class Main {
    public static void main(String[] args) {

        /*
        * Através do DaoFactory a instância de SellerDaoJDBC é criada.
        * O método .findById pode ser chamado direto após a instanciação da classe.
        */

        Seller seller = DaoFactory.createSellerDao().findById(/*Exemplo*/3);
        System.out.println(seller);


    }
}
