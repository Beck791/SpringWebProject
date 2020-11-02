package tw.leonchen.util;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

public class OpenSessionViewFilter implements Filter {

	private SessionFactory sessionFactory;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	String sessionFactoryBaseName = filterConfig.getInitParameter("sessionFactoryBaseName");
	ServletContext application = filterConfig.getServletContext();
	WebApplicationContext context = WebApplicationContextUtils.getRequiredWebApplicationContext(application);
	sessionFactory = (SessionFactory)context.getBean(sessionFactoryBaseName); 
	
	
	}
	
	
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
//		Session session = null;
		try {
			sessionFactory.getCurrentSession().beginTransaction();
			System.out.println("Transaction Begin.");
			chain.doFilter(request, response);   
			sessionFactory.getCurrentSession().getTransaction().commit();
		} catch (Exception e) {
			sessionFactory.getCurrentSession().getTransaction().rollback();
			System.out.println("Transaction RollBack.");
			chain.doFilter(request, response);
		} finally {
			System.out.println("Session Closed.");
		}

	}

	@Override
	public void destroy() {
	}


}
