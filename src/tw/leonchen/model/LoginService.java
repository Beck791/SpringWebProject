package tw.leonchen.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "lgService")
public class LoginService {
	
	@Autowired
	private LoginDAO loginDao;

	public LoginService() {
		
	}
	
	public LoginService(LoginDAO loginDao) {
		this.loginDao = loginDao;
	}
	

	public void setLoginDao(LoginDAO loginDao) {
		this.loginDao = loginDao;
	}

	public boolean cheackLogin(String user, String pwd) {
		return loginDao.cheackLogin(user, pwd);
	}
}
