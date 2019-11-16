package br.com.bravi.controller;

import br.com.bravi.model.PersonVO;
import br.com.bravi.service.PersonService;
import br.com.bravi.util.PersonBadRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("person")
public class PersonContoller {

    @Autowired
    private PersonService personService;

    /**
     * Retorna lista de contatos
     * @return
     */
    @GetMapping(value = "/all", produces = "application/json")
    public List<PersonVO> getAllPerson() {
        return personService.getAllPerson();
    }

    /**
     * Retorna um contato pela seu id
     * @param id
     * @return
     */
    @GetMapping(value = "{id}", produces = "application/json")
    public PersonVO getPersonById(@PathVariable Integer id) {
        return personService.getPersonById(id);
    }

    /**
     * Salva um novo contato
     * @param person
     */
    @PostMapping(value = "", consumes = "application/json", produces = "application/json")
    public void create(@RequestBody PersonVO person) {

        if (person == null) {
            throw new PersonBadRequest("object person");
        }

        if (person.getName() == null || person.getName().isEmpty()) {
            throw new PersonBadRequest("name");
        }

        person.setId(null);

        personService.saveOrUpdate(person);
    }

    /**
     * Editar um contato existente
     * @param id
     * @param person
     */
    @PutMapping(value = "{id}", consumes = "application/json", produces = "application/json")
    public void edit(@PathVariable Integer id, @RequestBody PersonVO person) {
        if (person == null) {
            throw new PersonBadRequest("object person");
        }

        if (id == null) {
            throw new PersonBadRequest("id");
        }

        person.setId(id);

        personService.saveOrUpdate(person);
    }

    /**
     * Remove um contato
     * @param id
     */
    @DeleteMapping(value = "{id}")
    public void delete(@PathVariable Integer id) {

        if (id == null) {
            throw new PersonBadRequest("id");
        }

        personService.deletePerson(id);
    }

}
