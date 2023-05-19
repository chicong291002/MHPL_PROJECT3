package BanHang.Service;

import org.springframework.stereotype.Service;

import BanHang.DataBinding.RegisterDTO;
import BanHang.Entity.Customer;
import BanHang.Repository.CustomersRepository;
import jakarta.transaction.Transactional;

@Service
public class CustomerService implements ICustomerService {

	private final CustomersRepository _customersRepository;

	public CustomerService(CustomersRepository _customersRepository) {
		this._customersRepository = _customersRepository;
	}

	public Customer Login(String userName, String passWord) {
		return _customersRepository.findByUserNameAndPassword(userName, passWord);
	}

	@Transactional
	public Integer Register(RegisterDTO customer) {
		Customer check_customer = _customersRepository.findByUserName(customer.getUserName());
		if (check_customer != null) {
			return 0;
		}
		Customer cus = new Customer();
		cus.setUserName(customer.getUserName());
		cus.setPassword(customer.getPassword());
		cus.setAddress(customer.getAddress());
		cus.setCity(customer.getCity());
		cus.setFullName(customer.getFullName());
		_customersRepository.save(cus);
		return 1;
	}
}
