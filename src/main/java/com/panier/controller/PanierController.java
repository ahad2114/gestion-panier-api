package com.panier.controller;

import com.panier.model.PanierRequest;
import com.panier.service.PanierService;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/panier")
public class PanierController {
    private final PanierService panierService;

    public PanierController(PanierService panierService) {
        this.panierService = panierService;
    }

    @PostMapping("/calcul")
    public Map<String, Double> calculerPanier(@RequestBody PanierRequest request) {
        double total = panierService.calculerTotal(request.getClientId(), request.getProduits());
        return Map.of("total", total);
    }
}