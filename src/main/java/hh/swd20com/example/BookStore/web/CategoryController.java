package hh.swd20com.example.BookStore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import hh.swd20com.example.BookStore.domain.Category;
import hh.swd20com.example.BookStore.domain.CategoryRepository;
@Controller
public class CategoryController {
	@Autowired
	private CategoryRepository categoryRepository;
	//return all categories to categorylist in a model
	@RequestMapping(value="/categorylist", method=RequestMethod.GET)
	public String listCategories(Model model) {
		model.addAttribute("categories", categoryRepository.findAll());
		return "categorylist";
		
	}
	//add empty category to model
	@RequestMapping(value="/addcategory")
	public String addCategory(Model model) {
		model.addAttribute("category", new Category());
		return "addcategory";
		
	}
	@RequestMapping(value="/savecategory", method = RequestMethod.POST)
	public String saveCategory(Category category) {
		categoryRepository.save(category);
		return "redirect:categorylist";
	}
}
