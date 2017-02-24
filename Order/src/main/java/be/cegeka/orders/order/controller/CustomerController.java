package be.cegeka.orders.order.controller;

import be.cegeka.orders.order.domain.customers.CustomerService;
import be.cegeka.orders.order.domain.orders.Order;
import be.cegeka.orders.order.domain.orders.OrderService;
import be.cegeka.orders.order.domain.stock.StockEntry;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.*;

/**
 * Created by christom on 23/02/2017.
 */
@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Inject
    private CustomerService customerService;

    @Inject
    private OrderService orderService;

    @RequestMapping(method = POST)
    public
    @ResponseBody
    void addCustomer (@RequestParam (value = "firstname") String firstName,
                      @RequestParam (value="lastname") String lastName){
        customerService.addCustomer(firstName, lastName);
    }

    @RequestMapping(path="/order", method=POST)
    @ResponseBody
    public void addOrder(@RequestBody Order order){
        orderService.addOrder(order);
    }

    @RequestMapping(method = GET)
    @ResponseBody
    public List<StockEntry> getStock(){
        return orderService.getStock();
    }
}
