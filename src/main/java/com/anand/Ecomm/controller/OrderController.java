package com.anand.Ecomm.controller;



import com.anand.Ecomm.dto.OrderDTO;
import com.anand.Ecomm.model.OrderRequest;
import com.anand.Ecomm.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
@CrossOrigin("*")
public class OrderController {

    @Autowired
    private OrderService orderService;
    @PostMapping("/place/{userId}")
    public OrderDTO placeOrder(@PathVariable Long userId, @RequestBody OrderRequest orderRequest)
    {
        return orderService.placeOrder(userId,orderRequest.getProductQuantities(),orderRequest.getTotalAmount());
    }

    @GetMapping("/all-orders")
    public List<OrderDTO> getAllOrders()
    {
        return orderService.getAllOrders();
    }
    @GetMapping("/user/{userId}")
    public List<OrderDTO>getOrderByUser(@PathVariable Long userId){
        return orderService.getOrderByUser(userId);

    }


}
