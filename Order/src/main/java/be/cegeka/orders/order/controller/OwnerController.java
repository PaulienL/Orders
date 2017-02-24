package be.cegeka.orders.order.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.transaction.Transactional;

/**
 * Created by paulienl on 23/02/2017.
 */
@Controller
@RequestMapping("/customer")
@Transactional
public class OwnerController {
    
}
