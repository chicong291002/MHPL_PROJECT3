package BanHang.Controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import BanHang.DataBinding.ToyDTO;
import BanHang.Entity.Category;
import BanHang.Entity.Toy;
import BanHang.Service.ICategoryService;
import BanHang.Service.IToyService;

@Controller
public class ShopController {

	private final IToyService _toyService;
	private final ICategoryService _categoryService;

	public ShopController(IToyService toyService, ICategoryService categoryService) {
		_toyService = toyService;
		_categoryService = categoryService;
	}

	@GetMapping("/cua-hang")
	public String Index(Model model, @RequestParam(name = "catid", required = false) Integer catId,
			@RequestParam(name = "keyword", required = false) String keyword,
			@RequestParam(name = "sort-by", required = false) String sort) {

		ToyDTO filters = new ToyDTO();
		filters.setCatId(catId);
		filters.setKeyword(keyword);
		filters.setSort(sort);

		List<Toy> listVegetable = _toyService.GetFilterToy(filters);
		Iterable<Category> listCategory = _categoryService.getAll();

		model.addAttribute("models", listVegetable);
		model.addAttribute("categories", listCategory);
		return "Shop/shop";
	}
}
