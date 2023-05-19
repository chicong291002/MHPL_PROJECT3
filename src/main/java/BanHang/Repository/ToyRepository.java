package BanHang.Repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import BanHang.Entity.Toy;
import BanHang.ViewModel.ToyVm;

@Repository
public interface ToyRepository extends CrudRepository<Toy, Integer> {

	@Query(value = "SELECT v from Toy AS v LEFT JOIN v.Category AS c WHERE v.name LIKE %:keyword% OR c.name LIKE %:keyword%")
	Iterable<Toy> findByCategoryNameOrToyName(@Param("keyword") String keyword);

	@Query(value = "SELECT NEW BanHang.ViewModel.ToyVm(v.toyId,c.name,v.name,v.unit,v.amount,v.image,v.price,v.sold) FROM Toy AS v JOIN v.Category AS c WHERE v.toyId = :id")
	ToyVm GetToyVm(@Param("id") Integer id);

	@Query(value = "SELECT v from Toy AS v LEFT JOIN v.Category AS c WHERE c.categoryId = :CategoryId")
	Iterable<Toy> findByCategoryId(@Param("CategoryId") Integer CategoryId);
}
