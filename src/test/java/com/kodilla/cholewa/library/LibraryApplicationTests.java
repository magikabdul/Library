package com.kodilla.cholewa.library;

import com.kodilla.cholewa.library.domain.copies.Copy;
import com.kodilla.cholewa.library.domain.readers.Reader;
import com.kodilla.cholewa.library.domain.rents.Rent;
import com.kodilla.cholewa.library.domain.titles.Title;
import com.kodilla.cholewa.library.service.DbService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LibraryApplicationTests {

	@Autowired
	private DbService service;

	@Test
	public void testSaveReader() {
		//Given
		Title title = new Title("Code", "Jim Moore", 2015);

		Copy copy = new Copy(title, Copy.STATUS_IN_USE);
		copy.setTitle(title);

		Reader reader = new Reader("Krzysztof", "Cholewa");

		Rent rent = new Rent(new Date(), reader, copy);

		//When
		service.saveReader(reader);
		service.saveTitle(title);
		service.saveCopy(copy);
		service.saveRent(rent);

		//Then
		Long id = reader.getId();
		Reader findReader = service.getReader(id);

		Assert.assertEquals(id, findReader.getId());

		//CleanUp
		service.deleteReader(id);
	}

//	@Test
//	public void testSaveTitle() {
//		//Given
//		Title title = new Title("Code", "Jim Moore", 2015);
//
//		Copy copy = new Copy(title, Copy.STATUS_IN_USE);
//		copy.setTitle(title);
//
//		Reader reader = new Reader("Krzysztof", "Cholewa");
//
//		Rent rent = new Rent(new Date(), reader, copy);
//
//		//When
//		service.saveTitle(title);
//
//		Long id = title.getId();
//		Title findTitle = service.getTitle(id);
//
//		//Then
//		Assert.assertEquals(id, findTitle.getId());
//
//		//CleanUp
//		service.deleteTitle(id);
//	}
//
//	@Test
//	public void testSaveCopy() {
//		//Given
//		Title title = new Title("Code", "Jim Moore", 2015);
//
//		Copy copy = new Copy(title, Copy.STATUS_IN_USE);
//		copy.setTitle(title);
//
//		Reader reader = new Reader("Krzysztof", "Cholewa");
//
//		Rent rent = new Rent(new Date(), reader, copy);
//
//		//When
//		service.saveCopy(copy);
//
//		Long id = copy.getId();
//		Copy findCopy = service.getCopy(id);
//
//		//Then
//		Assert.assertEquals(id, findCopy.getId());
//
//		//CleanUp
//		service.deleteCopy(id);
//	}
//
//	@Test
//	public void testSaveRent() {
//		//Given
//		Title title = new Title("Code", "Jim Moore", 2015);
//
//		Copy copy = new Copy(title, Copy.STATUS_IN_USE);
//		copy.setTitle(title);
//
//		Reader reader = new Reader("Krzysztof", "Cholewa");
//
//		Rent rent = new Rent(new Date(), reader, copy);
//
//		//When
//		service.saveRent(rent);
//
//		Long id = rent.getId();
//		Rent findRent = service.getRent(id);
//
//		//Then
//		Assert.assertEquals(id, findRent.getId());
//
//		//CleanUp
//		service.deleteRent(id);
//	}
}
