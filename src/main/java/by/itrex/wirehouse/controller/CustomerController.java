package by.itrex.wirehouse.controller;

import by.itrex.wirehouse.dto.Customer;
import by.itrex.wirehouse.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CustomerController {

  private final CustomerService customerService;

  @PostMapping("customers")
  public Customer createCustomer(@RequestBody Customer customer) {
    return customerService.create(customer);
  }
}
