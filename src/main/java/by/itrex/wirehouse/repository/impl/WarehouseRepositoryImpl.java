package by.itrex.wirehouse.repository.impl;

import by.itrex.wirehouse.dto.Item;
import by.itrex.wirehouse.dto.Warehouse;
import by.itrex.wirehouse.repository.WarehouseRepository;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class WarehouseRepositoryImpl implements WarehouseRepository {

  private static Map<Long, Warehouse> warehouses = new HashMap<>();
  private AtomicLong warehouseSequence = new AtomicLong();

  @PostConstruct
  public void init() {
    Long id = warehouseSequence.incrementAndGet();
    warehouses.put(id, Warehouse.builder()
        .id(id)
        .lat(53.844521)
        .lon(27.628827)
        .items(List.of(Item.builder().name("Iphone 13").build()))
        .build());
    id = warehouseSequence.incrementAndGet();
    warehouses.put(id, Warehouse.builder()
        .id(id)
        .lat(53.839107)
        .lon(27.581971)
        .items(List.of(Item.builder().name("Iphone 12").build(),Item.builder().name("Iphone 13").build()))
        .build());
    id = warehouseSequence.incrementAndGet();
    warehouses.put(id, Warehouse.builder()
        .id(id)
        .lat(53.908821)
        .lon(27.434183)
        .items(List.of(Item.builder().name("Samsung A55").build()))
        .build());
    id = warehouseSequence.incrementAndGet();
    warehouses.put(id, Warehouse.builder()
        .id(id)
        .lat(53.965109)
        .lon(27.537641)
        .items(List.of(Item.builder().name("Xiaomi Mi 11").build()))
        .build());
    id = warehouseSequence.incrementAndGet();
    warehouses.put(id, Warehouse.builder()
        .id(id)
        .lat(53.960544)
        .lon(27.633067)
        .items(List.of(Item.builder().name("Xiaomi Mi 10").build()))
        .build());
    id = warehouseSequence.incrementAndGet();
    warehouses.put(id, Warehouse.builder()
        .id(id)
        .lat(53.942698)
        .lon(27.682412)
        .items(List.of())
        .build());
  }

  @Override
  public void save(Warehouse warehouse) {
    warehouses.put(warehouseSequence.incrementAndGet(), warehouse);
  }

  @Override
  public List<Warehouse> getAll() {
    return new ArrayList<>(warehouses.values());
  }

  @Override
  public Warehouse getById(Long id) {
    return warehouses.get(id);
  }
}
