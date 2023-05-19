package BanHang.Service;

import org.springframework.stereotype.Service;

import BanHang.DataBinding.OrderDTO;
import BanHang.ViewModel.JsonResponse;

@Service
public interface IOrderService {
	 JsonResponse createOrder(OrderDTO order);
}
