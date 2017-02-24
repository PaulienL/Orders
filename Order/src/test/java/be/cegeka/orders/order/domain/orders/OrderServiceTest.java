package be.cegeka.orders.order.domain.orders;

import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;

/**
 * Created by xanv on 24/02/2017.
 */
public class OrderServiceTest {
    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @InjectMocks
    private OrderService orderService;

    @Mock
    private OrderRepository orderRepository;

    @Mock
    private Order order;

    @Test
    public void addOrder() throws Exception {
        orderService.addOrder(order);
        verify(orderRepository).addOrder(order);
    }

    @Test
    public void getOrder() throws Exception {
        orderService.getOrders();
        verify(orderRepository).getOrders();
    }

}