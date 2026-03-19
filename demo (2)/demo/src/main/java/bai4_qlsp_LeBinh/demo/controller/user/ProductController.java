package bai4_qlsp_LeBinh.demo.controller.user;

import bai4_qlsp_LeBinh.demo.model.Category;
import bai4_qlsp_LeBinh.demo.model.CategoryGroup;
import bai4_qlsp_LeBinh.demo.model.Product;
import bai4_qlsp_LeBinh.demo.service.CategoryGroupService;
import bai4_qlsp_LeBinh.demo.service.CategoryService;
import bai4_qlsp_LeBinh.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryGroupService categoryGroupService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public String listProducts(
            @RequestParam(required = false) Integer groupId,
            @RequestParam(required = false) List<Integer> categoryIds,
            @RequestParam(required = false) List<String> prices,
            @RequestParam(required = false) List<String> colors,
            @RequestParam(required = false) List<String> sizes,
            @RequestParam(required = false) String sort,
            Model model
    ) {
        List<Product> productList = productService.getAllProducts();
        List<CategoryGroup> groupCategories = categoryGroupService.getAllGroups();

        List<Category> categories = new ArrayList<>();
        List<String> selectedCategoryNames = new ArrayList<>();

        String pageTitle = "Tất Cả Sản Phẩm";
        String bannerImage = "default-banner.jpg";

        if (groupId != null) {
            CategoryGroup currentGroup = categoryGroupService.getById(groupId);

            if (currentGroup != null) {
                productList = productService.getProductsByGroupId(groupId);
                categories = categoryService.getCategoriesByGroupId(groupId);
                pageTitle = "Nội Thất " + currentGroup.getName();

                if (currentGroup.getBannerImage() != null && !currentGroup.getBannerImage().isBlank()) {
                    bannerImage = currentGroup.getBannerImage();
                }

                model.addAttribute("currentGroup", currentGroup);
            }
        }

        if (categoryIds != null && !categoryIds.isEmpty()) {
            productList = productService.getProductsByCategoryIds(categoryIds);

            selectedCategoryNames = categoryService.getCategoriesByIds(categoryIds)
                    .stream()
                    .map(Category::getName)
                    .toList();
        }

        model.addAttribute("products", productList);
        model.addAttribute("groupCategories", groupCategories);
        model.addAttribute("categories", categories);

        model.addAttribute("selectedGroupId", groupId);
        model.addAttribute("selectedCategoryIds", categoryIds != null ? categoryIds : new ArrayList<>());
        model.addAttribute("selectedPrices", prices != null ? prices : new ArrayList<>());
        model.addAttribute("selectedColors", colors != null ? colors : new ArrayList<>());
        model.addAttribute("selectedSizes", sizes != null ? sizes : new ArrayList<>());
        model.addAttribute("selectedSort", sort);

        model.addAttribute("selectedCategoryNames", selectedCategoryNames);
        model.addAttribute("pageTitle", pageTitle);
        model.addAttribute("bannerImage", bannerImage);

        return "user/product/list";
    }
}