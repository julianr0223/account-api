package com.julianr0223.devsu.infrastructure.repository_imp.jpa;

import com.julianr0223.devsu.infrastructure.entity.Cuenta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CuentaRepositoryJPA extends JpaRepository<Cuenta, Long> {
}
