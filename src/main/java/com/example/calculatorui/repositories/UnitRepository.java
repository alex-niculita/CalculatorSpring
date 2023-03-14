package com.example.calculatorui.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.calculatorui.model.Unit;

public interface UnitRepository extends JpaRepository<Unit, Integer> {
}
