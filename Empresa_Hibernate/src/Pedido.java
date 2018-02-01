import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Pedido {
	
	private int id;
	private Date fecha;
	private List <Item> misItems = new ArrayList<Item>();
	
	
	//Constructor de la clase
	public Pedido() {
		
		Calendar calendar = Calendar.getInstance();
		Date date =  calendar.getTime();
		fecha = date;
	}



	//Métodos setter y getter
	public List<Item> getMisItems() {
		return misItems;
	}

	public void setMisItems(List<Item> misItems) {
		this.misItems = misItems;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getFecha() {
		return fecha;
	}
	
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

}

