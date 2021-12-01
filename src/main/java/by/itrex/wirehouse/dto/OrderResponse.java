package by.itrex.wirehouse.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OrderResponse {
  private String message;
  private Double distance;
  private Long warehouseId;
}
