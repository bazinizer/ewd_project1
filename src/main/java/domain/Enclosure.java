package domain;


import jakarta.persistence.*;
import lombok.*;


import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EqualsAndHashCode(exclude = "id")
@ToString(exclude = "id")
public class Enclosure implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String enclosureCode;
    private String enclosureName;

    @ManyToMany(mappedBy = "enclosures")
    private Set<Animal> animals;

    public Enclosure(String enclosureCode, String enclosureName) {
        this.enclosureCode = enclosureCode;
        this.enclosureName = enclosureName;
        animals = new HashSet<>();
    }

    public void setEnclosureCode(String enclosureCode) {
        this.enclosureCode = enclosureCode;
    }

    public void setEnclosureName(String enclosureName) {
        this.enclosureName = enclosureName;
    }
}