package be.cegeka.orders.order.domain.customers;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

/**
 * Created by christom on 23/02/2017.
 */
@Named
public class CustomerService {
    @Inject
    CustomerRepository customerRepository;

    public void addCustomer(String firstName, String lastName) {
        customerRepository.addCustomer(new Customer(firstName, lastName));
    }

    public List<Customer> getCustomers() {
        return customerRepository.getCustomers();
    }
}
