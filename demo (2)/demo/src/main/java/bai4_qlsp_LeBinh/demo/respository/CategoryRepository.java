package bai4_qlsp_LeBinh.demo.respository;

import bai4_qlsp_LeBinh.demo.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
    List<Category> findByGroup_Id(Integer groupId);
}