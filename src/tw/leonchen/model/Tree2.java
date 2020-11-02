package tw.leonchen.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("tree2")
@Scope("singleton")
@PropertySource("classpath:tree.properties")
public class Tree2 {
	
	@Value("${name}")
	private String name;
	
	@Value("${age}")
	private int age;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}
