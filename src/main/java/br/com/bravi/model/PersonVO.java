package br.com.bravi.model;

import java.util.ArrayList;
import java.util.List;

public class PersonVO {

    private Integer id;

    private String name;

    private List<String> email;

    private List<String> whatsapp;

    private List<String> phone;

    public Integer getId() {
        return id;
    }

    public static PersonVO objectPerson(PersonTO person) {
        PersonVO vo = new PersonVO();
        vo.setId(person.getId());
        vo.setName(person.getName());
        vo.setEmail(new ArrayList<>(person.getEmail()));
        vo.setWhatsapp(new ArrayList<>(person.getWhatsApps()));
        vo.setPhone(new ArrayList<>(person.getPhone()));
        return vo;
    }

    public static List<PersonVO> objectPersonList(List<PersonTO> person) {
        List<PersonVO> vo = new ArrayList<>();
        person.forEach(x -> vo.add(objectPerson(x)));
        return vo;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getEmail() {
        return email;
    }

    public void setEmail(List<String> email) {
        this.email = email;
    }

    public List<String> getWhatsapp() {
        return whatsapp;
    }

    public void setWhatsapp(List<String> whatsapp) {
        this.whatsapp = whatsapp;
    }

    public List<String> getPhone() {
        return phone;
    }

    public void setPhone(List<String> phone) {
        this.phone = phone;
    }
}
