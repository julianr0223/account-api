package com.julianr0223.devsu.infrastructure.repository_imp.jpa;

import com.julianr0223.devsu.infrastructure.entity.Movimiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovimientoRepositoryJPA extends JpaRepository<Movimiento, Long> {

}
