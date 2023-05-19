package BanHang.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import BanHang.Entity.Category;
import BanHang.Repository.CategoryRepository;

@Service
public class CategoryService implements ICategoryService{

	@Autowired(required = true)
	private CategoryRepository _caterogyRepository;
	
	@Override
	public Iterable<Category> getAll() {
		return _caterogyRepository.findAll();
	}

}
