package com.julianr0223.devsu.infrastructure.repository_imp.jpa;

import com.julianr0223.devsu.infrastructure.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepositoryJPA extends JpaRepository<Cliente, Long> {
}
