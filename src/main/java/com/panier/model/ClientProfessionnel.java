package com.panier.model;

import java.util.Optional;

public class ClientProfessionnel extends Client {
    private String raisonSociale;
    private Optional<String> numeroTVA;
    private String siren;
    private double chiffreAffaires;

    public ClientProfessionnel(String id, String raisonSociale, Optional<String> numeroTVA, String siren, double chiffreAffaires) {
        super(id);
        this.raisonSociale = raisonSociale;
        this.numeroTVA = numeroTVA;
        this.siren = siren;
        this.chiffreAffaires = chiffreAffaires;
    }

    public double getChiffreAffaires() {
        return chiffreAffaires;
    }
}
