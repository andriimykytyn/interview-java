package interview.controller;

import interview.dto.CheckDto;
import interview.dto.OrderDto;
import interview.dto.mapper.CustomerDtoMapper;
import interview.entity.Customer;
import interview.service.CheckService;
import interview.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/orders")
public class OrderController {

    private CheckService checkService;
    private CustomerService customerService;
    private CustomerDtoMapper mapper;

    @Autowired
    public OrderController(CheckService checkService, CustomerService customerService,
                           CustomerDtoMapper mapper) {
        this.checkService = checkService;
        this.customerService = customerService;
        this.mapper = mapper;
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/check")
    public CheckDto createCheck(@Validated  @RequestBody OrderDto orderDto, Authentication authentication) {
        Customer customer = mapper.getCustomer(customerService.findByEmail(authentication.getName()));
        return checkService.check(orderDto, customer);
    }
}
