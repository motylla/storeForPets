package pl.sda.storeforpets;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pl.sda.storeforpets.model.Item;
import pl.sda.storeforpets.service.ItemService;

import java.util.List;

@SpringBootApplication
public class StoreforpetsApplication {

    public static void main(String[] args) {
        SpringApplication.run(StoreforpetsApplication.class, args);
    }

}
