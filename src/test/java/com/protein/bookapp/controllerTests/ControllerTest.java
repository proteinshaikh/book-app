package com.protein.bookapp.controllerTests;

import com.protein.bookapp.controller.BookController;
import com.protein.bookapp.entity.Book;
import com.protein.bookapp.service.BookService;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.skyscreamer.jsonassert.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@WebMvcTest(BookController.class)
public class ControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    BookService bookService;

    @Test
    public void testGetBooks() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders
                .get("/bookservice/books/1")
                .accept(MediaType.APPLICATION_JSON);

        Book book = new Book();
        book.setAuthor("test");
        book.setName("zeeshan");
        book.setPrice(12);


        MvcResult result = mockMvc.perform(request)
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    public void testPostBooks() throws Exception {
        Book book = new Book();
        book.setAuthor("test");
        book.setName("zeeshan");
        book.setPrice(12);

        RequestBuilder request = MockMvcRequestBuilders
                .get("/bookservice/books")
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(request)
                .andExpect(status().isOk())
                .andReturn();
    }

}
