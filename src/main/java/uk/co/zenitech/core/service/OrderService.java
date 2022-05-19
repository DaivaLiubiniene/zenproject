package uk.co.zenitech.core.service;

import org.springframework.stereotype.Service;
import uk.co.zenitech.core.model.Order;
import uk.co.zenitech.core.repository.OrderRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) { this.orderRepository = orderRepository; }

    @Transactional
    public Order getOrderById(Long id) {
        return orderRepository.getById(id);
    }

    @Transactional
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @Transactional
    public Order addOrder(Order order) {
        return orderRepository.save(order);
    }

    @Transactional
    public void deleteOrderById(Long id) {
        orderRepository.deleteById(id);
    }

}
