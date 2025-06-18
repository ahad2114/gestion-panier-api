package com.panier.controller;

import com.panier.service.PanierService;
import com.panier.model.TypeProduit;
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
    public double calculerPanier(@RequestBody Map<TypeProduit, Integer> produits,
                                 @RequestParam String clientId) {
        return panierService.calculerTotal(clientId, produits);
    }
}
