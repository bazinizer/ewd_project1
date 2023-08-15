package service;

import domain.Enclosure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.EnclosureRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class EnclosureServiceImpl implements EnclosureService{
    @Autowired
    private  EnclosureRepository enclosureRepository;

    @Override
    public List<Enclosure> getAllEnclosures() {
        return StreamSupport.stream(enclosureRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }


    @Override
    public Optional<Enclosure> getEnclosureById(Long enclosureId) {
        return enclosureRepository.findById(enclosureId);
    }

    @Override
    public Enclosure addEnclosure(Enclosure enclosure) {
        return enclosureRepository.save(enclosure);
    }

    @Override
    public void deleteEnclosure(Long enclosureId) {
        enclosureRepository.deleteById(enclosureId);
    }

}
