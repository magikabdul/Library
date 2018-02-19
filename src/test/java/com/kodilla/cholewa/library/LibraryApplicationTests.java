package com.kodilla.cholewa.library;

import com.kodilla.cholewa.library.domain.Reader;
import com.kodilla.cholewa.library.repository.DbService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LibraryApplicationTests {

	@Autowired
	private DbService service;

	@Test
	public void testSaveReader() {
		//Given
		Reader reader = new Reader("Krzysztof", "Cholewa");

		//When
		service.saveReader(reader);

		//Then
		Long id = reader.getId();
		Reader findReader = service.getReader(id);

		Assert.assertEquals(id, findReader.getId());

		//CleanUp
		service.deleteReader(id);
	}
}
