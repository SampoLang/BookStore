package hh.swd20com.example.BookStore.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import hh.swd20com.example.BookStore.domain.Book;
import hh.swd20com.example.BookStore.domain.BookRepository;
import hh.swd20com.example.BookStore.domain.CategoryRepository;

@Controller
public class BookController {
	@Autowired
	private BookRepository repository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@RequestMapping(value = "/booklist", method=RequestMethod.GET)
	public String bookFrom(Model model) {
		model.addAttribute("books", repository.findAll());
		return "booklist";
		}
	//delete book
	@RequestMapping(value="/delete/{id}", method = RequestMethod.GET)
	@PreAuthorize("hasRole('ADMIN')")
	public String deleteBook(@PathVariable("id") Long bookId, Model model) {
		repository.deleteById(bookId);
		return "redirect:../booklist";
		
	}
	//add new book and category to the model
	@RequestMapping(value="/add")
	public String addBook(Model model) {
		model.addAttribute("book", new Book());
		model.addAttribute("categories", categoryRepository.findAll());
		System.out.println(model);
		return "addbook";
	}
	//save book
	@RequestMapping(value="/save", method = RequestMethod.POST)
	public String save(Book book) {
		repository.save(book);
		return "redirect:booklist";
	}
	//add the chosen book by id to model
	@RequestMapping(value="/edit/{id}", method = RequestMethod.GET)
	public String addEditBook(@PathVariable("id") Long bookId, Model model) {
		model.addAttribute("book", repository.findById(bookId));
		System.out.println(model);
		return "editbook";
	}
	//RESTful Service that gets all the books
	@RequestMapping(value="/books", method=RequestMethod.GET)
	public @ResponseBody List<Book> bookListRest(){
		return (List<Book>)repository.findAll();
		
	}
	//Restful service that gets a book using id
	@RequestMapping(value="/book/{id}", method=RequestMethod.GET)
	public @ResponseBody   Optional<Book> findBookRest(@PathVariable("id") Long bookId) {
		return repository.findById(bookId);
	}
	
	@RequestMapping(value="/login", method = RequestMethod.GET)
	public String login(){
		return "login";
	}
	

}
