package com.example.cats;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import com.example.cats.Controller.CatNotFoundException;
import com.example.cats.Controller.CatController;
import com.example.cats.Model.Cat;
import com.example.cats.Service.CatService;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(CatController.class)
public class CatControllerTest {
    @MockBean
    CatService catService;

    @Autowired
    MockMvc mockMvc;

    @Test
    public void testGetById() throws Exception {
        Cat cat = new Cat();
        cat.setId("1");
        cat.setName("Boots");

        when(catService.findById("1")).thenReturn(cat);

        ResultActions result = mockMvc.perform(get("/api/cats/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Boots"));

        verify(catService).findById("1");

    }

    @Test
    public void testGetByIdNotFound() throws Exception {

        when(catService.findById("1")).thenThrow(new CatNotFoundException());

        ResultActions result = mockMvc.perform(get("/api/cats/1"))
                .andExpect(status().isNotFound());

        verify(catService).findById("1");

    }
}
