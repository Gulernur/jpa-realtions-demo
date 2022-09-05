package dat3.relations.demo.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Address {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  int id;
  String street;
  String city;

  public Address(String street, String city) {
    this.street = street;
    this.city = city;
  }

  public Address() {}

  @OneToMany(mappedBy = "address", cascade = CascadeType.ALL, fetch = FetchType.LAZY)  //Unidirectional relationship
  //@JoinColumn(name = "address_id")
  private List<Person> persons = new ArrayList<>();

  public void addPerson(Person person){
    persons.add(person);
    person.setAddress(this);
  }

  public List<Person> getPersons(){
    return persons;
  }


  // Getters Setters
  public int getId() {
    return id;
  }

  public String getStreet() {
    return street;
  }

  public void setStreet(String street) {
    this.street = street;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }
}
