package BanHang.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import BanHang.Entity.Customer;

@Repository
public interface CustomersRepository extends CrudRepository<Customer, Integer> {
	Customer findByUserNameAndPassword(String UserName, String Password);

	Customer findByCustomerId(int CustomerId);

	Customer findByUserName(String UserName);
}
