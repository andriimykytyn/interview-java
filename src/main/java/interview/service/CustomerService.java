package interview.service;

import interview.dto.CustomerDto;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface CustomerService extends UserDetailsService {

    CustomerDto findByEmail(String email);

    CustomerDto register(CustomerDto customerDto);

}
