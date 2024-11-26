package pe.edu.i202211101.cl1_jpa_data_Ramos_Tineo;

import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pe.edu.i202211101.cl1_jpa_data_Ramos_Tineo.model.Country;
import pe.edu.i202211101.cl1_jpa_data_Ramos_Tineo.repository.CountryRepository;

import java.util.Arrays;
import java.util.Optional;

@SpringBootApplication
public class RamosFabianPrt3Application implements CommandLineRunner {
	@Autowired
	CountryRepository countryRepository;
	public static void main(String[] args) {
		SpringApplication.run(RamosFabianPrt3Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// Buscar el país con código "ARG"
		Optional<Country> argentina = countryRepository.findById("ARG");
		argentina.ifPresentOrElse(
				Country -> {
					System.out.println("Lenguajes de Argentina:");
					Country.getLanguages().forEach(language -> System.out.println(language.getLanguage()));
				},
				() -> {
					// Si no se encuentra "ARG", buscar "PER"
					Optional<Country> perCountry = countryRepository.findById("PER");
					perCountry.ifPresent(per -> {
						System.out.println("Lenguajes de Perú:");
						per.getLanguages().forEach(lang -> System.out.println(lang.getLanguage()));
					});
				}
		);

		/*
		List<String> countryIdsToDelete = Arrays.asList("COL", "ARG");
		countryRepository.deleteAllById(countryIdsToDelete);
		System.out.println("Países eliminados con sus ciudades y lenguajes asociados");*/
	}
}
