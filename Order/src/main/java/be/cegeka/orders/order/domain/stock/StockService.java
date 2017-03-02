package be.cegeka.orders.order.domain.stock;

import be.cegeka.orders.order.domain.items.Item;
import be.cegeka.orders.order.domain.packages.Package;

import javax.inject.Inject;
import javax.inject.Named;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Named
public class StockService {
    @Inject
    private StockRepository stockRepository;

    public List<ItemQuantityCombo> getStock() {
        return stockRepository.getQuantityOnStock();
    }

    public void addEntry(Item item){
        stockRepository.addEntry(new StockEntry(item));
    }

    public List<ItemQuantityCombo> quantityOnStock(){
        return stockRepository.getQuantityOnStock();
    }

    public boolean itemIsOnStock(Item item){
        for(ItemQuantityCombo itemQuantityCombo: stockRepository.getQuantityOnStock()){
            if (itemQuantityCombo.getItem().equals(item)){
                return !(itemQuantityCombo.getQuantity()==0);
            }
        }
        return true;
    }

//    public List<Package> itemsShippedTomorrow(List<Item> items){
//        List<Package> shippedTomorrow=new ArrayList<>();
//        for(Item item : items){
//            if(itemIsOnStock(item)){
//                shippedTomorrow.add(new Package(item, LocalDate.now().plusDays(1l)));
//            }
//        }
//        return shippedTomorrow;
//    }

//    public List<Package> itemsShippedNextWeek(List<Item> items){
//        List<Package> shippedNextWeek=new ArrayList<>();
//        for(Item item : items){
//            if(!itemIsOnStock(item)){
//                shippedNextWeek.add(new Package(item, LocalDate.now().plusDays(1l)));
//            }
//        }
//        return shippedNextWeek;
//    }
}
