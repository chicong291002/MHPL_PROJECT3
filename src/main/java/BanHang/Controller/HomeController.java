package BanHang.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import BanHang.Entity.Category;
import BanHang.Entity.Toy;
import BanHang.Service.ICategoryService;
import BanHang.Service.IToyService;

@Controller
public class HomeController {

	// @Autowired
	private final ICategoryService _categoryService;
	private final IToyService _toyService;

	public HomeController(ICategoryService categoryService, IToyService toyService) {
		_categoryService = categoryService;
		_toyService = toyService;
	}

	@GetMapping("/home")
	public String Index(Model model) {
		Iterable<Category> listCategory = _categoryService.getAll();
		Iterable<Toy> listToy = _toyService.getAll();
		model.addAttribute("categoryModels", listCategory);
		model.addAttribute("toyModels", listToy);
		return "Home/home";
	}
}
