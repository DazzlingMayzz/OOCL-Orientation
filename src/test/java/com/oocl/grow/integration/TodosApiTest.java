package com.oocl.grow.integration;

import com.oocl.grow.GrowApplication;
import com.oocl.grow.model.Todo;
import com.oocl.grow.repository.TodoRepository;
import lombok.Builder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK, classes = GrowApplication.class)
@AutoConfigureMockMvc
@AutoConfigureTestDatabase

public class TodosApiTest {
    @Autowired
    private MockMvc mvc;

    @Autowired
    private TodoRepository todoRepository;

    @Test
    public void givenTodos_whenGetTodos_thenStatus200()
            throws Exception {
        ArrayList<Todo> todos = new ArrayList<>();

        todos.add(new Todo("learn TDD", false));
        todos.add(new Todo("drink coffee", false));

        todoRepository.saveAll(todos);

        mvc.perform(get("/api/todos")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content()
                        .contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].title", is("123")));
    }
}
