package com.example.springrocking.responses;

public class CustomActuator {
    private String name;

    private int value;


    public CustomActuator(String name, int value) {
        this.name = name;
        this.value = value;
    }

    public CustomActuator() {
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getValue() {
        return this.value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "{" +
            " name='" + getName() + "'" +
            ", value='" + getValue() + "'" +
            "}";
    }
  
    
}
