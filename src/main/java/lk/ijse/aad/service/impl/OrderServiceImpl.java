package lk.ijse.aad.service.impl;

import lk.ijse.aad.dto.OrderDTO;
import lk.ijse.aad.entity.Customer;
import lk.ijse.aad.entity.Order;
import lk.ijse.aad.repository.CustomerRepository;
import lk.ijse.aad.repository.OrderRepository;
import lk.ijse.aad.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

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
    public OrderDTO saveOrder(OrderDTO orderDTO) {
        log.info("Order Service: saveOrder");


        // Do this by SaveOrderDTO !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        try{
            Order order = new Order();
            order.setOrderDate(orderDTO.getOrderDate());

            Optional<Customer> optionalCustomer = customerRepository.findById(orderDTO.getCustomerId());
            if(!optionalCustomer.isPresent()){
                log.error("Customer not found");
                throw new RuntimeException("Customer not found");
            }

            Customer customer = optionalCustomer.get();
            order.setCustomer(customer);

            Order orderSaved = orderRepository.save(order);

            OrderDTO orderDTOSaved = new OrderDTO(orderSaved.getId(), orderSaved.getOrderDate(), orderSaved.getCustomer().getId());
            return orderDTOSaved;


        }catch(Exception e){
            log.error("Order Service: saveOrder");
            throw e;
        }
    }
}
