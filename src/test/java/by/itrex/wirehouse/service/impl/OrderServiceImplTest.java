package by.itrex.wirehouse.service.impl;

import by.itrex.wirehouse.dto.Customer;
import by.itrex.wirehouse.dto.Item;
import by.itrex.wirehouse.dto.Order;
import by.itrex.wirehouse.dto.OrderResponse;
import by.itrex.wirehouse.repository.DistanceRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class OrderServiceImplTest {

  @Autowired
  private OrderServiceImpl orderService;
  @Autowired
  private CustomerServiceImpl customerService;

  private Customer customer;

  @BeforeEach
  void setUp() {
    Customer template = new Customer();
    template.setDeliveryLat(53.889469);
    template.setDeliveryLon(27.536605);
    customer = customerService.create(template);
  }

  @Test
  void placeOrder(){
    Order order = new Order();
    order.setCustomerId(customer.getId());
    order.setItem(Item.builder().name("Iphone 13").build());

    OrderResponse orderResponse = orderService.placeOrder(order);
    assertEquals(2L, orderResponse.getWarehouseId());
    assertEquals(6.0083495743390465, orderResponse.getDistance());
    assertEquals(order.getItem().getName(), orderResponse.getMessage());
  }
}