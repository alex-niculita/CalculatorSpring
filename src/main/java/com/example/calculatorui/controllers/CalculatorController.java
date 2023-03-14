package com.example.calculatorui.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.example.calculatorui.model.Unit;
import com.example.calculatorui.model.Units;
import com.example.calculatorui.utils.AttributeNames;
import com.example.calculatorui.utils.PageMappings;

@Controller
@RequestMapping(PageMappings.CALCULATOR_MAIN)
public class CalculatorController {

    private final Units units;

    public CalculatorController(Units units) {
        this.units = units;
    }

    @GetMapping
    public String getGreeting(Model model) {
        model.addAttribute(AttributeNames.CALCULATOR_RESULT,units.getMessage());
        model.addAttribute("units", units.getAll());
        return PageMappings.CALCULATOR_MAIN;
    }

    @PostMapping
    public String calculateResult(@RequestParam String number1, @RequestParam String number2, @RequestParam String operation, Model model) {
        Unit unit = units.addUnit(number1,operation,number2);
        units.setMessage(unit.getMessage());
        return PageMappings.CALCULATOR_POST_REDIRECT;
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") int id ) {
        units.delete(id);
        return PageMappings.CALCULATOR_POST_REDIRECT;
    }

}
