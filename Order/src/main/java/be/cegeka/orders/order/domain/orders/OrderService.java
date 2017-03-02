package be.cegeka.orders.order.domain.orders;

import be.cegeka.orders.order.domain.items.Item;
import be.cegeka.orders.order.domain.packages.Package;

import javax.inject.Inject;
import javax.inject.Named;
import java.time.LocalDate;
import java.util.List;
import java.util.jar.Pack200;

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

    public List<Order> getOrdersByCustomer(int id) {
        return orderRepository.getOrdersByCustomer(id);
    }

    public void addPackage(Item item, LocalDate shipping_date, int order_id){
        Order order = orderRepository.getOrderByID(order_id);
        System.out.println("adding");
        order.addPackage(new Package(item , shipping_date, order) );
        System.out.println("merging");
        orderRepository.updateOrder(order);
    }

}
