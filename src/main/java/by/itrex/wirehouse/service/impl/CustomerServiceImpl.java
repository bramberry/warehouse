package by.itrex.wirehouse.service.impl;

import by.itrex.wirehouse.dto.Customer;
import by.itrex.wirehouse.dto.DistanceUnit;
import by.itrex.wirehouse.dto.Warehouse;
import by.itrex.wirehouse.repository.CustomerRepository;
import by.itrex.wirehouse.repository.DistanceRepository;
import by.itrex.wirehouse.repository.WarehouseRepository;
import by.itrex.wirehouse.service.CustomerService;
import by.itrex.wirehouse.util.DistanceCalculator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

  private final WarehouseRepository warehouseRepository;
  private final CustomerRepository customerRepository;
  private final DistanceRepository distanceRepository;

  @Override
  public Customer create(Customer customer) {
    Customer persisted = customerRepository.save(customer);

    saveDistancesToWarehouses(persisted);
    return customer;
  }

  // ideally make async
  public void saveDistancesToWarehouses(Customer persisted) {
    List<Warehouse> warehouses = warehouseRepository.getAll();
    warehouses.forEach(warehouse -> distanceRepository.save(
        DistanceUnit.builder()
            .customerId(persisted.getId())
            .warehouseId(warehouse.getId())
            .distance(DistanceCalculator.calculate(
                persisted.getDeliveryLat(),
                persisted.getDeliveryLon(),
                warehouse.getLat(),
                warehouse.getLon()
            ))
            .build()));
  }
}
