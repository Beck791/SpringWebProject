package tw.leonchen.model;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringJavaConfig {

	@Bean
	public Person person7() {
		Person p1 = new Person();
		p1.setAge(20);
		return p1;
	}

	@Bean
	public Worker worker3() {
		Worker worker = new Worker();
		worker.setId(1005);
		worker.setName("Alex");
		worker.setTitle("Sales");
		return worker;
	}

	@Bean
	public WorkerDAO workerDao2() {
		return new WorkerDAO(worker3());
	}

}
