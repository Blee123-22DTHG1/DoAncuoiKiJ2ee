package bai4_qlsp_LeBinh.demo.respository;

import bai4_qlsp_LeBinh.demo.model.CategoryGroup;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryGroupRepository extends JpaRepository<CategoryGroup, Integer> {
}