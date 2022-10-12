package de.neuefische.cgnjava222.ordersystem.shop;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.neuefische.cgnjava222.ordersystem.shop.order.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.awt.*;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class OrderIntegrationTests {
    @Autowired
    private MockMvc mvc;
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    @DirtiesContext
    void showAllProductsTest() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/api/orders"))
                .andExpect(status().isOk())
                .andExpect(content().json("[]"));
    }

    @Test
    @DirtiesContext
    void showSpecificOrderTest() throws Exception {
        String result = mvc.perform(MockMvcRequestBuilders.post("/api/orders")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                                .content("""
                                        []
                                        """))
                    .andExpect(status().isOk())
                            .andReturn().getResponse().getContentAsString();

        System.out.println(result);

        Order testOrder = objectMapper.readValue(result, Order.class);

        String expected = """
                [{"id":<ID>,"products":[]}]
                """.replace("<ID>", String.valueOf(testOrder.id()));


        mvc.perform(MockMvcRequestBuilders.get("/api/orders"))
                .andExpect(status().isOk())
                .andExpect(content().json(expected));
    }

}
