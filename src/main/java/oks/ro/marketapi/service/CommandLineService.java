package oks.ro.marketapi.service;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import oks.ro.marketapi.exceptions.CommandLineNotFoundException;
import oks.ro.marketapi.exceptions.CommandNotFoundException;
import oks.ro.marketapi.exceptions.ProductNotFoundException;
import oks.ro.marketapi.model.Command;
import oks.ro.marketapi.model.CommandLine;
import oks.ro.marketapi.model.Product;
import oks.ro.marketapi.repository.CommandLineRepository;
import oks.ro.marketapi.service.serviceInterfaces.CommandLineServiceInterface;
import oks.ro.marketapi.service.service_utils.VerifyEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@Slf4j
public class CommandLineService implements CommandLineServiceInterface {

    private final CommandLineRepository commandLineRepository;
    private final VerifyEntity verifyEntity;

    public CommandLineService(CommandLineRepository commandLineRepository,
                              VerifyEntity verifyEntity) {
        this.commandLineRepository = commandLineRepository;
        this.verifyEntity = verifyEntity;
    }

    @Override
    public List<CommandLine> findCommandLines() {
        return commandLineRepository.findAll();
    }

    @Override
    public CommandLine findCommandLineById(Long commandLineId) throws CommandLineNotFoundException {
        return verifyEntity.verifyCommandLine(commandLineId);
    }

    @Override
    public CommandLine addCommandLine(Long productId, Long commandId, Double quantity) throws ProductNotFoundException, CommandNotFoundException {
        log.info("Adding command Line for command " + commandId);
        Product verifiedProduct = verifyEntity.verifyProduct(productId);
        Command verifiedCommand = verifyEntity.verifyCommand(commandId);
        Double unitPrice = verifiedProduct.getPrice();
        Double totalCommandLinePrice = unitPrice * quantity;
        CommandLine commandLine = new CommandLine();
        commandLine.setCommand(verifiedCommand);
        commandLine.setProduct(verifiedProduct);
        commandLine.setUnitPrice(unitPrice);
        commandLine.setQuantity(quantity);
        commandLine.setTotalCommandLinePrice(totalCommandLinePrice);
        return commandLineRepository.save(commandLine);

    }


    @Override
    public CommandLine updateCommandLine(Long commandLineId, CommandLine CommandLine) throws CommandLineNotFoundException {
        log.info("Updating command Line with id = " + commandLineId);
        CommandLine commandLine = verifyEntity.verifyCommandLine(commandLineId);
        commandLine.setCommandLineId(commandLineId);
        return commandLineRepository.save(commandLine);
    }

    @Override
    public void deleteCommandLine(Long commandLineId) throws CommandLineNotFoundException {
        log.info("Deleting command Line with id = " + commandLineId);
        verifyEntity.verifyCommandLine(commandLineId);
        commandLineRepository.deleteById(commandLineId);
    }

    @Override
    public List<CommandLine> getCommandLines(Long commandId) throws CommandNotFoundException {
        log.info("Get command Line with id = "+commandId+" lines");
        verifyEntity.verifyCommand(commandId);
        return commandLineRepository.findByCommandCommandId(commandId);
    }
}
