package project.mvc.model;
import java.io.Serializable;

public class Reservation {
	private String bookName;
	private String userLogin;
	
	public Reservation() {
		
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getUserLogin() {
		return userLogin;
	}

	public void setUserLogin(String userLogin) {
		this.userLogin = userLogin;
	}
}
