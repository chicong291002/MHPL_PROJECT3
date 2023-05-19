package BanHang.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import BanHang.DataBinding.RegisterDTO;
import BanHang.Service.ICustomerService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class RegisterController {
	private final ICustomerService _customerService;

	public RegisterController(ICustomerService customerService) {
		_customerService = customerService;
	}

	@GetMapping("/dang-ky")
	public String Index(HttpSession session, Model model) {

		model.addAttribute("register", new RegisterDTO());

		if (session.getAttribute("customer") != null) {
			return "redirect:/";
		}

		return "Register/register";
	}

	@PostMapping("/dang-ky")
	public String Register(HttpSession session, @ModelAttribute("register") @Valid RegisterDTO register,
			BindingResult result, Model model) {

		if (result.hasErrors()) {
			return "Register/register";
		}
		Integer checkRegister = _customerService.Register(register);
		if (checkRegister == 1) {
			model.addAttribute("Success", "Tạo tài khoản thành công !");
			return "Register/register";
		}
		if (checkRegister == 0) {
			model.addAttribute("modelError", "Tên tài khoản đã tồn tại !");
			return "Register/register";
		}
		return "redirect:/dang-nhap";
	}
}
