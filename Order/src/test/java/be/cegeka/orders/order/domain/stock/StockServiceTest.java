package be.cegeka.orders.order.domain.stock;

import be.cegeka.orders.order.domain.items.Item;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

/**
 * Created by xanv on 24/02/2017.
 */
public class StockServiceTest {
    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @InjectMocks
    private StockService stockService;

    @Mock
    private StockRepository stockRepository;

    @Mock
    private Item item;

    @Test
    public void getStock() throws Exception {
        stockService.getStock();
        verify(stockRepository).getStock();
    }

    @Test
    public void addEntry() throws Exception {
        stockService.addEntry(item);
        verify(stockRepository).addEntry(any(StockEntry.class));
    }

}