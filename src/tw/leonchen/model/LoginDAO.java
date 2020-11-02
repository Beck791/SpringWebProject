package tw.leonchen.model;

import org.springframework.stereotype.Component;

@Component(value = "lgDao")
public class LoginDAO {
	public boolean cheackLogin(String user, String pwd) {
		if (user.equals("John") && pwd.equals("test123")) {
			return true;
		}
		return false;

	}

}
