package de.neuefische.cgnjava222.ordersystem.controller;


import de.neuefische.cgnjava222.ordersystem.shop.order.Order;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController extends ApiController {
    @GetMapping
    public List<Order> showAllProducts () {
        return newShop.listOrders();
    }

    @GetMapping("{id}")
    public Order getSpecificOrder(@PathVariable int id) {
        return newShop.getOrder(id);
    }

    @PostMapping
    public Order addOrder(@RequestBody List<Integer> productsToOrder){
        return newShop.addOrder(newShop.listOrders().size()+1, productsToOrder);
    }

    @DeleteMapping
    public void deleteOrder(@RequestParam int ordertodelete) {
        newShop.deleteOrder(ordertodelete);
    }
}
