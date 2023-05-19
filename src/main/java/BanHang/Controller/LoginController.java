package BanHang.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import BanHang.DataBinding.LoginDTO;
import BanHang.Entity.Customer;
import BanHang.Service.ICustomerService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class LoginController {
	private final ICustomerService _customerService;

	public LoginController(ICustomerService customerService) {
		_customerService = customerService;
	}

	@RequestMapping(value = "/dang-nhap", method = RequestMethod.GET)
	public String Index(Model model, HttpSession session) {
		model.addAttribute("login", new LoginDTO());
		Customer isLogin = (Customer) session.getAttribute("customer");
		if (isLogin != null) {
			return "redirect:/";
		}
		return "Login/login";
	}

	@RequestMapping(value = "/dang-nhap", method = RequestMethod.POST)
	public String Login(HttpSession session, @ModelAttribute("login") @Valid LoginDTO login, BindingResult result,
			Model model) {
		Customer customer = new Customer();
		customer = _customerService.Login(login.getUserName(), login.getPassword());
		if (customer == null) {
			model.addAttribute("loginError", "Sai tài khoản hoặc mật khẩu");
			return "Login/login";
		}
		session.setAttribute("customer", customer);
		return "redirect:/home";
	}

	@RequestMapping(value = "/dang-xuat", method = RequestMethod.GET)
	public String Logout(HttpSession session) {
		if (session.getAttribute("customer") == null) {
			return "redirect:/";
		}
		session.removeAttribute("customer");
		return "redirect:/dang-nhap";
	}
}
