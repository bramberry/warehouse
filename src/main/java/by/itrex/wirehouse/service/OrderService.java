package by.itrex.wirehouse.service;


import by.itrex.wirehouse.dto.Order;
import by.itrex.wirehouse.dto.OrderResponse;

public interface OrderService {
  OrderResponse placeOrder(Order order);
}
