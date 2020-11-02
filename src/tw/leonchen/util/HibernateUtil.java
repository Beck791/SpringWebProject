package tw.leonchen.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {
	/*?��?��createSessionFactory()，�?��?��?�static屬�??*/
	private static final SessionFactory factory = createSessionFactory();

	/* ?��??�Session?���? */
	private static SessionFactory createSessionFactory() {
		StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure().build(); // 註�?�service
		SessionFactory factory = new MetadataSources(serviceRegistry).buildMetadata().buildSessionFactory(); // ??��?��?��?�庫?���?
		return factory;
	}
	/*?��??�產??��?次SessisonFactory?��件�?��?�部?��?��call?��法�?�用new;記憶體�?�置?���?*/
	public static SessionFactory getSessionFactory() {
		return factory;
	}

	public static void closeSessionFactory() {
		if (factory != null) {
			factory.close();
		}
	}
}
