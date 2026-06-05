package lk.ijse.aad.service.impl;

import lk.ijse.aad.dto.OrderDTO;
import lk.ijse.aad.dto.SaveOrderDTO;
import lk.ijse.aad.entity.Customer;
import lk.ijse.aad.entity.Order;
import lk.ijse.aad.repository.CustomerRepository;
import lk.ijse.aad.repository.OrderRepository;
import lk.ijse.aad.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final CustomerRepository customerRepository;

    public OrderServiceImpl(OrderRepository orderRepository, CustomerRepository customerRepository) {
        this.orderRepository = orderRepository;
        this.customerRepository = customerRepository;
    }

    @Override
    public OrderDTO saveOrder(SaveOrderDTO saveOrderDTO) {
        log.info("Order Service: saveOrder invoked with SaveOrderDTO");

        try {
            Optional<Customer> optionalCustomer = customerRepository.findById(saveOrderDTO.getCustomerId());
            if (!optionalCustomer.isPresent()) {
                log.error("Save order failed. Customer with ID {} does not exist", saveOrderDTO.getCustomerId());
                throw new RuntimeException("Customer not found");
            }
            Customer customer = optionalCustomer.get();

            Order order = new Order();
            order.setOrderDate(new Date());
            order.setTotal(saveOrderDTO.getTotal());
            order.setDescription(saveOrderDTO.getDescription());
            order.setCustomer(customer);

            Order orderSaved = orderRepository.save(order);
            log.info("Order saved successfully with dynamic DB ID: {}", orderSaved.getId());

            return new OrderDTO(
                    orderSaved.getId(),
                    orderSaved.getOrderDate(),
                    orderSaved.getCustomer().getId()
            );

        } catch (Exception e) {
            log.error("Error occurred while saving the order: " + e.getMessage());
            throw e;
        }
    }
}