package com.example.calculatorui.model;

import org.springframework.stereotype.Component;
import com.example.calculatorui.repositories.UnitRepository;

import java.util.List;

@Component
public class UnitsImpl implements Units{
    private String message;
    private final UnitRepository unitRepository;

    public UnitsImpl(UnitRepository unitRepository) {
        this.unitRepository = unitRepository;
    }

    @Override
    public List<Unit> getAll() {
        return unitRepository.findAll();
    }

    @Override
    public Unit addUnit(String number1, String operation, String number2) {
        Unit unit = new Unit(number1,operation,number2);
        unitRepository.save(unit);
        return unit;
    }

    @Override
    public void delete(int id) {
        unitRepository.deleteById(id);
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
