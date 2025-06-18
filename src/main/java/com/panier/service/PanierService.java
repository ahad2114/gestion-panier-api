package com.panier.service;

import com.panier.model.*;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class PanierService {

    private final Map<String, Client> clients = new HashMap<>();

    public PanierService() {
        // Initialisation d'exemples de clients
        clients.put("C1", new ClientParticulier("C1", "Jean", "Dupont"));
        clients.put("PRO1", new ClientProfessionnel("PRO1", "TechCorp", Optional.of("FR123456789"), "123456789", 12_000_000));
        clients.put("PRO2", new ClientProfessionnel("PRO2", "MiniBiz", Optional.empty(), "987654321", 7_000_000));
    }

    public double calculerTotal(String clientId, Map<TypeProduit, Integer> produits) {
        Client client = clients.get(clientId);
        if (client == null) {
            throw new IllegalArgumentException("Client introuvable: " + clientId);
        }

        return produits.entrySet().stream()
                .mapToDouble(entry -> entry.getKey().getPrixPour(client) * entry.getValue())
                .sum();
    }

    public void ajouterClient(Client client) {
        clients.put(client.id, client);
    }
}
