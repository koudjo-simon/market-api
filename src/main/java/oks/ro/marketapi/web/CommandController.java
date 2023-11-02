package oks.ro.marketapi.web;

import oks.ro.marketapi.exceptions.CommandNotFoundException;
import oks.ro.marketapi.exceptions.CustomerNotFoundException;
import oks.ro.marketapi.model.Command;
import oks.ro.marketapi.service.serviceInterfaces.CommandServiceInterface;
import oks.ro.marketapi.web.webInterfaces.CommandApi;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CommandController implements CommandApi {

    private final CommandServiceInterface commandServiceInterface;

    public CommandController(CommandServiceInterface commandServiceInterface) {
        this.commandServiceInterface = commandServiceInterface;
    }

    @Override
    public List<Command> getCommands() {
        return commandServiceInterface.findCommands();
    }

    @Override
    public Command getCommand(Long commandId) throws CommandNotFoundException {
        return commandServiceInterface.findCommandById(commandId);
    }

    @Override
    public Command addCommand(Long customerId) throws CustomerNotFoundException {
        return commandServiceInterface.addCommand(customerId);
    }

    @Override
    public Command updateCommand(Long commandId, Command command) throws CommandNotFoundException {
        return commandServiceInterface.updateCommand(commandId, command);
    }

    @Override
    public void deleteCategoryById(Long commandId) throws CommandNotFoundException {
        commandServiceInterface.deleteCommand(commandId);
    }
}
