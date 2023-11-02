package oks.ro.marketapi.service.serviceInterfaces;

import oks.ro.marketapi.exceptions.CustomerNotFoundException;
import oks.ro.marketapi.model.CommandLine;
import oks.ro.marketapi.model.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerServiceInterface {
    List<Customer> findCustomers();
    Customer findCustomerById(Long customerId) throws CustomerNotFoundException;

    Customer addCustomer(Customer customer);
    Customer updateCustomer(Long customerId, Customer customer) throws CustomerNotFoundException;
    void deleteCustomer(Long customerId) throws CustomerNotFoundException;
}
