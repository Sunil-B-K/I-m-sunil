package AlgoDomain.Algo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Category {
	@Id
	 private String productcategory;
	    private double discount;
	    private double gst;
	    private double deliverycharge;
		public Category() {
			super();
			// TODO Auto-generated constructor stub
		}
		public Category(String productcategory, double discount, double gst, double deliverycharge) {
			super();
			this.productcategory = productcategory;
			this.discount = discount;
			this.gst = gst;
			this.deliverycharge = deliverycharge;
		}
		public String productcategory() {
			return productcategory;
		}
		public void setCategoryName(String productcategory) {
			this.productcategory = productcategory;
		}
		public double getDiscount() {
			return discount;
		}
		public void setDiscount(double discount) {
			this.discount = discount;
		}
		public double getGst() {
			return gst;
		}
		public void setGst(double gst) {
			this.gst = gst;
		}
		public double getDeliveryCharge() {
			return deliverycharge;
		}
		public void setDeliveryCharge(double deliveryCharge) {
			this.deliverycharge = deliveryCharge;
		}
		@Override
		public String toString() {
			return "Category [productcategory=" + productcategory + ", discount=" + discount + ", gst=" + gst
					+ ", deliverycharge=" + deliverycharge + "]";
		}
		
		
	    

}
