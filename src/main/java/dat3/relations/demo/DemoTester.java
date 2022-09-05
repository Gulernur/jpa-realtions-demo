package dat3.relations.demo;

import dat3.relations.demo.entity.Address;
import dat3.relations.demo.entity.Person;
import dat3.relations.demo.repositories.AddressRepository;
import dat3.relations.demo.repositories.PersonRepository;
import dat3.relations.demo.service.AddressService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;

@Controller
public class DemoTester implements CommandLineRunner {

  PersonRepository personRepository;
  AddressRepository addressRepository;
  AddressService addressService;

  public DemoTester(PersonRepository personRepository, AddressRepository addressRepository, AddressService addressService) {
    this.personRepository = personRepository;
    this.addressRepository = addressRepository;
    this.addressService = addressService;
  }

  @Override
  public void run(String... args) throws Exception {
    System.out.println("I'm called when enver the program is started");

    //This is where we will add all the demo code
    Person p1 = new Person("Peter", "pe@a.dk", "hemlig");
    Person p2 = new Person("Janne", "ja@a.dk", "super-hemlig");
    Person p3 = new Person("aaa", "hdde@a.dk", "123");

    Address a1 = new Address("Lyngbyvej 22", "Lyngby");
    a1.addPerson(p1);
    a1.addPerson(p2);
    a1.addPerson(p3);

    addressRepository.save(a1);

    System.out.println("Hit Enter to fetch an adress");
    System.in.read();

    Address address = addressRepository.findById(a1.getId()).get();
    System.out.println(address.getCity());

    addressService.getAddressTrans(a1.getId(),true);
  }

}
