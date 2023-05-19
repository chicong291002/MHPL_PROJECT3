package BanHang.Controller;

import java.util.Collection;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import BanHang.DataBinding.CartDTO;
import BanHang.DataBinding.OrderDTO;
import BanHang.Service.ICartService;
import BanHang.Service.IOrderService;
import BanHang.ViewModel.JsonResponse;
import BanHang.ViewModel.JsonResponseData;

@Controller
public class CartController {
	private final IOrderService _orderService;
	private final ICartService _cartService;

	public CartController(IOrderService orderService, ICartService cartService) {
		_orderService = orderService;
		_cartService = cartService;
	}

	@RequestMapping(value = "/gio-hang", method = RequestMethod.GET)
	public String Index() {
		return "Cart/cart";
	}

	@RequestMapping(value = "/gio-hang", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<JsonResponseData<Collection<CartDTO>>> GetCartItem() {

		var result = _cartService.getListCartItem();
		return ResponseEntity.ok().body(result);
	}

	@PostMapping(value = "/gio-hang/xoa-san-pham", consumes = MediaType.ALL_VALUE)
	public ResponseEntity<JsonResponse> DeleteCartItem(@RequestBody Integer id) {
		var result = _cartService.remove(id);
		return ResponseEntity.ok().body(result);
	}

	@PostMapping(value = "/gio-hang/luu-hoa-don", consumes = MediaType.ALL_VALUE)
	public ResponseEntity<JsonResponse> createOrder(@RequestBody OrderDTO order) {
		var result = _orderService.createOrder(order);

		return ResponseEntity.ok().body(result);
	}

}
