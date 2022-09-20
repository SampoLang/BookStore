package hh.swd20com.example.BookStore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.session.NonUniqueSessionRepositoryException;
import org.springframework.context.annotation.Bean;

import hh.swd20com.example.BookStore.domain.Book;
import hh.swd20com.example.BookStore.domain.BookRepository;

@SpringBootApplication
public class BookStoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookStoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(BookRepository repository) {
		return (args) -> {
			Book potter = new Book("Potter", "Rowling", 2000,"1234hh", 19.90);
			Book lotr = new Book("LOTR", "Tolkien", 1980,"1234ty", 60.3);
			
			repository.save(potter);
			repository.save(lotr);
		};
	}

}
