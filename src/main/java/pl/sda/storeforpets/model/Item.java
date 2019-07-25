package pl.sda.storeforpets.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.sda.storeforpets.model.enums.CategoryEnum;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Item implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Enumerated
    private CategoryEnum category;
    private String name;
    private String brand;
    private double price;
    private String description;
    private int warehouseQuantity;
    private double discount;
    //    @ManyToOne(
//            cascade = {CascadeType.PERSIST, CascadeType.MERGE},
//            fetch = FetchType.LAZY)
//    @JoinColumn(name = "cart_id")
//    private Cart cart;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "item")
    private Set<Cart> shoppingCarts = new HashSet<>();

    public Item(CategoryEnum category, String name, String brand, double price, String description, int warehouseQuantity, double discount) {
        this.category = category;
        this.name = name;
        this.brand = brand;
        this.price = price;
        this.warehouseQuantity = warehouseQuantity;
        this.description = description;
        this.discount = discount;
    }
}
