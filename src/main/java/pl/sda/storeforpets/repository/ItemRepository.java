package pl.sda.storeforpets.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import pl.sda.storeforpets.model.Item;


import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long > {

    List<Item> findAllByDiscountGreaterThan(double discount);
    Item findItemById(Long id);
}
