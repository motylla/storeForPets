package pl.sda.storeforpets.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import pl.sda.storeforpets.model.Item;


import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long > {
}
