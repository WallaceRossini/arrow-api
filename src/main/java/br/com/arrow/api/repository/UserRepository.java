package br.com.arrow.api.repository;

import br.com.arrow.api.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
