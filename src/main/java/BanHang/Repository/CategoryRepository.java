package BanHang.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import BanHang.Entity.Category;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Integer>{
	Category findByCategoryId(int CategoryId);
}
