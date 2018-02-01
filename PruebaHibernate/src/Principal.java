import org.hibernate.Session;

public class Principal {

	public static void main(String[] args) {
		
		//Abrimos una sesi�n con Hibernate en la que se conectar� a MySQL con el
		//usuario y contrase�a indicados en el hibernate.cfg.xml
		Session session = HibernateUtilities.getSessionFactory().openSession();
		
		//Creamos un nuevo usuario
		session.beginTransaction();
		Usuario u = new Usuario("Josevi");
		session.save(u);
		session.getTransaction().commit();	
		
		//Cerramos la sesi�n 
		session.close();

	}

}
