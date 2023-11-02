package oks.ro.marketapi.web.webInterfaces;

import oks.ro.marketapi.exceptions.CommandLineNotFoundException;
import oks.ro.marketapi.exceptions.CommandNotFoundException;
import oks.ro.marketapi.exceptions.ProductNotFoundException;
import oks.ro.marketapi.model.CommandLine;
import oks.ro.marketapi.web.webInterfaces.utils.Constants;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
public interface CommandLineApi {
    String URL = "/commandLine";
    String ID = "/{commandLineId}";

    @GetMapping(Constants.BASE_URL + URL + "/commandList")
    List<CommandLine> getCommandLines(@RequestParam Long commandId) throws CommandNotFoundException;

    @GetMapping(Constants.BASE_URL + URL + "/add")
    CommandLine addCommandLine(@RequestParam(name = "productId") Long productId,
                                  @RequestParam(name = "commandId") Long commandId,
                                  @RequestParam(name = "quantity") Double quantity) throws ProductNotFoundException, CommandNotFoundException;

    @PutMapping(Constants.BASE_URL + URL + ID + "/update")
    CommandLine updateCommandLine(@PathVariable Long commandLineId,
                                     @RequestBody CommandLine commandLine) throws CommandLineNotFoundException;

    @DeleteMapping(Constants.BASE_URL + URL + ID + "/delete")
    void deleteCommandLine(@PathVariable Long commandLineId) throws CommandLineNotFoundException;
}
