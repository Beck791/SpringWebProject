package tw.leonchen.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {
	/*?‘¼?«createSessionFactory()ï¼Œå?å?‹å?–staticå±¬æ??*/
	private static final SessionFactory factory = createSessionFactory();

	/* ?”¢??ŸSession?‰©ä»? */
	private static SessionFactory createSessionFactory() {
		StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure().build(); // è¨»å?Šservice
		SessionFactory factory = new MetadataSources(serviceRegistry).buildMetadata().buildSessionFactory(); // ??–å?—è?‡æ?™åº«?‰©ä»?
		return factory;
	}
	/*?ª??ƒç”¢??Ÿä?æ¬¡SessisonFactory?‰©ä»¶ï?Œå?–éƒ¨?›´?¥call?–¹æ³•ä?ç”¨new;è¨˜æ†¶é«”ä?ç½®?”¯ä¸?*/
	public static SessionFactory getSessionFactory() {
		return factory;
	}

	public static void closeSessionFactory() {
		if (factory != null) {
			factory.close();
		}
	}
}
