package gq.vaccum121;

import gq.vaccum121.data.Customer;
import gq.vaccum121.data.CustomerRepository;
import gq.vaccum121.data.Dish;
import gq.vaccum121.data.DishRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UFoodDeliveryApplication implements CommandLineRunner {
    @Autowired
    private CustomerRepository repository;

    @Autowired
    private  DishRepository dishRepository;

    public static void main(String[] args) {
        SpringApplication.run(UFoodDeliveryApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        repository.deleteAll();
        dishRepository.deleteAll();

        // save a couple of customers
        repository.save(new Customer("Alice", "Smith"));
        repository.save(new Customer("Bob", "Smith"));

        dishRepository.save(new Dish("Pizza",200,300));
        dishRepository.save(new Dish("Coca-Cola",200,29));

        // fetch all customers
        System.out.println("Customers found with findAll():");
        System.out.println("-------------------------------");
        repository.findAll().forEach(System.out::println);
        System.out.println();

        // fetch an individual customer
        System.out.println("Customer found with findByFirstName('Alice'):");
        System.out.println("--------------------------------");
        System.out.println(repository.findByFirstName("Alice"));

        System.out.println("Customers found with findByLastName('Smith'):");
        System.out.println("--------------------------------");
        for (Customer customer : repository.findByLastName("Smith")) {
            System.out.println(customer);
        }

    }
}
