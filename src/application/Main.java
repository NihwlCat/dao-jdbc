package application;

import entities.Department;
import entities.Seller;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Department obj = new Department(1,"Books");

        Seller seller = new Seller(21,"Bob","bob@gmail",new Date(),2500.00,obj);

        System.out.println(seller);
    }
}
