package interview.controller;

import interview.dto.CustomerDto;
import interview.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/customers")
public class CustomerController {

    private CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/current-customer")
    public CustomerDto getCurrent(Authentication authentication) {
        return customerService.findByEmail(authentication.getName());
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/")
    public CustomerDto getByEmail(@RequestParam("email") String email) {
        return customerService.findByEmail(email);
    }
}
