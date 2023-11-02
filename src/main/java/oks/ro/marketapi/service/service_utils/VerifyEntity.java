package oks.ro.marketapi.service.service_utils;

import lombok.extern.slf4j.Slf4j;
import oks.ro.marketapi.exceptions.*;
import oks.ro.marketapi.model.*;
import oks.ro.marketapi.repository.*;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class VerifyEntity {

    private final CategoryRepository categoryRepository;
    private final CommandRepository commandRepository;
    private final CommandLineRepository commandLineRepository;
    private final CustomerRepository customerRepository;
    private final ProductRepository productRepository;
    private final UserRepository userRepository;

    public VerifyEntity(CategoryRepository categoryRepository,
                        CommandRepository commandRepository,
                        CommandLineRepository commandLineRepository,
                        CustomerRepository customerRepository,
                        ProductRepository productRepository,
                        UserRepository userRepository) {
        this.categoryRepository = categoryRepository;
        this.commandRepository = commandRepository;
        this.commandLineRepository = commandLineRepository;
        this.customerRepository = customerRepository;
        this.productRepository = productRepository;
        this.userRepository = userRepository;
    }

    public Category verifyCategory(Long categoryId) throws CategoryNotFoundException {
        log.info("\t*************** Checking Category with id = "+ categoryId);
        return categoryRepository.findById(categoryId)
                .orElseThrow(() -> new CategoryNotFoundException("Category with id = "+categoryId+" not found"));
    }

    public CommandLine verifyCommandLine(Long commandLineId) throws CommandLineNotFoundException {
        log.info("\t*************** Checking CommandLine with id = "+ commandLineId);
        return commandLineRepository.findById(commandLineId)
                .orElseThrow(() -> new CommandLineNotFoundException("CommandLine with id = "+commandLineId+" not found"));
    }

    public Command verifyCommand(Long commandId) throws CommandNotFoundException {
        log.info("\t*************** Checking Command with id = "+ commandId);
        return commandRepository.findById(commandId)
                .orElseThrow(() -> new CommandNotFoundException("Command with id = "+commandId+" not found"));
    }

    public Customer verifyCustomer(Long customerId) throws CustomerNotFoundException {
        log.info("\t*************** Checking Customer with id = "+ customerId);
        return customerRepository.findById(customerId)
                .orElseThrow(() -> new CustomerNotFoundException("Command with id = "+customerId+" not found"));
    }


    public Product verifyProduct(Long productId) throws ProductNotFoundException {
        log.info("\t*************** Checking Product with id = "+ productId);
        return productRepository.findById(productId)
                .orElseThrow(() -> new ProductNotFoundException("Product with id = "+productId+" not found"));
    }

    public User verifyUser(Long userId) throws UserNotFoundException {
        log.info("\t*************** Checking User with id = "+ userId);
        return userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException("Product with id = "+userId+" not found"));
    }

}
