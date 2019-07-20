package pl.sda.storeforpets.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.sda.storeforpets.model.ContactMe;

@Repository
public interface ContactMeRepository extends JpaRepository<ContactMe, Long> {
}
