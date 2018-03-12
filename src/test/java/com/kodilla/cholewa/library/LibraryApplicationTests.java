package com.kodilla.cholewa.library;

import com.kodilla.cholewa.library.domain.copies.Copy;
import com.kodilla.cholewa.library.domain.readers.Reader;
import com.kodilla.cholewa.library.domain.titles.Title;
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

	@Test
	public void testSaveTitle() {
		//Given
		Title title = new Title("Code", "Jim Moore", 2015);

		//When
		service.saveTitle(title);

		Long id = title.getId();
		Title findTitle = service.getTitle(id);

		//Then
		Assert.assertEquals(id, findTitle.getId());

		//CleanUp
		service.deleteTitle(id);
	}

	@Test
	public void testSaveCopy() {
		//Given
		Copy copy = new Copy(1L, Copy.STATUS_IN_USE);

		//When
		service.saveCopy(copy);

		Long id = copy.getId();
		Copy findCopy = service.getCopy(id);

		//Then
		Assert.assertEquals(id, findCopy.getId());

		//CleanUp
		service.deleteCopy(id);
	}
}
