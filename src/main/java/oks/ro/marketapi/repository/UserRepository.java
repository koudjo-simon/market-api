package oks.ro.marketapi.repository;

import oks.ro.marketapi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
