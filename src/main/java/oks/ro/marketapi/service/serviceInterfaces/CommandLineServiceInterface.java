package oks.ro.marketapi.service.serviceInterfaces;

import oks.ro.marketapi.exceptions.CommandLineNotFoundException;
import oks.ro.marketapi.exceptions.CommandNotFoundException;
import oks.ro.marketapi.exceptions.ProductNotFoundException;
import oks.ro.marketapi.model.Category;
import oks.ro.marketapi.model.CommandLine;

import java.util.List;
import java.util.Optional;

public interface CommandLineServiceInterface {
    List<CommandLine> findCommandLines();
    CommandLine findCommandLineById(Long commandLineId) throws CommandLineNotFoundException;

    CommandLine addCommandLine(Long productId, Long commandId, Double quantity) throws ProductNotFoundException, CommandNotFoundException;

    CommandLine updateCommandLine(Long commandLineId, CommandLine CommandLine) throws CommandLineNotFoundException;
    void deleteCommandLine(Long commandLineId) throws CommandLineNotFoundException;

    List<CommandLine> getCommandLines(Long commandId) throws CommandNotFoundException;
}
