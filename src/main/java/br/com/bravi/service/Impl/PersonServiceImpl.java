package br.com.bravi.service.Impl;

import br.com.bravi.model.PersonTO;
import br.com.bravi.model.PersonVO;
import br.com.bravi.repository.PersonRepository;
import br.com.bravi.service.PersonService;
import br.com.bravi.util.PersonException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Override
    public List<PersonVO> getAllPerson() {

        List<PersonTO> person = personRepository.findAll();
        if (person != null) {
            return PersonVO.objectPersonList(person);
        }
        return new ArrayList<>();

    }

    @Override
    public PersonVO getPersonById(Integer id) {

        Optional<PersonTO> person = personRepository.findById(id);

        return PersonVO.objectPerson(person.orElseThrow(() -> new PersonException(id)));

    }

    private PersonTO findPersonById(Integer id) {
        Optional<PersonTO> person = personRepository.findById(id);
        return person.orElseThrow(() -> new PersonException(id));
    }

    @Override
    @Transactional
    public void saveOrUpdate(PersonVO person) {

        if (person.getId() != null) {
            PersonTO objectPerson = findPersonById(person.getId());
            personRepository.save(setObjectPerson(objectPerson, person));
        } else {
            personRepository.save(setObjectPerson(new PersonTO(), person));
        }
    }

    @Override
    @Transactional
    public void deletePerson(Integer id) {
        PersonTO person = findPersonById(id);
        personRepository.delete(person);
    }

    private PersonTO setObjectPerson(PersonTO objectPerson, PersonVO person) {
        objectPerson.setName(person.getName());
        objectPerson.setEmail(person.getEmail() != null ? new HashSet<>(person.getEmail()) : new HashSet<>());
        objectPerson.setPhone(person.getPhone() != null ? new HashSet<>(person.getPhone()) : new HashSet<>());
        objectPerson.setWhatsApps(person.getWhatsapp() != null ? new HashSet<>(person.getWhatsapp()) : new HashSet<>());
        return objectPerson;
    }

}
