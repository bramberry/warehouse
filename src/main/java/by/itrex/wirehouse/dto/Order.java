package by.itrex.wirehouse.dto;

import lombok.Data;

@Data
public class Order {
  private Long customerId;
  private Item item;
}
