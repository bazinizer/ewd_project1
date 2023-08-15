package domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.ManyToOne;
import lombok.*;
import org.springframework.data.annotation.Id;

import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EqualsAndHashCode(exclude = "id")
@ToString(exclude = "id")
public class Reservation implements Serializable {

    private static final long serialVersionUID = 1L;

    @jakarta.persistence.Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user;

    @ManyToOne
    private Animal animal;

    private boolean reserved;

    public Reservation(User user, Animal animal, boolean reserved) {
        this.user = user;
        this.animal = animal;
        this.reserved = reserved;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
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
