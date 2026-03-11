package bai4_qlsp_LeBinh.demo.service;

import org.springframework.stereotype.Service;

import bai4_qlsp_LeBinh.demo.model.Product;
import bai4_qlsp_LeBinh.demo.respository.CategoryRepository;
import bai4_qlsp_LeBinh.demo.respository.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;
    
    @Autowired
    private CategoryRepository categoryRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public void saveProduct(Product product) {
        productRepository.save(product);
    }

    public Product getProductById(int id) {
        return productRepository.findById(id).orElse(null);
    }

    public void deleteProduct(int id) {
        productRepository.deleteById(id);
    }
}