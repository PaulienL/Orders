package be.cegeka.orders.order.domain.customers;

import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import static org.mockito.ArgumentMatchers.refEq;
import static org.mockito.Mockito.verify;

/**
 * Created by xanv on 24/02/2017.
 */
public class CustomerServiceTest {
    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @InjectMocks
    private CustomerService customerService;

    @Mock
    private CustomerRepository customerRepository;

    @Test
    public void addCustomer() throws Exception {
        Address address1 = new Address("Doelhaagstraat", 60, 2840, "Rumst");
        Customer customer=new Customer("paulien", "lemay", "paulien.lemay@cegeka.com", address1, "0485665878");
        customerService.addCustomer("paulien", "lemay","paulien.lemay@cegeka.com", address1, "0485665878");
        verify(customerRepository).addCustomer(refEq(customer));
    }



}