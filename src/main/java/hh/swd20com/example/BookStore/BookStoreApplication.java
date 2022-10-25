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
import hh.swd20com.example.BookStore.domain.User;
import hh.swd20com.example.BookStore.domain.UserRepository;

@SpringBootApplication
public class BookStoreApplication {
	
	private static final Logger log = LoggerFactory.getLogger(BookStoreApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(BookStoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner bookDemo(BookRepository bookRepository, CategoryRepository categoryRepository, UserRepository userRepository) {
		return (args) -> {
			
			Category category1 = new Category("Scifi");
			Category category2 = new Category("Fiction");
			Category category3 = new Category("Fantasy");
			Category category4 = new Category("Biography");
			categoryRepository.save(category1);
			categoryRepository.save(category2);
			categoryRepository.save(category3);
			categoryRepository.save(category4);
			Book book1 = new Book("Potter", "Rowling", 2000,"1234hh", 19.90, category1);
			Book book2 = new Book("LOTR", "Tolkien", 1980,"1234ty", 60.3, category3);
			Book book3 = new Book("Animal Farm", "Orwell", 1989,"123tut-443", 6.3, category2);
			Book book4 = new Book("Old man and the sea", "Hemingway", 1960,"ematsh-8045", 45.1, category4);			
			bookRepository.save(book1);
			bookRepository.save(book2);
			bookRepository.save(book3);
			bookRepository.save(book4);
			User user1 = new User( "user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER", "user@user.com" );
			User user2 = new User("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "ADMIN", "admin@admin.com");
			User user3 = new User("sampo", "$2a$10$J22jDI2uKweGp7GFvkhd.ugMc1DvaEwdEckT3glcpsXF25ACX2rPu", "ADMIN", "sampo@admin.com");

			userRepository.save(user1);
			userRepository.save(user2);
			userRepository.save(user3);
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
