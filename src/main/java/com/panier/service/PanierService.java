package com.panier.service;

import com.panier.model.*;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class PanierService {

    public double calculerTotal(String clientId, Map<TypeProduit, Integer> produits) {
        Client client = new ClientParticulier(clientId, "Jean", "Dupont"); // simulation
        return produits.entrySet().stream()
                .mapToDouble(e -> e.getKey().getPrixPour(client) * e.getValue())
                .sum();
    }
}
