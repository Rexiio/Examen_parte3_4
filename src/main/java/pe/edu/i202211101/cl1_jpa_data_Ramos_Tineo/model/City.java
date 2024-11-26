package pe.edu.i202211101.cl1_jpa_data_Ramos_Tineo.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID;
    private String Name;
    private String District;
    private int Population;

    @ManyToOne
    @ToString.Exclude
    @JoinColumn(name = "CountryCode")
    private Country country;

}
