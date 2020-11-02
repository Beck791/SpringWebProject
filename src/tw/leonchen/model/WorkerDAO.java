package tw.leonchen.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository("workerDao")
public class WorkerDAO {
	

	private Worker worker;

	public WorkerDAO() {
		
	}
	@Autowired(required = false)
	public WorkerDAO( @Qualifier("worker2")Worker worker) {
		this.worker = worker;
	}

	public void printResult() {
		System.out.println("id:" +worker.getId());
		System.out.println("Name:" +worker.getName());
		System.out.println("Title:" +worker.getTitle());
	}
	
}
