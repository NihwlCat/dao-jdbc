package application;

import db.DB;
import entities.*;

import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        /*
        * Através do DaoFactory a instância de SellerDaoJDBC é criada.
        * O método .findById pode ser chamado direto após a instanciação da classe.
        */

        //Seller seller = DaoFactory.createSellerDao().findById(/*Exemplo*/3);
        //System.out.println(seller);

        Department dep = new Department(2,null);
        List<Seller> list = DaoFactory.createSellerDao().findByDepartment(dep);
        list.forEach(System.out::println);

    }
}
