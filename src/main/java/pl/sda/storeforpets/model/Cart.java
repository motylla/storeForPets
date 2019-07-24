package pl.sda.storeforpets.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cart implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;


    //    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "cart")
//    List<Item> items = new ArrayList<>();
//    private LocalDateTime orderDate = LocalDateTime.now();
//    private int quantity;
//
//
//    public Cart(List<Item> items, int quantity) {
//        this.items = items;
//        this.quantity = quantity;
//
//    }
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "item_id")
    public Item item;
    @NotNull
    private int stock;
    private double amount;
    private LocalDateTime orderDate = LocalDateTime.now();
}
