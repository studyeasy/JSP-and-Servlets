package org.studyeasy.hibernate.DOA;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.studyeasy.hibernate.entities.Image;

public class DAO {

	SessionFactory factory = new Configuration()
			                 .configure("hibernate.cfg.xml")
			                 .addAnnotatedClass(Image.class)
			                 .buildSessionFactory();
	public void addImageDetails(Image image) {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		session.save(image);
		session.getTransaction().commit();
		System.out.println(image.getFileName()+" Added into database");
		
	}
		
	
	public void closeConnection() {
		factory.close();
	}
	
}
