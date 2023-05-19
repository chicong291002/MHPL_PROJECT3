package BanHang.Service;

import BanHang.Entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public interface ICategoryService {
	@Autowired
	Iterable<Category> getAll();
}
