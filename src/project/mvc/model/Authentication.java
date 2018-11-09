package project.mvc.model;
import java.io.Serializable;

public class Authentication {
	private String id;
	private String password;
	
	public Authentication() {
		
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getId() {
		return id;
	}

	public String getPassword() {
		return password;
	}
}
