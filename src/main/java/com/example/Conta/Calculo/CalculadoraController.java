package com.example.Conta.Calculo;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CalculadoraController {
    private List<Cliente> clientes = new ArrayList<>();

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("clientes", clientes);
        model.addAttribute("cliente", new Cliente());
        model.addAttribute("produto", new Produto());
        return "index";
    }

    @PostMapping("/adicionarCliente")
    public String adicionarCliente(@ModelAttribute Cliente cliente) {
        clientes.add(cliente);
        return "redirect:/";
    }

    @PostMapping("/adicionarProduto")
    public String adicionarProduto(@ModelAttribute Produto produto, @RequestParam int indiceCliente) {
        Cliente cliente = clientes.get(indiceCliente);
        cliente.getProdutos().add(produto);
        return "redirect:/";
    }

    @PostMapping("/calcularConta")
    public String calcularConta(@RequestParam int indiceCliente) {
        Cliente cliente = clientes.get(indiceCliente);
        double total = cliente.getProdutos().stream().mapToDouble(Produto::getValor).sum();
        double valorPorPessoa = total / clientes.size();
        double valorComTaxa = valorPorPessoa * 1.1;

        cliente.setValorPessoa(valorComTaxa);
        return "redirect:/";
    }
}

