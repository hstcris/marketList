package com.market.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Animal {
    private String nome;
    private int idade;

    public void fazerSom() {
        System.out.println("O animal está fazendo um som.");
    }
}
