package oks.ro.marketapi.service;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import oks.ro.marketapi.exceptions.CommandNotFoundException;
import oks.ro.marketapi.exceptions.CustomerNotFoundException;
import oks.ro.marketapi.model.Command;
import oks.ro.marketapi.model.Customer;
import oks.ro.marketapi.model.model_utils.CommandStatus;
import oks.ro.marketapi.repository.CommandRepository;
import oks.ro.marketapi.service.serviceInterfaces.CommandServiceInterface;
import oks.ro.marketapi.service.service_utils.VerifyEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@Transactional
@Slf4j
public class CommandService implements CommandServiceInterface {

    private final CommandRepository commandRepository;
    private final VerifyEntity verifyEntity;

    public CommandService(CommandRepository commandRepository, VerifyEntity verifyEntity) {
        this.commandRepository = commandRepository;
        this.verifyEntity = verifyEntity;
    }

    @Override
    public List<Command> findCommands() {
        return commandRepository.findAll();
    }

    @Override
    public Command findCommandById(Long commandId) throws CommandNotFoundException {
        log.info("Getting command with id = "+commandId);
        return verifyEntity.verifyCommand(commandId);
    }

    @Override
    public Command addCommand(Long customerId) throws CustomerNotFoundException {
        log.info("Adding Command ...");
        Customer customer = verifyEntity.verifyCustomer(customerId);
        Command command = new Command();
        Date date = new Date();
        command.setCommandDate(date);
        command.setCustomer(customer);
        command.setCommandStatus(CommandStatus.CREATED);
        command.setTotalCommandPrice((double) 0);
        command.setLastModifiedDate(date);
        return commandRepository.save(command);
    }

    @Override
    public Command updateCommand(Long commandId, Command command) throws CommandNotFoundException {
        log.info("Updating command with id = "+commandId);
        verifyEntity.verifyCommand(commandId);
        command.setCommandId(commandId);
        return commandRepository.save(command);
    }

    @Override
    public void deleteCommand(Long commandId) throws CommandNotFoundException {
        verifyEntity.verifyCommand(commandId);
        commandRepository.deleteById(commandId);
    }
}
