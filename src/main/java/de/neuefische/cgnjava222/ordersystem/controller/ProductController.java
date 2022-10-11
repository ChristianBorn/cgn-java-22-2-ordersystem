package de.neuefische.cgnjava222.ordersystem.controller;

import de.neuefische.cgnjava222.ordersystem.shop.ShopService;
import de.neuefische.cgnjava222.ordersystem.shop.product.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    ShopService newShop = new ShopService();

    @GetMapping
    public List<Product> showAllProducts () {
        return newShop.listProducts();
    }

    @GetMapping("{id}")
    public Product getSpecificProduct(@PathVariable int id) {
        return newShop.getProduct(id);
    }
}
