package by.itrex.wirehouse.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DistanceUnit {
  private Long customerId;
  private Long warehouseId;
  private Double distance;
}
