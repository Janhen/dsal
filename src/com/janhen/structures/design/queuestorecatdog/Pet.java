package com.janhen.structures.design.queuestorecatdog;

public class Pet {
    private final String type;

    public Pet(String type) {
        this.type = type;
    }

    public String getPetType() {
        return this.type;
    }
}
