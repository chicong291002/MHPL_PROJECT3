package BanHang.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;

import org.springframework.stereotype.Service;

import BanHang.DataBinding.CartDTO;
import BanHang.DataBinding.OrderDTO;
import BanHang.DataBinding.OrderDetailDTO;
import BanHang.Entity.Customer;
import BanHang.Entity.Order;
import BanHang.Entity.OrderDetail;
import BanHang.Entity.Toy;
import BanHang.Repository.CustomersRepository;
import BanHang.Repository.OrderRepository;
import BanHang.Repository.ToyRepository;
import BanHang.ViewModel.JsonResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.transaction.Transactional;

@Service
public class OrderService implements IOrderService {

	private final OrderRepository _orderRepository;
	private final CustomersRepository _customerRepository;
	private final ToyRepository _toyRepository;
	private final IToyService _toyService;
	private final HttpServletRequest _request;

	public OrderService(OrderRepository orderRepository, CustomersRepository customerRepository,
			ToyRepository toyRepository, IToyService toyService, HttpServletRequest request) {
		_orderRepository = orderRepository;
		_customerRepository = customerRepository;
		_toyRepository = toyRepository;
		_toyService = toyService;
		_request = request;
	}

	@Transactional
	public JsonResponse createOrder(OrderDTO order) {
		// Get khách hàng
		Customer customer = _customerRepository.findByCustomerId(order.getCustomerId());

		if (customer == null) {
			return new JsonResponse(false, "Bạn chưa đăng nhập hoặc có lỗi");
		}

		// Get giỏ hàng trong session
		HttpSession session = _request.getSession();

		HashMap<Integer, CartDTO> cart = new HashMap<>();
		cart = (HashMap<Integer, CartDTO>) session.getAttribute("listItem");

		if (cart == null || cart.isEmpty()) {
			return new JsonResponse(false, "Giỏ hàng trống");
		}

		// Convert từ CartItemDTO sang OrderDetailDTO
		Collection<OrderDetailDTO> listOrderDetail = new ArrayList<>();

		for (CartDTO item : cart.values()) {
			OrderDetailDTO detail = new OrderDetailDTO();
			detail.setVegetableId(item.getToyId());
			detail.setPrice(item.getPrice());
			detail.setSubTotal(item.getSubTotal());
			detail.setQuantity(item.getQuantity());

			listOrderDetail.add(detail);
		}

		// Tạo hóa đơn
		Order newOrder = new Order();

		for (OrderDetailDTO item : listOrderDetail) {
			OrderDetail detail = new OrderDetail();
			Toy toy = _toyRepository.findById(item.getVegetableId()).orElse(null);
			detail.setPrice(item.getPrice());
			detail.setQuantity(item.getQuantity());
			detail.setSubTotal(item.getSubTotal());
			detail.setToy(toy);

			// hàm này dùng để kết nối chéo giữa hóa đơn và chi tiết hóa đơn
			newOrder.addToOrderDetail(detail);

			// set total
			newOrder.setTotal(newOrder.getTotal() + item.getSubTotal());
		}
		newOrder.setCustomer(customer);
		newOrder.setAddress(order.getAddress());
		newOrder.setNote(order.getNote());
		newOrder.setDate(new Date());

		Order checkOrder = _orderRepository.save(newOrder);

		if (checkOrder != null) {
			_toyService.UpdateAmount(listOrderDetail);
		} else {
			new JsonResponse(false, "Đặt hàng thất bại");
		}

		// set lại session giỏ hàng trống
		session.setAttribute("listItem", new HashMap<Integer, CartDTO>());
		return new JsonResponse(true, "Đặt hàng thành công");
	}
}