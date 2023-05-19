package BanHang.Service;

import org.springframework.stereotype.Service;

import BanHang.DataBinding.RegisterDTO;
import BanHang.Entity.Customer;

@Service
public interface ICustomerService {
	public Customer Login(String userName,String passWord);
	public Integer Register(RegisterDTO customer);
}
