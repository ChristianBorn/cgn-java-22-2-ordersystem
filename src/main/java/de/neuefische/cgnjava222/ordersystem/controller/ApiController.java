package de.neuefische.cgnjava222.ordersystem.controller;

import de.neuefische.cgnjava222.ordersystem.shop.ShopService;
import de.neuefische.cgnjava222.ordersystem.shop.product.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RestController
@RequestMapping("/api")
public class ApiController {
    ShopService newShop = new ShopService();
}
