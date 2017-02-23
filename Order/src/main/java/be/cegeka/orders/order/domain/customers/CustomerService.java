package be.cegeka.orders.order.domain.customers;

import be.cegeka.orders.order.domain.orders.Order;

import javax.inject.Inject;
import javax.inject.Named;

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

    public void addCustomerWithOrder(String firstName, String lastName, String orderDate) {
        Customer customer=new Customer(firstName, lastName);
        customer.addOrder(new Order(orderDate));
    }
}
