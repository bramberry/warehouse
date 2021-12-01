package by.itrex.wirehouse.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Warehouse {
  private Long id;
  private String name;
  private Double lat;
  private Double lon;
  private List<Item> items;
}
