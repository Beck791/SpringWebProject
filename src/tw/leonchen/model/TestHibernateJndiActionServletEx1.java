package tw.leonchen.model;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

@WebServlet("/TestHibernateJndiActionServletEx1")
public class TestHibernateJndiActionServletEx1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private WebApplicationContext context;

	public void init() {
		ServletContext application = this.getServletContext();
		context = WebApplicationContextUtils.getWebApplicationContext(application);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		try {
			HouseService houseService = (HouseService) context.getBean("houseService");
			House hbean = houseService.select(1001);
			out.println("id1:" + hbean.getHouseid() + "<br/>");
			out.println("name1:" + hbean.getHousename() + "<br/>");
		} catch (Exception e) {

		} finally {
			System.out.println("Done");
//			((ConfigurableApplicationContext)context).close();  
			out.close();
		}
	}

//	protected void doPost(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//
//		doGet(request, response);
//	}

}
