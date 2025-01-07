package com.market.model.entity;

import com.market.model.Animal;

public class Cachorro extends Animal {

    public Cachorro(String nome, int idade) {
        super(nome, idade);
    }

    @Override
    public void fazerSom() {
        System.out.println("O cachorro está latindo.");
    }

    public void correr() {
        System.out.println("O cachorro está correndo.");
    }
}
