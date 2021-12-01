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

  private static final Map<Long, Warehouse> WAREHOUSES = new HashMap<>();
  private final AtomicLong warehouseSequence = new AtomicLong();

  @PostConstruct
  public void init() {
    Long id = warehouseSequence.incrementAndGet();
    WAREHOUSES.put(id, Warehouse.builder()
        .id(id)
        .lat(53.844521)
        .lon(27.628827)
        .name("Чижовка Арена")
        .items(List.of(Item.builder().name("Iphone 13").build()))
        .build());
    id = warehouseSequence.incrementAndGet();
    WAREHOUSES.put(id, Warehouse.builder()
        .id(id)
        .lat(53.849489)
        .lon(27.474956)
        .name("Малиновка метро")
        .items(List.of(Item.builder().name("Iphone 12").build(), Item.builder().name("Iphone 13").build()))
        .build());
    id = warehouseSequence.incrementAndGet();
    WAREHOUSES.put(id, Warehouse.builder()
        .id(id)
        .lat(53.908821)
        .lon(27.434183)
        .name("Грин на Каменке")
        .items(List.of(Item.builder().name("Samsung A55").build()))
        .build());
    id = warehouseSequence.incrementAndGet();
    WAREHOUSES.put(id, Warehouse.builder()
        .id(id)
        .lat(53.935930)
        .lon(27.481638)
        .name("Минск-арена")
        .items(List.of(Item.builder().name("Xiaomi Mi 11").build()))
        .build());
    id = warehouseSequence.incrementAndGet();
    WAREHOUSES.put(id, Warehouse.builder()
        .id(id)
        .lat(53.960544)
        .lon(27.633067)
        .name("Мак Уручье")
        .items(List.of(Item.builder().name("Xiaomi Mi 10").build()))
        .build());
    id = warehouseSequence.incrementAndGet();
    WAREHOUSES.put(id, Warehouse.builder()
        .id(id)
        .lat(53.942698)
        .lon(27.682412)
        .items(List.of())
        .build());
  }

  @Override
  public void save(Warehouse warehouse) {
    WAREHOUSES.put(warehouseSequence.incrementAndGet(), warehouse);
  }

  @Override
  public List<Warehouse> getAll() {
    return new ArrayList<>(WAREHOUSES.values());
  }

  @Override
  public Warehouse getById(Long id) {
    return WAREHOUSES.get(id);
  }
}
