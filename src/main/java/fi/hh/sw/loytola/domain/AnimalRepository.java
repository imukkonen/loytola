package fi.hh.sw.loytola.domain;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import fi.hh.sw.loytola.domain.Animal;


public interface AnimalRepository extends CrudRepository<Animal, Long>{
	List<Animal> findByName(@Param("name") String name);
	//int st=0;
	//int th=1;
	List<Animal> findByStatus(int st);
	List<Animal> findByTheme(int st); // löytänyt eläimet admin
	List<Animal> findByStatusAndTheme (int st, int th); //kadonnut eläimet käyttäjälle
	List<Animal> findByAnimalKindAndStatus (AnimalKind kind, int st);
	
}
