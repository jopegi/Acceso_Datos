import org.hibernate.Session;

public class Principal {

	public static void main(String[] args) {
		
		//Abrimos una sesión con Hibernate en la que se conectará a MySQL con el
		//usuario y contraseña indicados en el hibernate.cfg.xml
		Session session = HibernateUtilities.getSessionFactory().openSession();
		
		//Creamos un nuevo usuario
		session.beginTransaction();
		Usuario u = new Usuario("Josevi");
		session.save(u);
		session.getTransaction().commit();	
		
		//Cerramos la sesión 
		session.close();

	}

}
