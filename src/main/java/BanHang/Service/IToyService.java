package BanHang.Service;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import BanHang.DataBinding.OrderDetailDTO;
import BanHang.DataBinding.ToyDTO;
import BanHang.Entity.Toy;
import BanHang.ViewModel.ToyVm;

@Service
public interface IToyService {
	@Autowired
	public Iterable<Toy> getAll();

	public ToyVm GetToyVm(Integer id);

	public List<Toy> GetFilterToy(ToyDTO filter);

	Boolean UpdateAmount(Collection<OrderDetailDTO> orderDetailDTOs);
}