package lk.ijse.aad.service;

import lk.ijse.aad.dto.OrderDTO;
import lk.ijse.aad.dto.SaveOrderDTO;

public interface OrderService {
    OrderDTO saveOrder(SaveOrderDTO saveOrderDTO);
}
