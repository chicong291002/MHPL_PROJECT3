package BanHang.Controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import BanHang.DataBinding.CartDTO;
import BanHang.Service.ICartService;
import BanHang.Service.IToyService;
import BanHang.ViewModel.JsonResponse;
import BanHang.ViewModel.ToyVm;

@Controller
public class ProductController {

	private final IToyService _toyService;
	private final ICartService _cartService;

	public ProductController(IToyService toyService, ICartService cartService) {
		_toyService = toyService;
		_cartService = cartService;
	}

	@RequestMapping(value = "/san-pham/{id}", method = RequestMethod.GET)
	public String Index(@PathVariable("id") Integer id, Model model) {
		ToyVm toyVm = _toyService.GetToyVm(id);
		model.addAttribute("model", toyVm);
		return "Product/product";
	}

	@RequestMapping(value = "/san-pham/them-gio-hang", method = RequestMethod.POST, consumes = MediaType.ALL_VALUE)
	@ResponseBody
	public ResponseEntity<JsonResponse> addToCart(@RequestBody CartDTO cartItem) {
		var result = _cartService.addToCart(cartItem);
		return ResponseEntity.ok().body(result);
	}
}