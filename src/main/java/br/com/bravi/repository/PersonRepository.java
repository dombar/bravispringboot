package br.com.bravi.repository;

import br.com.bravi.model.PersonTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<PersonTO, Integer> {

}
