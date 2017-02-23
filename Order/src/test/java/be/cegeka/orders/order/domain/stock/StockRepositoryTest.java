package be.cegeka.orders.order.domain.stock;

import be.cegeka.orders.order.OrderApplication;
import be.cegeka.orders.order.domain.items.Item;
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
        stock1 = new StockEntry(new Item("Iets", "dit doet iets", 1235));
        stock2 = new StockEntry(new Item("Iets anders", "dit doet iets anders", 12356));
        entityManager.persist(stock1);
        entityManager.persist(stock2);
    }

    @Test
    public void getStock_ShouldReturnStock(){
        Assertions.assertThat(stockRepository.getStock()).contains(stock1, stock2);
    }

//    @Test
//    public void addCustomerShouldAddCustomer(){
//        StockEntry stock= new StockEntry(new Item("Iets", "dit doet iets", 1235));
//        stockRepository.addEntry(stock);
//        Assertions.assertThat(stockRepository.getAll()).contains(stock1, stock2, stock);
//    }

}
