package bai4_qlsp_LeBinh.demo.respository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import bai4_qlsp_LeBinh.demo.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
}
