package be.cegeka.orders.order.domain.customers;

import be.cegeka.orders.order.OrderApplication;
import be.cegeka.orders.order.domain.repository.CustomerRepository;
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

    @Before
    public void setupDatabase() {
        seppe = new Customer("Seppe", "Gielen");
        johan = new Customer("Johan", "Vdw");

        entityManager.persist(seppe);
        entityManager.persist(johan);
    }

    @Test
    public void getAllShouldReturnAll() throws Exception {
        assertThat(customerRepository.getAll()).contains(seppe, johan);
    }

    @Test
    public void addCustomerShoudAddCustomer(){
        Customer paulien = new Customer("paulien", "lemay");
        customerRepository.addCustomer(paulien);
        assertThat(customerRepository.getAll()).contains(seppe, johan, paulien);
    }

    @After
    public void cleanDatabase(){
        entityManager.clear();
    }
}
