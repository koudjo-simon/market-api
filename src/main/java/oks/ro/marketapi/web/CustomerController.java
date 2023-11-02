package oks.ro.marketapi.web;

import oks.ro.marketapi.exceptions.CustomerNotFoundException;
import oks.ro.marketapi.model.Customer;
import oks.ro.marketapi.service.serviceInterfaces.CustomerServiceInterface;
import oks.ro.marketapi.web.webInterfaces.CustomerApi;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerController implements CustomerApi {

    private final CustomerServiceInterface customerServiceInterface;

    public CustomerController(CustomerServiceInterface customerServiceInterface) {
        this.customerServiceInterface = customerServiceInterface;
    }

    @Override
    public List<Customer> getCustomers() {
        return customerServiceInterface.findCustomers();
    }

    @Override
    public Customer getCustomer(Long customerId) throws CustomerNotFoundException {
        return customerServiceInterface.findCustomerById(customerId);
    }

    @Override
    public Customer addCustomer(Customer customer) {
        return customerServiceInterface.addCustomer(customer);
    }

    @Override
    public Customer updateCustomer(Long customerId, Customer customer) throws CustomerNotFoundException {
        return customerServiceInterface.updateCustomer(customerId, customer);
    }

    @Override
    public void deleteCustomer(Long customerId) throws CustomerNotFoundException {
        customerServiceInterface.deleteCustomer(customerId);
    }
}
