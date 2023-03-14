package com.example.calculatorui.model;

import java.util.List;

public interface Units {
    List<Unit> getAll();
    Unit addUnit(String number1, String number2, String operation);
    void delete(int id);

    String getMessage();

    void setMessage(String message);

}
