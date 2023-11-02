package oks.ro.marketapi.web.webInterfaces;

import oks.ro.marketapi.exceptions.CustomerNotFoundException;
import oks.ro.marketapi.model.Customer;
import oks.ro.marketapi.web.webInterfaces.utils.Constants;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
public interface CustomerApi {
    String URL = "/customer";
    String ID = "/{customerId}";

    @GetMapping(Constants.BASE_URL + URL + "/list")
    List<Customer> getCustomers();

    @GetMapping(Constants.BASE_URL + URL + ID)
    Customer getCustomer(@PathVariable Long customerId) throws CustomerNotFoundException;

    @PostMapping(Constants.BASE_URL + URL + "/add")
    Customer addCustomer(@RequestBody Customer customer);

    @PutMapping(Constants.BASE_URL + URL + ID + "/update")
    Customer updateCustomer(@PathVariable Long customerId,
                               @RequestBody Customer customer) throws CustomerNotFoundException;

    @DeleteMapping(Constants.BASE_URL + URL + ID + "/delete")
    void deleteCustomer(@PathVariable Long customerId) throws CustomerNotFoundException;
}
