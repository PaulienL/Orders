package be.cegeka.orders.order.domain.orders;

import be.cegeka.orders.order.OrderApplication;
import be.cegeka.orders.order.domain.customers.Customer;
import be.cegeka.orders.order.domain.stock.StockEntry;
import org.assertj.core.api.Assertions;
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

import java.util.List;

import static org.junit.Assert.*;

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
        order1 = new Order();
        order2 = new Order();

        entityManager.persist(order1);
        entityManager.persist(order2);
    }


    @Test
    public void addOrder() throws Exception {
        Order order3 = new Order();
        orderRepository.addOrder(order3);
        Assertions.assertThat(orderRepository.getOrders()).contains(order1, order2, order3);
    }

    @Test
    public void getStock() throws Exception {

    }

}