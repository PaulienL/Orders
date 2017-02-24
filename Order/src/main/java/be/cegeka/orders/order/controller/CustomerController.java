package be.cegeka.orders.order.controller;

import be.cegeka.orders.order.domain.customers.CustomerService;
import be.cegeka.orders.order.domain.orders.Order;
import be.cegeka.orders.order.domain.orders.OrderService;
import be.cegeka.orders.order.domain.stock.StockEntry;
import be.cegeka.orders.order.domain.stock.StockService;
import jdk.nashorn.internal.runtime.PropertyDescriptor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import javax.transaction.Transactional;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * Created by christom on 23/02/2017.
 */
@Controller
@RequestMapping("/customer")
@Transactional
public class CustomerController {

    @Inject
    private CustomerService customerService;

    @Inject
    private OrderService orderService;

    @Inject
    private StockService stockService;

    @RequestMapping(method = POST)
    @ResponseBody
    public void addCustomer(@RequestParam(value = "firstname") String firstName,
                            @RequestParam(value = "lastname") String lastName) {
        customerService.addCustomer(firstName, lastName);
    }

    @RequestMapping(path="/order", method=POST)
    @ResponseBody
    public void addOrder(@RequestBody Order order){
        orderService.addOrder(order);
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<StockEntry> getStock(){
        return stockService.getStock();
    }
}
