
import java.util.ArrayList;

import org.hibernate.Session;

public class Principal {

	public static void main(String[] args) {
		
		/*

		// Abrimos una sesión con Hibernate en la que se conectará a MySQL con el
		// usuario y contraseña indicados en el hibernate.cfg.xml
		Session session = HibernateUtilities.getSessionFactory().openSession();

		
		//INSERTAR DATOS EN LA BBDD
		//Creamos una nueva empresa
		session.beginTransaction();
		
		//Insertamos valores en el objeto Empresa
		Empresa empresa1 = new Empresa("Indenova");
		empresa1.setCIF("B96195456");
		empresa1.setDireccion("C/Mayor, 21 Valencia");
		empresa1.setEmpleados(4);
		//Insertamos valores en el objeto Pedido
		//*La fecha la crea el propio constructor
		//*El id se generará autoincrementalmente
		Pedido pedido1 = new Pedido();
		//Insertamos valores en el objeto Item
		//*El id se generará autoincrementalmente
		Item item1 = new Item("Tuerca 8mm");
		item1.setCantidad(100);
		
		//Guardamos la sesión para cada uno de los objetos
		session.save(empresa1);
		session.save(pedido1);
		session.save(item1);
		session.getTransaction().commit();
		

		
		//RECUPERAR DATOS DE LA BBDD
		session.beginTransaction();
		
		//Empresa empresa1 = session.get(Empresa.class, 1);
		//Pedido pedido1 = session.get(Pedido.class, 1);
		Item item1 = session.get(Item.class, 1);
		
		//System.out.println(empresa1.toString());
		//System.out.println(pedido1.toString());
		//System.out.println(item1.toString());
		System.out.println("Hemos recuperado el item llamado: " + item1.getNombre());
		
		session.getTransaction().commit();
		
		
		// Cerramos la sesión
		session.close();
		HibernateUtilities.getSessionFactory().close();

		*/
		
		// Abrimos una sesión con Hibernate en la que se conectará a MySQL con el
		// usuario y contraseña indicados en el hibernate.cfg.xml
		Session session = HibernateUtilities.getSessionFactory().openSession();

		// INSERTAR DATOS EN LA BBDD
		session.beginTransaction();
		
		// Insertamos valores en el objeto Empresa
		Empresa empresa1 = new Empresa("Indenova");
		empresa1.setCIF("B96195456");
		empresa1.setDireccion("C/Mayor, 21 Valencia");
		empresa1.setEmpleados(4);

		// Insertamos valores en el objeto Pedido
		// *La fecha la crea el propio constructor
		// *El id se generará autoincrementalmente
		Pedido pedido1 = new Pedido();
		// Insertamos valores en el objeto Item
		// *El id se generará autoincrementalmente
		pedido1.getMisItems().add(new Item("Tuerca 8mm", 100));
		pedido1.getMisItems().add(new Item("Maza 100cm", 10));
		
		session.save(empresa1);
		session.save(pedido1);
		
		session.getTransaction().commit();
		
		//RECUPERAR DATOS DE LA BBDD
		session.beginTransaction();
		Empresa empresa1Recuperada = session.get(Empresa.class, "B96195456");
		Pedido pedido1Recuperado = session.get(Pedido.class, 1);
		System.out.println("Empresa recuperada:");
		System.out.println(empresa1Recuperada.getNombre());
		System.out.println("");
		System.out.println("Pedido recuperado:");
		System.out.println(pedido1Recuperado.getFecha());
		//ArrayList<Item> listaItem = new ArrayList<Item> ();
		///listaItem = (ArrayList<Item>) pedido1Recuperado.getMisItems();
		for(Item item: pedido1Recuperado.getMisItems()) {
			
			System.out.println("Pedido: " +item.getNombre() + "Cantidad solicitada: " + item.getCantidad());
		}
		
		session.getTransaction().commit();
		
		session.close();	
		
		HibernateUtilities.getSessionFactory().close();

	}

}
