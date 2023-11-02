package oks.ro.marketapi.repository;

import oks.ro.marketapi.model.Command;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommandRepository extends JpaRepository<Command, Long> {

}
