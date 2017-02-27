package be.cegeka.orders.order.domain.stock;

import be.cegeka.orders.order.domain.items.Item;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
public class StockService {
    @Inject
    private StockRepository stockRepository;

    public List<StockEntry> getStock() {
        return stockRepository.getStock();
    }

    public void addEntry(Item item){
        stockRepository.addEntry(new StockEntry(item));
    }
}
