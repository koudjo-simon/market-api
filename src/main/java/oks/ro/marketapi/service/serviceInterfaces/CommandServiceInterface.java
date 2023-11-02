package oks.ro.marketapi.service.serviceInterfaces;

import oks.ro.marketapi.exceptions.CommandNotFoundException;
import oks.ro.marketapi.exceptions.CustomerNotFoundException;
import oks.ro.marketapi.model.Command;

import java.util.List;

public interface CommandServiceInterface {
    List<Command> findCommands();
    Command findCommandById(Long commandId) throws CommandNotFoundException;

    Command addCommand(Long customerId) throws CustomerNotFoundException;
    Command updateCommand(Long commandId, Command Command) throws CommandNotFoundException;
    void deleteCommand(Long commandId) throws CommandNotFoundException;
}
