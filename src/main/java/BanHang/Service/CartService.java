package BanHang.Service;

import java.util.Collection;
import java.util.HashMap;

import org.springframework.stereotype.Service;

import BanHang.DataBinding.CartDTO;
import BanHang.Repository.ToyRepository;
import BanHang.ViewModel.JsonResponse;
import BanHang.ViewModel.JsonResponseData;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Service
public class CartService implements ICartService {
	private final HttpServletRequest _request;
	private final ToyRepository _vegetableRepository;

	public CartService(HttpServletRequest _request, ToyRepository _vegetableRepository) {
		this._request = _request;
		this._vegetableRepository = _vegetableRepository;
	}

	@SuppressWarnings("unchecked")
	@Override
	public JsonResponse addToCart(CartDTO cart) {
		// Get sản phẩm mới thêm vào
		var product = _vegetableRepository.findById(cart.getToyId()).orElse(null);
		HttpSession session = _request.getSession();
		HashMap<Integer, CartDTO> listItem = new HashMap<>();
		if (session.getAttribute("listItem") == null) {
			session.setAttribute("listItem", listItem);
		}

		listItem = (HashMap<Integer, CartDTO>) session.getAttribute("listItem");

		CartDTO item = listItem.get(cart.getToyId());
		if (item == null) {
			listItem.put(cart.getToyId(), cart);
		} else {
			if (item.getQuantity() + cart.getQuantity() > product.getAmount()) {
				return new JsonResponse(false, "Số lượng sản phẩm đã vượt quá số lượng còn lại");
			}
			item.setQuantity(item.getQuantity() + cart.getQuantity());
			item.setSubTotal(item.getSubTotal() + cart.getSubTotal());
		}
		session.setAttribute("listItem", listItem);
		return new JsonResponse(true, "Thêm sản phẩm vào giỏ hàng thành công");
	}

	@SuppressWarnings("unchecked")
	@Override
	public JsonResponseData<Collection<CartDTO>> getListCartItem() {
		HttpSession session = _request.getSession();
		HashMap<Integer, CartDTO> listItem = new HashMap<>();
		if (session.getAttribute("listItem") == null) {
			session.setAttribute("listItem", listItem);
			return new JsonResponseData<Collection<CartDTO>>(true, "Success", listItem.values());
		}
		listItem = (HashMap<Integer, CartDTO>) session.getAttribute("listItem");

		return new JsonResponseData<Collection<CartDTO>>(true, "Success", listItem.values());
	}

	@SuppressWarnings("unchecked")
	@Override
	public JsonResponseData<Collection<CartDTO>> remove(Integer id) {
		HttpSession session = _request.getSession();
		HashMap<Integer, CartDTO> listItem = new HashMap<>();

		listItem = (HashMap<Integer, CartDTO>) session.getAttribute("listItem");

		CartDTO item = listItem.get(id);
		if (item == null) {
			return new JsonResponseData<Collection<CartDTO>>(false, "Không tồn tại sản phẩm này, vui lòng thử lại sau",
					listItem.values());
		}
		Boolean result = listItem.remove(id, item);
		if (result == false) {
			return new JsonResponseData<Collection<CartDTO>>(false, "Xóa thất bại, vui lòng thử lại sau",
					listItem.values());
		}
		session.setAttribute("listItem", listItem);
		return new JsonResponseData<Collection<CartDTO>>(true, "Xóa thành công", listItem.values());
	}

}
