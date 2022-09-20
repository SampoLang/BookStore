package hh.swd20com.example.BookStore.web;

import java.lang.ProcessBuilder.Redirect;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import hh.swd20com.example.BookStore.domain.Book;
import hh.swd20com.example.BookStore.domain.BookRepository;

@Controller
public class BookController {
	@Autowired
	private BookRepository repository;
	
	@RequestMapping(value = "/studentlist", method=RequestMethod.GET)
	public String bookFrom(Model model) {
		model.addAttribute("books", repository.findAll());
		return "booklist";
		}
	@RequestMapping(value="/delete/{id}", method = RequestMethod.GET)
	public String deleteStudent(@PathVariable("id") Long bookId, Model model) {
		repository.deleteById(bookId);
		return "redirect:../studentlist";
		
	}
}
