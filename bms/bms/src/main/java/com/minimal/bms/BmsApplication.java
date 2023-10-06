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

		Book book1 = new Book("978-1-4447-2073-0", "The Stand", List.of("Stephen King"), 2011);
		BookService.addBook(book1);
		Book book2 = new Book("978-1-4447-0786-1", "It", List.of("Stephen King"), 2011);
		BookService.addBook(book2);
		Book book3 = new Book("978-0-349-43703-3", "Iron Flame", List.of("Rebecca Yarros"), 2023);
		BookService.addBook(book3);
		Book book4 = new Book("978-3-11-044375-2", "Datenbanksysteme", List.of("Alfons Kemper", "Andre Eickler"), 2015);
		BookService.addBook(book4);
	}
}
