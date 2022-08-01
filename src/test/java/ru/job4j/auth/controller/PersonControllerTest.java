package ru.job4j.auth.controller;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import ru.job4j.auth.AuthApplication;
import ru.job4j.auth.domain.Person;
import ru.job4j.auth.repository.PersonRepository;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;



@SpringBootTest(classes = AuthApplication.class)
@AutoConfigureMockMvc
public class PersonControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    PersonRepository personRepository;

    @Test
    public void ShouldReturnAllPerson() throws Exception {
        this.mockMvc.perform(get("/person/"))
                .andDo(print())
                .andExpect(status().isOk());
        verify(personRepository).findAll();
    }

    @Test
    public void ShouldReturnPerson() throws Exception {
        this.mockMvc.perform(get("/person/1"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
        verify(personRepository).findById(1);
    }

    @Test
    public void ShouldPostPerson() throws Exception {
        this.mockMvc.perform(post("/person/")
                .contentType("application/json")
                .content("{\"login\":\"job4j@gmail.com\",\"password\":\"123\"}"))
                .andDo(print())
                .andExpect(status().isCreated());
        ArgumentCaptor<Person> argument = ArgumentCaptor.forClass(Person.class);
        verify(personRepository).save(argument.capture());
        assertThat(argument.getValue().getId(), is(0));
        assertThat(argument.getValue().getLogin(), is("job4j@gmail.com"));
        assertThat(argument.getValue().getPassword(), is("123"));
    }

    @Test
    public void ShouldPutPerson() throws Exception {
        this.mockMvc.perform(put("/person/")
                .contentType("application/json")
                .content("{\"id\":\"1\",\"login\":\"support@job4j.com\",\"password\":\"123\"}"))
                .andDo(print())
                .andExpect(status().isOk());
        ArgumentCaptor<Person> argument = ArgumentCaptor.forClass(Person.class);
        verify(personRepository).save(argument.capture());
        assertThat(argument.getValue().getId(), is(1));
        assertThat(argument.getValue().getLogin(), is("support@job4j.com"));
        assertThat(argument.getValue().getPassword(), is("123"));
    }

    @Test
    public void ShouldDeletePerson() throws Exception {
        this.mockMvc.perform(delete("/person/1"))
                .andDo(print())
                .andExpect(status().isOk());
        ArgumentCaptor<Person> argument = ArgumentCaptor.forClass(Person.class);
        verify(personRepository).delete(argument.capture());
        assertThat(argument.getValue().getId(), is(1));
    }
}
