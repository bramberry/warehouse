package by.itrex.wirehouse.repository;

import by.itrex.wirehouse.dto.DistanceUnit;

import java.util.List;

public interface DistanceRepository {
  void save(DistanceUnit distanceUnit);
  DistanceUnit getById(Long customerId, Long warehouseId);
  List<DistanceUnit> getAll();
}
