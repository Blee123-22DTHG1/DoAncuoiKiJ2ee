package bai4_qlsp_LeBinh.demo.respository;

import bai4_qlsp_LeBinh.demo.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    List<Product> findByCategory_Group_Id(Integer groupId);

    List<Product> findByCategory_IdIn(List<Integer> categoryIds);

    List<Product> findByCategory_Id(Integer categoryId);
}