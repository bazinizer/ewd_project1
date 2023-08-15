package domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.ManyToMany;
import lombok.*;
import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EqualsAndHashCode(exclude = "id")
@ToString(exclude = "id")
public class Animal implements Serializable {

    private static final long serialVersionUID = 1L;

    @jakarta.persistence.Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String breed;
    private String birthDate;
    private boolean reserved;

    @ManyToMany()
    private Set<Enclosure> enclosures;

    public Animal(String name, String breed, String birthDate, boolean reserved) {
        this.name = name;
        this.breed = breed;
        this.birthDate = birthDate;
        this.reserved = reserved;
        enclosures = new HashSet<>();
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public void setReserved(boolean reserved) {
        this.reserved = reserved;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}