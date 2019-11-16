package br.com.bravi.model;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
@Table(name = "person")
public class PersonTO implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "person_id")
    private Integer id;

    @Column(name = "name", length = 100, nullable = false)
    private String name;

    @ElementCollection
    @CollectionTable(name = "person_email", joinColumns = @JoinColumn(name = "person_id"))
    @Column(name = "email")
    private Set<String> email = new HashSet<>();

    @ElementCollection
    @CollectionTable(name = "person_whatsapp", joinColumns = @JoinColumn(name = "person_id"))
    @Column(name = "whatsapp")
    private Set<String> whatsApps = new HashSet<>();

    @ElementCollection
    @CollectionTable(name = "person_phone", joinColumns = @JoinColumn(name = "person_id"))
    @Column(name = "phone")
    private Set<String> phone = new HashSet<>();

    public Integer getId() {
        return id;
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

    public Set<String> getEmail() {
        return email;
    }

    public void setEmail(Set<String> email) {
        this.email = email;
    }

    public Set<String> getWhatsApps() {
        return whatsApps;
    }

    public void setWhatsApps(Set<String> whatsApps) {
        this.whatsApps = whatsApps;
    }

    public Set<String> getPhone() {
        return phone;
    }

    public void setPhone(Set<String> phone) {
        this.phone = phone;
    }


}
