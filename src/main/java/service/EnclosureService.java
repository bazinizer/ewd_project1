package service;

import domain.Enclosure;

import java.util.List;
import java.util.Optional;

public interface EnclosureService {
    List<Enclosure> getAllEnclosures();
    Optional<Enclosure> getEnclosureById(Long enclosureId);
    Enclosure addEnclosure(Enclosure enclosure);
    void deleteEnclosure(Long enclosureId);
}
