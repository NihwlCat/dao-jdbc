package entities;

import db.DB;

public class DaoFactory {

    public static SellerDAO createSellerDao(){
        return new SellerDaoJDBC(DB.getConnection());
    }

    public static void closeSellerDAO(){
        DB.closeConnection();
    }
}
