package tw.leonchen.model;

import java.util.Date;
import java.util.List;

public class Person {

	private String nickName;
	private String role;
	private int age;
	private Date date;
	private List<String> food;
	private String name;

	public Person() {

	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name; 
	}
	
	public Person(Date date) {
		this.date = date;
	}

	public Person(List<String> food) {
		this.food = food;
	}

	public Person(String role, int age) {
		this.role = role;
		this.age = age;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int i) {
		this.age = i;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public List<String> getFood() {
		return food;
	}

	public void setFood(List<String> food) {
		this.food = food;
	}

	public void init() {
		System.out.println("init");
	}
	public void destroy() {
		System.out.println("destroy");
	}
	
}
