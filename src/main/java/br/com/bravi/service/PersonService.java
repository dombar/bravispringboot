package br.com.bravi.service;

import br.com.bravi.model.PersonVO;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface PersonService {
    List<PersonVO> getAllPerson();

    PersonVO getPersonById(Integer id);

    void saveOrUpdate(PersonVO person);

    @Transactional
    void deletePerson(Integer id);
}
