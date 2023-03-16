package com.example.calculatorui.model;

import jakarta.persistence.*;

@Entity
@Table(name = "units")
public class Unit {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;
    @Column(name = "number1")
    private String number1;
    @Column(name = "operation")
    private String operation;
    @Column(name = "number2")
    private String number2;
    @Column(name = "message")
    private String message;

    public Unit(){
    }

    public Unit(String num1, String operation, String num2) {
        this.number1 = num1;
        this.operation = operation;
        this.number2 = num2;
        this.message = calculate();
    }

    public int getId() {
        return id;
    }

    public String getNumber1() {
        return number1;
    }

    public String getOperation() {
        return operation;
    }

    public String getNumber2() {
        return number2;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public String calculate() {

        if ((number1 == null) || (number2 == null) || (operation == null)|| number1.isBlank() || number2.isBlank()) {
            return "Ошибка: не хватает чисел!";
        } else if ((operation.equals("/")) && (number2.equals("0"))) {
            return "Ошибка: делить на ноль нельзя!";
        } else {
            int n1;
            int n2;
            try{
                n1 = Integer.parseInt(number1);
                n2 = Integer.parseInt(number2);
            } catch (Exception e) {
                return "Ошибка: введите числа!";
            }
            double x = (double) n1 / n2;
            return switch (operation){
                case "+" -> String.format("%s %s %s = %d", number1, operation, number2, (n1+n2));
                case "-" -> String.format("%s %s %s = %d", number1, operation, number2, (n1-n2));
                case "*" -> String.format("%s %s %s = %d", number1, operation, number2, (n1*n2));
                case "/" -> String.format("%s %s %s = %.2f", number1, operation, number2, x);
                default -> "Ошибка: что то пошло не так!";
            };
        }

    }
}
