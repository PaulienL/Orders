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

    public void addCustomer(Customer customer) {
        if (getCustomers().contains(customer)) {
            throw new IllegalArgumentException("Customer already exist");
        } else {
            customerRepository.addCustomer(customer);
        }

    }

    public List<Customer> getCustomers() {
        return customerRepository.getCustomers();
    }
}
