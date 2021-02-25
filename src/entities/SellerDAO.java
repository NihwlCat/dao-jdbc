package entities;

import java.util.List;

public interface SellerDAO {
    void insert(Seller obj);
    void update(Seller obj);
    void deleteById(Integer id);
    Seller findById(Integer id);
    List<Seller> findAll();

    // Buscar através de departamentos
    List<Seller> findByDepartment(Department department);
}
