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

        /*
        Seller seller = DaoFactory.createSellerDao().findById(9);
        System.out.println(seller);

        Department dep = new Department(2,null);
        List<Seller> list = DaoFactory.createSellerDao().findAll();
        list.forEach(System.out::println);

        Seller newSeller = new Seller(null,"Carlos Eduardo","carlosecl@gmail.com",new Date(),3450.87,dep);
        SellerDAO sellerDao = DaoFactory.createSellerDao();

        sellerDao.insert(newSeller);
        System.out.println("ID after insert: " + newSeller.getId());

        Seller seller = sellerDao.findById(8);
        sellerDao.deleteById(8);

        System.out.println(seller);

        seller.setName("Matheuzin");*/

        /*
        Department dep1 = new Department(null,"Vendas");
        DepartmentDAO departmentDAO = DaoFactory.createDepartmentDao();

        Department dep = departmentDAO.findById(7);
        dep.setName("Food");
        departmentDAO.update(dep);
        List<Department> deps = departmentDAO.findAll();
        deps.forEach(System.out::println);

        departmentDAO.deleteById(6); */
    }
}
