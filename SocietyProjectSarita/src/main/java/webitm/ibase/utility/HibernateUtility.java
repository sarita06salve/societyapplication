package webitm.ibase.utility;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import webitm.ibase.model.*;

public class HibernateUtility 
{
	private static SessionFactory sessionFactory = null;
	
	public static SessionFactory getSessionFactory()
	{
		Configuration configuration = new Configuration();
		Properties properties = new Properties();
		try
		{
			if(sessionFactory == null)
			{
				properties.put(Environment.DRIVER, "com.mysql.jdbc.Driver");
				properties.put(Environment.URL, "jdbc:mysql://localhost:3306/sarita");
				properties.put(Environment.USER, "root");
				properties.put(Environment.PASS, "root");
				properties.put(Environment.HBM2DDL_AUTO, "update");
				properties.put(Environment.SHOW_SQL, "true");
				properties.put(Environment.DIALECT, "org.hibernate.dialect.MySQLDialect");
				configuration.addAnnotatedClass(SocietyCommitteeMember.class);
				configuration.addAnnotatedClass(SocietyMember.class);
				configuration.addAnnotatedClass(Vehicle.class);
				configuration.addAnnotatedClass(JointMember.class);
				configuration.addAnnotatedClass(IncomeVoucher.class);
				configuration.addAnnotatedClass(ExpenseVoucher.class);
				configuration.addAnnotatedClass(Visitors.class);
				
				sessionFactory = configuration.setProperties(properties).buildSessionFactory();
			}
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}	
		return sessionFactory;
	}
}
