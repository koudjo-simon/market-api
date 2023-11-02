package oks.ro.marketapi.web.webInterfaces;

import oks.ro.marketapi.exceptions.CommandNotFoundException;
import oks.ro.marketapi.exceptions.CustomerNotFoundException;
import oks.ro.marketapi.model.Command;
import oks.ro.marketapi.web.webInterfaces.utils.Constants;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
public interface CommandApi {
    String URL = "/command";
    String ID = "/{commandId}";

    @GetMapping(Constants.BASE_URL + URL + "/list")
    List<Command> getCommands();

    @GetMapping(Constants.BASE_URL + URL + ID)
    Command getCommand(@PathVariable Long commandId) throws CommandNotFoundException;

    @PostMapping(Constants.BASE_URL + URL + "/add")
    Command addCommand(@RequestParam Long customerId) throws CustomerNotFoundException;

    @PutMapping(Constants.BASE_URL + URL + ID + "/update")
    Command updateCommand(@PathVariable Long commandId, @RequestBody Command command) throws CommandNotFoundException;

    @DeleteMapping(Constants.BASE_URL + URL + ID + "/delete")
    void deleteCategoryById(@PathVariable Long commandId) throws CommandNotFoundException;
}
