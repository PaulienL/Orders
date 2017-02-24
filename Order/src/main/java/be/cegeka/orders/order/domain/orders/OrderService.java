package be.cegeka.orders.order.domain.orders;

import be.cegeka.orders.order.domain.stock.StockEntry;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by xanv on 24/02/2017.
 */
public class OrderService {
    @Inject
    private OrderRepository orderRepository;
    public void addOrder(Order order) {
        orderRepository.addOrder(order);
    }

    public List<StockEntry> getStock() {
        return orderRepository.getStock();
    }
}
