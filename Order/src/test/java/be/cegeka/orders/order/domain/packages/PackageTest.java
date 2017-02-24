package be.cegeka.orders.order.domain.packages;

import be.cegeka.orders.order.OrderApplication;
import be.cegeka.orders.order.domain.items.Item;
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

    private Item item1;

    @Before
    public void setUp() throws Exception {
        item1 = new Item("Smurfjes","Deze lekkere snoepjes zijn lekker?",4.5);
        entityManager.persist(item1);
    }

    @Test
    public void Shipment_can_persist() throws Exception {
        Package testPackage = new Package(item1, LocalDate.now());
        entityManager.persist(testPackage);
    }
}