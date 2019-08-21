package interview.dto.mapper;

import interview.dto.CustomerDto;
import interview.entity.Customer;
import org.springframework.stereotype.Component;

@Component
public class CustomerDtoMapper {

    public Customer getCustomer(CustomerDto customerDto) {
        Customer customer = new Customer();
        customer.setId(customerDto.getId());
        customer.setEmail(customerDto.getEmail());
        customer.setPassword(customerDto.getPassword());
        customer.setFirstName(customerDto.getFirstName());
        customer.setLastName(customerDto.getLastName());
        customer.setCertified(customerDto.isCertified());
        return customer;
    }

    public CustomerDto getCustomerDto(Customer customer) {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setId(customer.getId());
        customerDto.setEmail(customer.getEmail());
        customerDto.setFirstName(customer.getFirstName());
        customerDto.setLastName(customer.getLastName());
        customerDto.setCertified(customer.isCertified());
        return customerDto;
    }


}
