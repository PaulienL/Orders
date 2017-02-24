package be.cegeka.orders.order.domain.stock;

import be.cegeka.orders.order.OrderApplication;
import be.cegeka.orders.order.domain.items.Item;
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
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = OrderApplication.class)
@Transactional
public class StockRepositoryTest {
    private StockEntry stock1;
    private StockEntry stock2;

    @PersistenceContext
    private EntityManager entityManager;

    @Inject
    private StockRepository stockRepository;

    @Before
    public void setUp(){
        Item item1 = new Item("Iets", "dit doet iets", 1235);
        Item item2= new Item("Iets anders", "dit doet iets anders", 12356);
        entityManager.persist(item1);
        entityManager.persist(item2);
        stock1 = new StockEntry(item1);
        stock2 = new StockEntry(item2);
        entityManager.persist(stock1);
        entityManager.persist(stock2);
    }

    @Test
    public void getStock_ShouldReturnStock(){
        Assertions.assertThat(stockRepository.getStock()).contains(stock1, stock2);
    }

    @Test
    public void addStockEntryShouldAddEntry(){
        Item item3=new Item("pinkfluffyunicorn", "it's so fluffy", 99999.00);
        entityManager.persist(item3);
        StockEntry stock= new StockEntry(item3);
        stockRepository.addEntry(stock);
        Assertions.assertThat(stockRepository.getStock()).contains(stock1, stock2, stock);
    }
    @After
    public void cleanDatabase() {
        entityManager.clear();
    }

}
