package project.mvc.model;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

public class Reservation {
	private String bookName;
	private String userLogin;
	private String date;
	
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

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

}
