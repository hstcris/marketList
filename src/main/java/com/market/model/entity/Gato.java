package com.market.model.entity;

import com.market.model.Animal;

public class Gato extends Animal {

    public Gato(String nome, int idade) {
        super(nome, idade);
    }

    @Override
    public void fazerSom() {
        System.out.println("O gato está miando.");
    }

    public void arranhar() {
        System.out.println("O gato está arranhando.");
    }
}
