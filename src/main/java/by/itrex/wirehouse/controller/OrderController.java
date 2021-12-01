package by.itrex.wirehouse.controller;

import by.itrex.wirehouse.dto.Order;
import by.itrex.wirehouse.dto.OrderResponse;
import by.itrex.wirehouse.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class OrderController {

  private final OrderService orderService;

  @PostMapping("orders")
  public OrderResponse createOrder(@RequestBody Order order) {
    return orderService.placeOrder(order);
  }
}
