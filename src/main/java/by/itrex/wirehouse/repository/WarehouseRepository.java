package by.itrex.wirehouse.repository;

import by.itrex.wirehouse.dto.Warehouse;

import java.util.List;

public interface WarehouseRepository {
  void save(Warehouse warehouse);
  List<Warehouse> getAll();
  Warehouse getById(Long id);
}
