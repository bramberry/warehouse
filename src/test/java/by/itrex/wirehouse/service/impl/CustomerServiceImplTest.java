package by.itrex.wirehouse.service.impl;

import by.itrex.wirehouse.dto.Customer;
import by.itrex.wirehouse.repository.DistanceRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class CustomerServiceImplTest {
  @Autowired
  private CustomerServiceImpl customerService;
  @Autowired
  private DistanceRepository distanceRepository;

  @Test
  void testCreate() {
    Customer customer = new Customer();
    customer.setDeliveryLat(53.889469);
    customer.setDeliveryLon(27.536605);

    Customer persisted = customerService.create(customer);
    assertEquals(1L, persisted.getId());
    assertEquals(customer.getDeliveryLat(), persisted.getDeliveryLat());
    assertEquals(customer.getDeliveryLon(), persisted.getDeliveryLon());
    distanceRepository.getAll()
        .forEach(distanceUnit -> {
          assertEquals(persisted.getId(), distanceUnit.getCustomerId());
          assertNotNull(distanceUnit.getDistance());
        });
  }
}