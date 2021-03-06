package by.itrex.wirehouse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@SpringBootApplication
public class WarehouseApplication {

  public static void main(String[] args) {
    SpringApplication.run(WarehouseApplication.class, args);
  }

}
