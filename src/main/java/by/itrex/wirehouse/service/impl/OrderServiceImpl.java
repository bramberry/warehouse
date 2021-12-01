package by.itrex.wirehouse.service.impl;

import by.itrex.wirehouse.dto.DistanceUnit;
import by.itrex.wirehouse.dto.Order;
import by.itrex.wirehouse.dto.OrderResponse;
import by.itrex.wirehouse.repository.DistanceRepository;
import by.itrex.wirehouse.repository.WarehouseRepository;
import by.itrex.wirehouse.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

  private final WarehouseRepository warehouseRepository;
  private final DistanceRepository distanceRepository;

  @Override
  public OrderResponse placeOrder(Order order) {
    return warehouseRepository.getAll().stream()
        .filter(warehouse -> warehouse.getItems().contains(order.getItem()))
        .map(warehouse -> distanceRepository.getById(order.getCustomerId(), warehouse.getId()))
        .min(Comparator.comparingDouble(DistanceUnit::getDistance))
        .stream()
        .map(distanceUnit ->
            OrderResponse.builder()
                .distance(distanceUnit.getDistance())
                .warehouseId(distanceUnit.getWarehouseId())
                .message(order.getItem().getName())
                .build())
        .findFirst()
        .orElseThrow();
  }
}
