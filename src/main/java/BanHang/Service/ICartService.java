package BanHang.Service;

import java.util.Collection;

import org.springframework.stereotype.Service;

import BanHang.DataBinding.CartDTO;
import BanHang.ViewModel.JsonResponse;
import BanHang.ViewModel.JsonResponseData;

@Service
public interface ICartService {
	JsonResponse addToCart(CartDTO cart);

	JsonResponseData<Collection<CartDTO>> getListCartItem();

	JsonResponseData<Collection<CartDTO>> remove(Integer id);
}
