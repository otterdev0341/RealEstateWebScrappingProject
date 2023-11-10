package collectPrice;

public class AssestPrice {

	private String id;
	private String price;
	
	//contructor
	public AssestPrice()
	{
		
	}
	
	public AssestPrice(String id, String price) {
		super();
		this.id = id;
		this.price = price;
	}
	//setter getter

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}
	//to string method
	@Override
	public String toString() {
		return "AssestPrice [id=" + id + ", price=" + price + "]";
	}
	
	
	
	
	
}
