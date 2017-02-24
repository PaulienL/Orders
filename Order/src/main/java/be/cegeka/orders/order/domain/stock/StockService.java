package be.cegeka.orders.order.domain.stock;

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

    public void addEntry(StockEntry stockEntry){
        stockRepository.addEntry(stockEntry);
    }
}
