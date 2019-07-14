package pl.sda.storeforpets.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cart {
    private long id;
    private Item item;
    private LocalDateTime orderDate;
    private BigDecimal price;
    private BigDecimal discount123;
    private int quantity;
    private BigDecimal sumPrice;

}
