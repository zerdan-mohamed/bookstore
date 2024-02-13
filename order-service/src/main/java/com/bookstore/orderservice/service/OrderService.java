package com.bookstore.orderservice.service;

import com.bookstore.orderservice.model.Order;
import com.bookstore.orderservice.model.Book;
import com.bookstore.orderservice.model.OrderItem;
import com.bookstore.orderservice.repository.OrderItemRepository;
import com.bookstore.orderservice.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final OrderItemRepository orderItemRepository;

    private final BookInventoryClient bookInventoryClient;

    public OrderService(
            OrderRepository orderRepository,
            OrderItemRepository orderItemRepository,
            BookInventoryClient bookInventoryClient
    ) {
        this.orderRepository = orderRepository;
        this.orderItemRepository = orderItemRepository;
        this.bookInventoryClient = bookInventoryClient;
    }

    public Order createOrder(Order order) {
        // Use bookInventoryClient to fetch book details
        Book book = bookInventoryClient.getBookById(order.getBookId());
        System.out.println("@@@@@@@@@" +book.getId());

        // for (OrderItem item : order.getOrderItems()) {
        //    item.setOrder(savedOrder);
        //    orderItemRepository.save(item);
        //}
        return orderRepository.save(order);
    }

    public Order getOrderById(Long id) {
        return orderRepository.findById(id).orElse(null);
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Order updateOrder(Long id, Order orderDetails) {
        Optional<Order> orderOptional = orderRepository.findById(id);
        if (orderOptional.isPresent()) {
            Order existingOrder = orderOptional.get();
            return orderRepository.save(existingOrder);
        } else {
            return null;
        }
    }
}
