package be.cegeka.orders.order.domain.stock;

import be.cegeka.orders.order.domain.items.Item;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by xanv on 23/02/2017.
 */
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
    public void getAll_ShouldReturnAll(){
        Assertions.assertThat(stockRepository.getStock()).isEqualTo(stockList);
    }

    @Test
    public void addCustomerShoudAddCustomer(){
        StockEntry stock= new StockEntry(new Item("Iets", "dit doet iets", 1235));
        stockRepository.addEntry(stock);
        Assertions.assertThat(stockRepository.getAll()).contains(stock1, stock2, stock);
    }

}