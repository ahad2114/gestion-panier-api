package com.panier.controller;
import com.panier.model.PanierRequest;
import com.panier.service.PanierService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/panier")
public class PanierController {

    @Autowired
    private PanierService panierService;

    @Operation(
            summary = "Calcule le total du panier pour un client donné",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Total calculé avec succès",
                            content = @Content(mediaType = "application/json",
                                    schema = @Schema(example = "{\"total\": 3200.0}")
                            )
                    )
            }
    )
    @PostMapping("/calcul")
    public Map<String, Double> calculerPanier(@RequestBody PanierRequest request) {
        double total = panierService.calculerTotal(request.getClientId(), request.getProduits());
        return Map.of("total", total);
    }
}