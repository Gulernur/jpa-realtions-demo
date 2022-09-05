package dat3.relations.demo;

import dat3.relations.demo.entity.Address;
import dat3.relations.demo.entity.Person;
import dat3.relations.demo.repositories.AddressRepository;
import dat3.relations.demo.repositories.PersonRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;

@Controller
public class DemoTester implements CommandLineRunner {

  PersonRepository personRepository;
  AddressRepository addressRepository;

  public DemoTester(PersonRepository personRepository, AddressRepository addressRepository) {
    this.personRepository = personRepository;
    this.addressRepository = addressRepository;
  }

  @Override
  public void run(String... args) throws Exception {
    System.out.println("I'm called when enver the program is started");

    //This is where we will add all the demo code
    Person p1 = new Person("Peter", "pe@a.dk", "hemlig");
    Person p2 = new Person("Janne", "ja@a.dk", "super-hemlig");

    Address a1 = new Address("Lyngbyvej 22", "Lyngby");
    a1.addPerson(p1);
    a1.addPerson(p2);

    addressRepository.save(a1);

    System.out.println("Hit Enter to stop program");
    System.in.read();
  }

}
