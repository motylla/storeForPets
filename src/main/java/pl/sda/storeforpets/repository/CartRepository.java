package pl.sda.storeforpets.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.sda.storeforpets.model.Cart;
@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {
}
