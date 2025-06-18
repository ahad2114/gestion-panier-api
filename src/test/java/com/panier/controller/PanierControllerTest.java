package com.panier.controller;

import com.panier.service.PanierService;
import com.panier.model.TypeProduit;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Map;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(PanierController.class)
public class PanierControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PanierService panierService;

    @Test
    public void testCalculPanier() throws Exception {
        when(panierService.calculerTotal("C1", Map.of(TypeProduit.LAPTOP, 1))).thenReturn(1200.0);

        mockMvc.perform(post("/api/panier/calcul?clientId=C1")
                .contentType("application/json")
                .content("{"LAPTOP": 1}"))
                .andExpect(status().isOk());
    }
}
