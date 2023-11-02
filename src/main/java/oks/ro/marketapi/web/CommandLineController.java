package oks.ro.marketapi.web;

import oks.ro.marketapi.exceptions.CommandLineNotFoundException;
import oks.ro.marketapi.exceptions.CommandNotFoundException;
import oks.ro.marketapi.exceptions.ProductNotFoundException;
import oks.ro.marketapi.model.CommandLine;
import oks.ro.marketapi.service.CommandLineService;
import oks.ro.marketapi.web.webInterfaces.CommandLineApi;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CommandLineController implements CommandLineApi {

    private final CommandLineService commandLineService;

    public CommandLineController(CommandLineService commandLineService) {
        this.commandLineService = commandLineService;
    }

    @Override
    public List<CommandLine> getCommandLines(Long commandId) throws CommandNotFoundException {
        return commandLineService.getCommandLines(commandId);
    }

    @Override
    public CommandLine addCommandLine(Long productId, Long commandId, Double quantity) throws ProductNotFoundException, CommandNotFoundException {
        return commandLineService.addCommandLine(productId, commandId, quantity);
    }

    @Override
    public CommandLine updateCommandLine(Long commandLineId, CommandLine commandLine) throws CommandLineNotFoundException {
        return commandLineService.updateCommandLine(commandLineId, commandLine);
    }

    @Override
    public void deleteCommandLine(Long commandLineId) throws CommandLineNotFoundException {
        commandLineService.deleteCommandLine(commandLineId);
    }
}
