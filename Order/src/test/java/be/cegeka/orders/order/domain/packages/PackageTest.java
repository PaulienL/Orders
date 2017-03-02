package be.cegeka.orders.order.domain.packages;

import be.cegeka.orders.order.OrderApplication;
import be.cegeka.orders.order.domain.customers.Address;
import be.cegeka.orders.order.domain.customers.Customer;
import be.cegeka.orders.order.domain.items.Item;
import be.cegeka.orders.order.domain.orders.Order;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.time.LocalDate;

/**
 * Created by roelg on 24/02/2017.
 */

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = OrderApplication.class)
@Transactional
public class PackageTest {
    @PersistenceContext
    private EntityManager entityManager;

    private Item item1, item2;
    private Order order1;
    Address address1;
    Customer seppe;


    @Before
    public void setUp() throws Exception {

        address1 = new Address("Doelhaagstraat", 60, 2840, "Rumst");
        entityManager.persist(address1);

        seppe = new Customer("Seppe", "Gielen", "seppe.gielen@cegeka.com", address1, "0452889878");
        entityManager.persist(seppe);

        item1 = new Item("Smurfjes","Deze lekkere snoepjes zijn lekker?",4.5);
        entityManager.persist(item1);

        item2 = new Item("HUEHUEH","Deze lekkere snoepjes zijn lekker?",4.5);
        entityManager.persist(item2);
    }

    @Test
    public void Package_can_persist() throws Exception {


        //entityManager.persist(testPackage);

        order1 = new Order(LocalDate.now(),seppe);
        entityManager.persist(order1);

        Package testPackage = new Package(item1, LocalDate.now(), order1);

        order1.addPackage(testPackage);

        entityManager.merge(order1);
       // entityManager.merge(testPackage);

        //entityManager.persist(testPackage);
//
//        for (Package aPackage : order1.getPackages()) {
//            System.out.println(aPackage.toString());
//        }
    }
    @After
    public void cleanDatabase(){
        entityManager.clear();
    }
}