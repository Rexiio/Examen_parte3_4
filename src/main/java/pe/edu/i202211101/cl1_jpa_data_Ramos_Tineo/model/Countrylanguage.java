package pe.edu.i202211101.cl1_jpa_data_Ramos_Tineo.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@IdClass(CountryLanguageId.class)
@Entity
public class Countrylanguage {
    @Id
    private String Language;
    private String isOfficial;
    private Double Percentage;
    @Id
    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name = "CountryCode", nullable = false)
    private Country country;

}
