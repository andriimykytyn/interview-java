package interview.dao;

import interview.entity.Customer;

public interface CustomerDao {

    Customer findByEmail(String email);

    Customer create(Customer customer);

}
