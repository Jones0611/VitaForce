package com.example.FitnessStore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
public class ProductController {

    private final List<Map<String, String>> produtos = new ArrayList<>();

    public ProductController() {
        produtos.add(Map.of("id", "1", "nome", "Whey Protein", "preco", "R$ 149,90", "descricao", "Suplemento proteico para recuperação muscular."));
        produtos.add(Map.of("id", "2", "nome", "Gel de Corrida", "preco", "R$ 9,90", "descricao", "Fonte rápida de energia para treinos e provas."));
        produtos.add(Map.of("id", "3", "nome", "Barra de Proteína", "preco", "R$ 12,00", "descricao", "Snack prático com alto teor proteico."));
        produtos.add(Map.of("id", "4", "nome", "Pré-Treino", "preco", "R$ 89,90", "descricao", "Aumenta foco e energia antes do treino."));
        produtos.add(Map.of("id", "5", "nome", "Cápsula de Sal", "preco", "R$ 49,90", "descricao", "Ajuda na reposição de sais minerais durante treinos longos."));
        produtos.add(Map.of("id", "6", "nome", "Creatina", "preco", "R$ 99,90", "descricao", "Suplemento para força e desempenho."));
        produtos.add(Map.of("id", "7", "nome", "Isotônico", "preco", "R$ 6,50", "descricao", "Reidratação com eletrólitos para esportistas."));
        produtos.add(Map.of("id", "8", "nome", "BCAA", "preco", "R$ 79,90", "descricao", "Aminoácidos que auxiliam na recuperação muscular."));
        produtos.add(Map.of("id", "9", "nome", "Maltodextrina", "preco", "R$ 59,90", "descricao", "Fonte de carboidratos para energia sustentada durante treinos."));
        produtos.add(Map.of("id", "10", "nome", "Cafeína em Cápsulas", "preco", "R$ 39,90", "descricao", "Melhora o foco e reduz a fadiga durante exercícios."));
        produtos.add(Map.of("id", "11", "nome", "Carb Up Energy Gel", "preco", "R$ 8,90", "descricao", "Gel energético com carboidratos de rápida absorção."));
        produtos.add(Map.of("id", "12", "nome", "Óleo de Peixe (Ômega 3)", "preco", "R$ 69,90", "descricao", "Auxilia na recuperação e saúde cardiovascular."));
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("produtos", produtos);
        return "index";
    }

    @GetMapping("/produto/{id}")
    public String produto(@PathVariable String id, Model model) {
        Map<String, String> produto = produtos.stream()
                .filter(p -> p.get("id").equals(id))
                .findFirst()
                .orElse(null);

        model.addAttribute("produto", produto);
        return "produto";
    }
}
