package com.panier.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.panier.model.PanierRequest;
import com.panier.model.TypeProduit;
import com.panier.service.PanierService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Map;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(PanierController.class)
public class PanierControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PanierService panierService;

    private final ObjectMapper objectMapper = new ObjectMapper();

    private PanierRequest request;

    @BeforeEach
    public void setup() {
        request = new PanierRequest();
        request.setClientId("PRO1");
        request.setProduits(Map.of(
                TypeProduit.HAUT_DE_GAMME, 2,
                TypeProduit.LAPTOP, 1
        ));
    }

    @Test
    public void testCalculerPanierRetourneTotalCorrect() throws Exception {
        // Simuler le résultat retourné par le service
        when(panierService.calculerTotal("PRO1", request.getProduits()))
                .thenReturn(2900.0);

        mockMvc.perform(post("/api/panier/calcul")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.total").value(2900.0));
    }
}