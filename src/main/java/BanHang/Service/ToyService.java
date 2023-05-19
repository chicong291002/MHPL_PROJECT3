package BanHang.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

import BanHang.DataBinding.OrderDetailDTO;
import BanHang.DataBinding.ToyDTO;
import BanHang.Entity.Category;
import BanHang.Entity.Toy;
import BanHang.Repository.CategoryRepository;
import BanHang.Repository.ToyRepository;
import BanHang.ViewModel.ToyVm;
import jakarta.transaction.Transactional;

@Service
public class ToyService implements IToyService {

	private final ToyRepository _toyRepository;
	private final CategoryRepository _categoryRepository;

	public ToyService(ToyRepository toyRepository, CategoryRepository categoryRepository) {
		_toyRepository = toyRepository;
		_categoryRepository = categoryRepository;
	}

	@Override
	public Iterable<Toy> getAll() {
		return _toyRepository.findAll();
	}

	@Override
	public ToyVm GetToyVm(Integer id) {
		return _toyRepository.GetToyVm(id);
	}

	@Override
	public List<Toy> GetFilterToy(ToyDTO filter) {
		Iterable<Toy> iterableVegetable = _toyRepository.findAll();

		// convert Iterable to List
		List<Toy> listVegetable = new ArrayList<>();
		iterableVegetable.forEach(listVegetable::add);

		// filter vegetable
		if (filter != null) {
			if (filter.getCatId() != null) {
				Category cat = _categoryRepository.findById(filter.getCatId()).orElse(null);
				listVegetable = listVegetable.stream().filter(x -> x.getCategory() == cat).collect(Collectors.toList());
			}

			if (filter.getKeyword() != null) {
				listVegetable = listVegetable.stream()
						.filter(x -> x.getName().toLowerCase().contains(filter.getKeyword().toLowerCase()))
						.collect(Collectors.toList());
			}

			if (filter.getSort() != null) {
				if (filter.getSort().equals("best-seller")) {
					listVegetable.sort(Comparator.comparing(Toy::getSold).reversed());
				}
			}
		}

		return listVegetable;
	}

	@Override
	@Transactional
	@Modifying
	public Boolean UpdateAmount(Collection<OrderDetailDTO> orderDetailDTOs) {
		for (OrderDetailDTO item : orderDetailDTOs) {
			Toy vegetable = _toyRepository.findById(item.getVegetableId()).orElse(null);
			if (vegetable == null) {
				return false;
			}
			vegetable.setAmount(vegetable.getAmount() - item.getQuantity());
			vegetable.setSold(vegetable.getSold() + item.getQuantity());
			_toyRepository.save(vegetable);
		}
		return true;
	}
}