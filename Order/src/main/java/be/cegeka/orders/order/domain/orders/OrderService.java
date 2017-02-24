package be.cegeka.orders.order.domain.orders;

import be.cegeka.orders.order.domain.stock.StockEntry;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

/**
 * Created by xanv on 24/02/2017.
 */
@Named
public class OrderService {
    @Inject
    private OrderRepository orderRepository;
    public void addOrder(Order order) {
        orderRepository.addOrder(order);
    }

    public List<Order> getOrders() {
        return orderRepository.getOrders();
    }
}
