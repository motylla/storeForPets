package pl.sda.storeforpets.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.sda.storeforpets.model.enums.CategoryEnum;

import javax.persistence.Entity;
import java.math.BigDecimal;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
class Item {
    private BigDecimal price;
    private String name;
    private int warehouseQuantity;
    private BigDecimal discount;
    private CategoryEnum category;

}
