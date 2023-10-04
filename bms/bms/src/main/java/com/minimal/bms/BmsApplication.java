package com.minimal.bms;

import com.minimal.bms.entity.Book;
import com.minimal.bms.service.BookService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class BmsApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(BmsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Book book1 = new Book("978-144-4720730", "The Stand", List.of("Stephen King"), 2011);
		BookService.addBook(book1);
		Book book2 = new Book("978-144-4707861", "It", List.of("Stephen King"), 2011);
		BookService.addBook(book2);
		Book book3 = new Book("978-034-9440262", "Iron Flame", List.of("Rebecca Yarros"), 2023);
		BookService.addBook(book3);
		Book book4 = new Book("978-311-0443752", "Datenbanksysteme", List.of("Alfons Kemper", "Andre Eickler"), 2015);
		BookService.addBook(book4);
	}
}
