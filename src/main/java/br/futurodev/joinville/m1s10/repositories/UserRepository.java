package br.futurodev.joinville.m1s10.repositories;

import br.futurodev.joinville.m1s10.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
