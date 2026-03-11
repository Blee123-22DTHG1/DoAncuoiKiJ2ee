package bai4_qlsp_LeBinh.demo.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import bai4_qlsp_LeBinh.demo.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
