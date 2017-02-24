package be.cegeka.orders.order.domain.orders;

import be.cegeka.orders.order.OrderApplication;
import be.cegeka.orders.order.domain.customers.Customer;
import org.assertj.core.api.Assertions;
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
import java.time.LocalDate;

/**
 * Created by xanv on 24/02/2017.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = OrderApplication.class)
@Transactional
public class OrderRepositoryTest {
    @PersistenceContext
    private EntityManager entityManager;

    @Inject
    private OrderRepository orderRepository;
    private Order order1, order2;


    @Before
    public void setupDatabase() {
        Customer seppe = new Customer("Seppe", "Gielen");
        Customer johan = new Customer("Johan", "Vdw");
        entityManager.persist(seppe);
        entityManager.persist(johan);

        order1 = new Order(LocalDate.of(1992, 7, 17), seppe);
        order2 = new Order(LocalDate.of(1992, 8, 17), johan);

        entityManager.persist(order1);
        entityManager.persist(order2);
    }


    @Test
    public void addOrder() throws Exception {
        Customer paulien = new Customer("Paulien", "Lemay");
        entityManager.persist(paulien);
        Order order3 = new Order(LocalDate.of(1992,12,04), paulien);
        orderRepository.addOrder(order3);
        Assertions.assertThat(orderRepository.getOrders()).contains(order1, order2, order3);
    }

    @Test
    public void getStock() throws Exception {

    }

    @After
    public void cleanDatabase() {
        entityManager.clear();
    }

}