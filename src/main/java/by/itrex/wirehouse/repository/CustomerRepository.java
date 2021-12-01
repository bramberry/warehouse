package by.itrex.wirehouse.repository;

import by.itrex.wirehouse.dto.Customer;

public interface CustomerRepository {
  Customer save(Customer customer);
  Customer getById(Long id);
}
