package javagda21.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Trip implements IBaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    private Town from;
    @ManyToOne
    private Town to;
    private LocalDate dateOfDeparture;
    private LocalDate dateOfArrive;
    private boolean promoted;
    private int avibleSitsForAdult;
    private int avibleSitesForKids;
    @ManyToOne
    private Hotel hotel;
}
