package phonebook;

public class PhoneBookInfo {

	private String number;
	private String name;
	private String email;
	private String address;
	public PhoneBookInfo() {
		number = "";
		name = "";
		email = "";
		address = "";
	}
	public PhoneBookInfo(String n, String n1, String e, String a) {
		number = n;
		name = n1;
		email = e;
		address = a;
	}
	public void setNumber(String n) {
		number = n;
	}
	public void setName(String n) {
		name = n;
	}
	public void setEmail(String e) {
		email = e;
	}
	public void setAddress(String a) {
		address = a;
	}
	public String getNumber() {
		return number;
	}
	public String getName() {
		return name;
	}
	public String getEmail() {
		return email;
	}
	public String getAddress() {
		return address;
	}
}
