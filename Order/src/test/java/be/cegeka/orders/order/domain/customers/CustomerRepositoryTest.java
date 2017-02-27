package be.cegeka.orders.order.domain.customers;

import be.cegeka.orders.order.OrderApplication;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = OrderApplication.class)
@Transactional
public class CustomerRepositoryTest {

    @PersistenceContext
    private EntityManager entityManager;

    @Inject
    private CustomerRepository customerRepository;
    private Customer seppe, johan;
    private Address address1;

    @Before
    public void setupDatabase() {
        address1 = new Address("Doelhaagstraat", 60, 2840, "Rumst");
        entityManager.persist(address1);
        Address address2 = new Address("Kerkstraat", 1, 9000, "Gent");
        entityManager.persist(address2);
        seppe = new Customer("Seppe", "Gielen", "seppe.gielen@cegeka.com", address1, "0452889878");
        johan = new Customer("Johan", "Vdw", "johan.vdw@mail.com", address2, "0485665478");


        entityManager.persist(seppe);
        entityManager.persist(johan);
    }

    @Test
    public void getAllShouldReturnAll() throws Exception {
        assertThat(customerRepository.getCustomers()).contains(seppe, johan);
    }

    @Test
    public void addCustomerShoudAddCustomer(){
        Customer paulien = new Customer("paulien", "lemay", "paulien.lemay@cegeka.com", address1, "0484558898");
        customerRepository.addCustomer(paulien);
        assertThat(customerRepository.getCustomers()).contains(seppe, johan, paulien);
    }

    @After
    public void cleanDatabase(){
        entityManager.clear();
    }
}
