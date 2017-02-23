package be.cegeka.orders.order.domain.stock;

import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by xanv on 23/02/2017.
 */
public class StockRepositoryTest {
    private StockEntry stock1;
    private StockEntry stock2;
    private List<StockEntry> itemList;

    @PersistenceContext
    private EntityManager entityManager;

    @Before
    public void setUp(){
        stock1 = new StockEntry(new Item("Iets", "dit doet iets", 1235));
        stock2 = new StockEntry(new Item("Iets anders", "dit doet iets anders", 12356));
    }

    @Test
    public void

}