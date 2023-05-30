package com.amit.inventoryservice;

import com.amit.inventoryservice.model.Inventory;
import com.amit.inventoryservice.repository.InventoryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaClient
public class InventoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
	}

	@Bean
	public CommandLineRunner loadData(InventoryRepository inventoryRepository){
		return args -> {
			Inventory inventory = new Inventory();
			inventory.setSkuCode("iphone_14");
			inventory.setQuantity(10);
			inventoryRepository.save(inventory);

			Inventory inventory1 = new Inventory();
			inventory1.setSkuCode("iphone_14_pro");
			inventory1.setQuantity(0);
			inventoryRepository.save(inventory1);
		};
	}

}
