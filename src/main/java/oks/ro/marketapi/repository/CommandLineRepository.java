package oks.ro.marketapi.repository;

import oks.ro.marketapi.model.Command;
import oks.ro.marketapi.model.CommandLine;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommandLineRepository extends JpaRepository<CommandLine, Long> {
    List<CommandLine> findByCommandCommandId(Long commandId);
}
