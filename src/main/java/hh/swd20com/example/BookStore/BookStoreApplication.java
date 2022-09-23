package hh.swd20com.example.BookStore;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.swd20com.example.BookStore.domain.Book;
import hh.swd20com.example.BookStore.domain.BookRepository;
import hh.swd20com.example.BookStore.domain.Category;
import hh.swd20com.example.BookStore.domain.CategoryRepository;

@SpringBootApplication
public class BookStoreApplication {
	
	private static final Logger log = LoggerFactory.getLogger(BookStoreApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(BookStoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner bookDemo(BookRepository bookRepository, CategoryRepository categoryRepository) {
		return (args) -> {
			Book book1 = new Book("Potter", "Rowling", 2000,"1234hh", 19.90);
			Book book2 = new Book("LOTR", "Tolkien", 1980,"1234ty", 60.3);
			Book book3 = new Book("Animal Farm", "Orwell", 1989,"123tut-443", 6.3);
			Book book4 = new Book("Old man and the sea", "Hemingway", 1960,"ematsh-8045", 45.1);			
			bookRepository.save(book1);
			bookRepository.save(book2);
			bookRepository.save(book3);
			bookRepository.save(book4);
			
			Category category1 = new Category("Scifi");
			Category category2 = new Category("Fiction");
			Category category3 = new Category("Fantasy");
			Category category4 = new Category("Biography");
			categoryRepository.save(category1);
			categoryRepository.save(category2);
			categoryRepository.save(category3);
			categoryRepository.save(category4);
			log.info("Save some sample books\n");
			log.info("Save some sample categories\n");
			log.info("Fetch all the categories");
			categoryRepository.findAll().forEach((Category) -> {
				log.info("{}", Category);
			});
			log.info("");
			log.info("Fetch all the books");
			bookRepository.findAll().forEach((Book) -> {
				log.info("{}", Book + "\n");
				
			});
		};
	}

}
