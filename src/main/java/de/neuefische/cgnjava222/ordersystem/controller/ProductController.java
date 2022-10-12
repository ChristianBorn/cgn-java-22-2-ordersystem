package de.neuefische.cgnjava222.ordersystem.controller;


import de.neuefische.cgnjava222.ordersystem.shop.product.Product;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController extends ApiController {


    @GetMapping
    public List<Product> showAllProducts () {
        return newShop.listProducts();
    }

    @GetMapping("{id}")
    public Product getSpecificProduct(@PathVariable int id) {
        return newShop.getProduct(id);
    }

    @PostMapping
    public void addNewProduct(@RequestParam Product productocreate) {
        newShop.addNewProduct(productocreate);
    }
}
