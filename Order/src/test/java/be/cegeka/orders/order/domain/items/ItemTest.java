package be.cegeka.orders.order.domain.items;

import be.cegeka.orders.order.OrderApplication;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = OrderApplication.class)
@Transactional
public class ItemTest {
    @PersistenceContext
    private EntityManager entityManager;

    @Test
    public void saveTest() {
        Item item = new Item("candy smurfssss", "yummie yummie", 0.5);
        entityManager.persist(item);
        Assertions.assertThat(entityManager.createQuery("select i from Item i" , Item.class).getResultList()).contains(item);
    }
}