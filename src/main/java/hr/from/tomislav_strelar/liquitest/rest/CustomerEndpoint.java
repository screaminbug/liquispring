package hr.from.tomislav_strelar.liquitest.rest;

import hr.from.tomislav_strelar.liquitest.exception.CustomerNotFoundException;
import hr.from.tomislav_strelar.liquitest.repository.CustomerRepository;
import hr.from.tomislav_strelar.liquitest.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping(path = "customer", produces = "application/json")
public class CustomerEndpoint {

    @Autowired
    private CustomerRepository repository;

    @RequestMapping(method = GET)
    public List<Customer> get(
            @RequestParam(value = "name", defaultValue = "") String surname) {
        if (surname.equals("")) {
            return StreamSupport.stream(repository.findAll().spliterator(), false)
                    .collect(Collectors.toList());
        }
        return repository.findByLastName(surname);
    }

    @RequestMapping(path = "{id}", method = GET)
    public Customer getById(@PathVariable("id") Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new CustomerNotFoundException(id));
    }

    @RequestMapping(method = POST)
    public Customer add(@RequestBody() Customer customer) {
        return repository.save(customer);
    }
}
