package hh.swd20com.example.BookStore.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import hh.swd20com.example.BookStore.domain.Book;

@Controller
public class BookController {
	
	@RequestMapping(value = "/index", method=RequestMethod.GET)
	public String bookFrom(Model model) {
		model.addAttribute("book", new Book());
		return "index";
		}
}
