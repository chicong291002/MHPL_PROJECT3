package BanHang.DataBinding;

import jakarta.validation.constraints.NotBlank;

public class RegisterDTO {
	@NotBlank(message = "Không được bỏ trống")
	private String userName;

	@NotBlank(message = "Không được bỏ trống")
	private String password;

	@NotBlank(message = "Không được bỏ trống")
	private String fullName;

	@NotBlank(message = "Không được bỏ trống")
	private String address;

	@NotBlank(message = "Không được bỏ trống")
	private String city;

	public RegisterDTO() {

	}

	public String getUserName() {
		return userName;
	}

	public String getPassword() {
		return password;
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
		this.userName = userName;
	}

	public void setPassword(String password) {
		this.password = password;
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
