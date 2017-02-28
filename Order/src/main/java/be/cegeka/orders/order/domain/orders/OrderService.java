package be.cegeka.orders.order.domain.orders;

import be.cegeka.orders.order.domain.packages.Package;

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

    public List<Order> getOrdersByCustomer(int id) {
        return orderRepository.getOrdersByCustomer(id);
    }

    public void addPackage(Package aPackage, Order order){
//        Order order = orderRepository.getOrderByID(order_id);
        System.out.println("adding");
        order.addPackage(aPackage);
        System.out.println("merging");
        orderRepository.updateOrder(order);
    }

}
