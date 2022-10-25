package hh.swd20com.example.BookStore;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import hh.swd20com.example.BookStore.domain.BookRepository;
@ExtendWith(SpringExtension.class)
@SpringBootTest
class BookStoreApplicationTests {
	@Autowired
	private BookRepository bookrepo;
	@Test
	void contextLoads() {
	}

}
