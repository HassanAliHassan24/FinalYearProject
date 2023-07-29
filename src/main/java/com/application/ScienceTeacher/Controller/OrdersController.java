package com.application.ScienceTeacher.Controller;

import com.application.ScienceTeacher.Entity.Client;
import com.application.ScienceTeacher.Entity.Orders;
import com.application.ScienceTeacher.Service.OrdersService;
import com.application.ScienceTeacher.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/order")
@CrossOrigin
@RequiredArgsConstructor
public class OrdersController {

    private final OrdersService ordersService;
    private final UserService userService;

    @PostMapping("/addOrders")
    public Orders makeOrders(@RequestBody Orders orders, @PathVariable long id){
        Client client = (Client) userService.findUserById(id);
        Orders createOrders = ordersService.addOrders(orders);
        createOrders.setClient(client);
        ordersService.saveCLientOrder(createOrders);
        return createOrders;
    }

    @PostMapping("/addOrders/Client/{id}")

//    localhost:8084/api/orders/getAllOrders'

    @GetMapping("/getAllOrders")
    public List<Orders> getOrders(){
        return ordersService.findAll();
    }


    @GetMapping("/getOrderById/{id}")
    public Orders getById(@PathVariable long id){
        return ordersService.findById(id);
    }



    @PutMapping("/updateOrders/{id}")
    public Orders updateOrders(@RequestBody Orders orders, @PathVariable Integer id){
        return ordersService.addOrders(orders);
    }


    @DeleteMapping("/deleteOrders/{id}")
    public void deleteOrders(@PathVariable Integer id){
        ordersService.deleteById(id);
    }
}
