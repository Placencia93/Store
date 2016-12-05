package FakeStore;


public class HistoryEntry {

	String name;
	int quantity;
	double total;
	int id;

	HistoryEntry(String name, int quantity, double total, int id){
		this.name = name;
		this.quantity = quantity;
		this.total = total;
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
