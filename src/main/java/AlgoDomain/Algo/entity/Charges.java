package AlgoDomain.Algo.entity;

public class Charges {
	private double gst;
    private double delivery;
	public Charges() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Charges(double gst, double delivery) {
		super();
		this.gst = gst;
		this.delivery = delivery;
	}
	public double getGst() {
		return gst;
	}
	public void setGst(double gst) {
		this.gst = gst;
	}
	public double getDelivery() {
		return delivery;
	}
	public void setDelivery(double delivery) {
		this.delivery = delivery;
	}
	@Override
	public String toString() {
		return "Charges [gst=" + gst + ", delivery=" + delivery + "]";
	}
    
}
