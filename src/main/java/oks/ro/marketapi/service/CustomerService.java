package oks.ro.marketapi.service;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import oks.ro.marketapi.exceptions.CustomerNotFoundException;
import oks.ro.marketapi.model.Customer;
import oks.ro.marketapi.repository.CustomerRepository;
import oks.ro.marketapi.service.serviceInterfaces.CustomerServiceInterface;
import oks.ro.marketapi.service.service_utils.VerifyEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@Slf4j
public class CustomerService implements CustomerServiceInterface {

    private final CustomerRepository customerRepository;
    private final VerifyEntity verifyEntity;

    public CustomerService(CustomerRepository customerRepository, VerifyEntity verifyEntity) {
        this.customerRepository = customerRepository;
        this.verifyEntity = verifyEntity;
    }

    @Override
    public List<Customer> findCustomers() {
        log.info("Get all customers");
        return customerRepository.findAll();
    }

    @Override
    public Customer findCustomerById(Long customerId) throws CustomerNotFoundException {
        log.info("Get customer with id = "+customerId);
        return verifyEntity.verifyCustomer(customerId);
    }

    @Override
    public Customer addCustomer(Customer customer) {
        log.info("Adding Customer ...");
        return customerRepository.save(customer);
    }

    @Override
    public Customer updateCustomer(Long customerId, Customer customer) throws CustomerNotFoundException {
        log.info("Updating Customer with id = "+customerId);
        Customer verifyCustomer = verifyEntity.verifyCustomer(customerId);
        customer.setCustomerId(customerId);
        return customerRepository.save(customer);
    }

    @Override
    public void deleteCustomer(Long customerId) throws CustomerNotFoundException {
        log.info("Deleting Customer with id = "+customerId);
        verifyEntity.verifyCustomer(customerId);
        customerRepository.deleteById(customerId);
    }
}
