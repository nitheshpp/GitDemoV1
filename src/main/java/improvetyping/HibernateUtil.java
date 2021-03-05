package improvetyping;

import org.hibernate.SessionFactory;

//dont bother about the details of the code except ok we got a session factory object
// finally we ar etelling ehy sessionfactory I dont need you.
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {
	private static SessionFactory sessionFactory = buildSessionFactory();

	private static SessionFactory buildSessionFactory() 
	{
		try 
		{
			if (sessionFactory == null) 
			{
				StandardServiceRegistry standardRegistry = new StandardServiceRegistryBuilder()
						.configure("hibernate.cfg.xml").build();
				
				Metadata metaData = new MetadataSources(standardRegistry)
						.getMetadataBuilder()
						.build();
				
				sessionFactory = metaData.getSessionFactoryBuilder().build();
			}
			return sessionFactory;
		} catch (Throwable ex) {
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public static void shutdown() {
		getSessionFactory().close();
	}
}