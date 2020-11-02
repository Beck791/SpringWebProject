package tw.leonchen.util;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.web.context.WebApplicationContext;

public class OpenSessionViewFilter implements Filter {


	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
//	String sessionFactoryBaseName = filterConfig.getInitParameter("sessionFactoryBeanName");
//	ServletContext application = filterConfig.getServletContext();
//    context = WebApplicationContextUtils.getWebApplicationContext(application);
//	sessionFactory = (SessionFactory)context.getBean(sessionFactoryBaseName); 
	
	
	}
	
	
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		try {
			session.beginTransaction();
			System.out.println("Transaction Begin.");
			chain.doFilter(request, response);   
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
			System.out.println("Transaction RollBack.");
			chain.doFilter(request, response);
		} finally {
			System.out.println("Session Closed.");
		}

	}
	
//	try {
//		sessionFactory.getCurrentSession().beginTransaction();
//		System.out.println("Transaction Begin.");
//		chain.doFilter(request, response);   
//		sessionFactory.getCurrentSession().getTransaction().commit();
//	} catch (Exception e) {
//		sessionFactory.getCurrentSession().getTransaction().rollback();
//		e.printStackTrace();
//		System.out.println("Transaction RollBack.");
//		chain.doFilter(request, response);
//	} finally {
//		System.out.println("Session Closed.");
//	}
//	
//}

	@Override
	public void destroy() {
	}


}
