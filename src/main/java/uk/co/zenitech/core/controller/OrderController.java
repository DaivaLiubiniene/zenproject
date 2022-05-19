package uk.co.zenitech.core.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uk.co.zenitech.core.model.Order;
import uk.co.zenitech.core.service.OrderService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) { this.orderService = orderService; }

    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(orderService.getOrderById(id));
    }

    @GetMapping
    public ResponseEntity<List<Order>> getAllOrders() {
        return ResponseEntity.status(HttpStatus.OK).body(orderService.getAllOrders());
    }

    @PostMapping
    public ResponseEntity<Order> addOrder(@RequestBody @Valid Order order) {
        return ResponseEntity.status(HttpStatus.CREATED).body(orderService.addOrder(order));
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteOrderById(@PathVariable Long id) {
        orderService.deleteOrderById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
