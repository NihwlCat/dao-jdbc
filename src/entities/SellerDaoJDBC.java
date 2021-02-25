package entities;

import db.DB;
import db.DBException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SellerDaoJDBC implements SellerDAO {
    private Connection conn; // Dependência de Connection para poder puxar DB.getConnection

    public SellerDaoJDBC(Connection conn){
        this.conn = conn;
    }

    @Override
    public void insert(Seller obj) {

    }

    @Override
    public void update(Seller obj) {

    }

    @Override
    public void deleteById(Integer id) {

    }

    @Override
    public Seller findById(Integer id) {
        PreparedStatement statement = null;
        ResultSet rs = null;

        /*
        * O que ocorre aqui é uma consulta com placeholder ao banco de dados. Código adquirido através de boilerplate.
        * O método .executeQuery() faz a busca e armazena os dados em uma tabela ResultSet.
        * Cada coluna da tabela é usada para instanciar um objeto do tipo Seller que é retornado ao final da execução.
        * Caso rs.next() retorne falso na condição, significa que não há linha de dados em rs e portanto houve falha na busca.
        */

        try {
            statement = conn.prepareStatement(
                    "SELECT seller.*, department.Name as Departamento "
                    + "FROM seller INNER JOIN department "
                    + "ON seller.DepartmentId = department.Id "
                    + "WHERE seller.Id = ?");

            statement.setInt(1,id);
            rs = statement.executeQuery();

            if(rs.next()){
                Seller seller = new Seller(
                        rs.getInt("Id"),
                        rs.getString("Name"),
                        rs.getString("Email"),
                        rs.getDate("BirthDate"),
                        rs.getDouble("BaseSalary"),
                        new Department(rs.getInt("DepartmentId"),rs.getString("Departamento")));

                return seller;
            }

        } catch (SQLException e){
            throw new DBException(e.getMessage());
        } finally {
            DB.closeStatement(statement);
            DB.closeResultSet(rs);
        }
        return null;
    }

    @Override
    public List<Seller> findAll() {
        return null;
    }

    @Override
    public List<Seller> findByDepartment(Department department) {

        PreparedStatement statement = null;
        ResultSet rs = null;

        try {
            statement = conn.prepareStatement(
                    "SELECT seller.*,department.Name as Departamento "
                    + "FROM seller INNER JOIN department "
                    + "ON seller.DepartmentId = department.Id "
                    + "WHERE DepartmentId = ? "
                    + "ORDER BY Name");

            statement.setInt(1,department.getId());

            rs = statement.executeQuery();

            List<Seller> sellers = new ArrayList<>();

            /*
            * A estrutura Map que possui uma chave do tipo Integer e um elemento do tipo Department é criado.
            * Dentro do while, um objeto Department pega o elemento do map, caso não exista o elemento então essa operação retorna null.
            * Caso dep == null, o dep é finalmente instanciado.
            */

            Map<Integer,Department> map = new HashMap<>();

            while(rs.next()){
                Department dep = map.get(rs.getInt("DepartmentId"));

                if(dep == null){
                    dep = new Department(rs.getInt("DepartmentId"),rs.getString("Departamento"));
                    map.put(rs.getInt("DepartmentId"),dep);
                }

                Seller seller = new Seller(
                        rs.getInt("Id"),
                        rs.getString("Name"),
                        rs.getString("Email"),
                        rs.getDate("BirthDate"),
                        rs.getDouble("BaseSalary"),
                        dep
                );
                sellers.add(seller);
            }

            return sellers;

        } catch (SQLException e){
            throw new DBException(e.getMessage());
        } finally {
            DB.closeStatement(statement);
            DB.closeResultSet(rs);
        }
    }
}
