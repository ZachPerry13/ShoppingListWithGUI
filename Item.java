import java.text.DecimalFormat;

public class Item {
	String itemname;
	int quanity;
	double price;
	int priority;
	private static final DecimalFormat df = new DecimalFormat("0.00");
	
	
	public String toString() {
		return itemname + " $" + df.format(price) + " x" + quanity +"\n" ;
	}
	
	public String getItemname() {
		return itemname;
	}
	public void setItemname(String itemname) {
		this.itemname = itemname;
	}
	public int getQuanity() {
		return quanity;
	}
	public void setQuanity(int quanity) {
		this.quanity = quanity;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getPriority() {
		return priority;
	}
	public void setPriority(int priority) {
		this.priority = priority;
	}
	

}
