package interview.service.impl;

import interview.dao.CustomerDao;
import interview.dto.CustomerDto;
import interview.dto.mapper.CustomerDtoMapper;
import interview.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

    private CustomerDao customerDao;
    private CustomerDtoMapper mapper;

    @Autowired
    public CustomerServiceImpl(CustomerDao customerDao, CustomerDtoMapper mapper) {
        this.customerDao = customerDao;
        this.mapper = mapper;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return customerDao.findByEmail(email);
    }

    @Override
    public CustomerDto findByEmail(String email) {
        return mapper.getCustomerDto(customerDao.findByEmail(email));
    }

    @Override
    public CustomerDto register(CustomerDto customerDto) {
        return mapper.getCustomerDto(customerDao.create(mapper.getCustomer(customerDto)));
    }
}
