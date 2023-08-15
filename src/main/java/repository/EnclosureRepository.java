package repository;

import domain.Enclosure;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EnclosureRepository extends CrudRepository<Enclosure, Long> {
    List<Enclosure> findByEnclosureCode(String enclosureCode);
}
