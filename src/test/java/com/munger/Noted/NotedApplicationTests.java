package com.munger.Noted;

/*
import org.apache.catalina.core.ApplicationContext;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.TestExecutionListener;
import dev.munger.noted.NotedApplication;
import dev.munger.noted.models.Note;*/
import java.util.List;
import java.util.Map;

import org.aspectj.lang.annotation.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.context.jdbc.SqlGroup;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import dev.munger.noted.controller.NoteController;
import dev.munger.noted.models.Note;
import dev.munger.noted.repository.NoteRepository;

import static org.junit.Assert.assertEquals;

import java.sql.*;

@RunWith(SpringRunner.class)
@WebMvcTest(NoteController.class)
public class NotedApplicationTests {
	@InjectMocks
    private NoteController noteController;

    @Mock
    private NoteRepository noteRepository;

    public NotedApplicationTests() {
        MockitoAnnotations.initMocks(this);
    }

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Test
	public void createAndDeleteItem() {
		NoteController noteController = new NoteController();
		Note sampleNote = new Note();
		sampleNote.setTitle("Test Note");
		sampleNote.setContent("Test Content");

		Note result = noteController.createNote(sampleNote);
		assertEquals(sampleNote.getInfo(), result.getInfo());

		Long id = result.getId();
		result = noteController.getNoteById(id);
		assertEquals(sampleNote.getInfo(), result.getInfo());


	}

}
