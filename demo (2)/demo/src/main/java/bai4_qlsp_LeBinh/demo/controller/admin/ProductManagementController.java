package bai4_qlsp_LeBinh.demo.controller.admin;

import bai4_qlsp_LeBinh.demo.model.Product;
import bai4_qlsp_LeBinh.demo.service.CategoryService;
import bai4_qlsp_LeBinh.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/admin/products")
public class ProductManagementController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public String listProducts(Model model) {
        model.addAttribute("products", productService.getAllProducts());
        model.addAttribute("page", "product/list");
        model.addAttribute("title", "Quản lý sản phẩm");
        model.addAttribute("breadcrumb", "Sản phẩm");
        return "layouts/admin-layout";
    }
        

    @GetMapping("/create")
    public String showAddForm(Model model) {
        model.addAttribute("product", new Product());
        model.addAttribute("categories", categoryService.getAllCategories());
        model.addAttribute("page", "product/create");
        model.addAttribute("title", "Thêm sản phẩm");
        model.addAttribute("breadcrumb", "Thêm sản phẩm");
        return "layouts/admin-layout";
    }
    


    @PostMapping("/save")
    public String saveProduct(@ModelAttribute("product") Product product,
                            RedirectAttributes redirectAttributes) {
        productService.saveProduct(product);
        redirectAttributes.addFlashAttribute("success", "Thêm sản phẩm thành công!");
        return "redirect:/admin/products";
    }


    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") Integer id, Model model) {
        Product product = productService.getProductById(id);
    
        if (product == null) {
            return "redirect:/admin/products";
        }
    
        model.addAttribute("product", product);
        model.addAttribute("categories", categoryService.getAllCategories());
        model.addAttribute("page", "product/edit");
        model.addAttribute("title", "Sửa sản phẩm");
        model.addAttribute("breadcrumb", "Sửa sản phẩm");
    
        return "layouts/admin-layout";
    }
    
    

    @PostMapping("/update")
    public String updateProduct(@ModelAttribute("product") Product product,
                                RedirectAttributes redirectAttributes) {
        productService.saveProduct(product);
        redirectAttributes.addFlashAttribute("success", "Cập nhật thành công!");
        return "redirect:/admin/products";
    }
    

    @PostMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Integer id,
                                RedirectAttributes redirectAttributes) {
        productService.deleteProduct(id);
        redirectAttributes.addFlashAttribute("success", "Xóa thành công!");
        return "redirect:/admin/products";
    }    
}