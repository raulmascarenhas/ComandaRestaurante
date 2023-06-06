package com.example.Conta.Calculo;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private String nome;
    private List<Produto> produtos;
    private double valorPessoa;

   public Cliente() {
	   produtos = new ArrayList<>();
   }

    public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	public Cliente(String nome, List<Produto> produtos, double valorPessoa) {
		super();
		this.nome = nome;
		this.produtos = produtos;
		this.valorPessoa = valorPessoa;
	}

	public double getValorPessoa() {
        return valorPessoa;
    }

    public void setValorPessoa(double valorPessoa) {
        this.valorPessoa = valorPessoa;
    }
}

