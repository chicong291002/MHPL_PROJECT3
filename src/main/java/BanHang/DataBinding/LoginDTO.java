package BanHang.DataBinding;

import jakarta.validation.constraints.NotBlank;

public class LoginDTO {
	@NotBlank(message = "Không được bỏ trống")
	private String UserName;

	@NotBlank(message = "Không được bỏ trống")
	private String Password;

	@NotBlank(message = "Không được bỏ trống")
	private String fullName;

	@NotBlank(message = "Không được bỏ trống")
	private String address;

	@NotBlank(message = "Không được bỏ trống")
	private String city;

	public LoginDTO() {

	}

	public String getUserName() {
		return UserName;
	}

	public String getPassword() {
		return Password;
	}

	public String getFullName() {
		return fullName;
	}

	public String getAddress() {
		return address;
	}

	public String getCity() {
		return city;
	}

	public void setUserName(String userName) {
		this.UserName = userName;
	}

	public void setPassword(String password) {
		this.Password = password;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setCity(String city) {
		this.city = city;
	}
}
