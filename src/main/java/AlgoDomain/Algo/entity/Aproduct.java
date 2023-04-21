package AlgoDomain.Algo.entity;

import org.springframework.beans.factory.annotation.Autowired;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Aproduct {
	@Id
	int productid;
	String productname;
	String producttype;
	String productcategory;
	int productprice;
	public Aproduct() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Aproduct(int productid, String productname, String producttype, String productcategory, int productprice) {
		super();
		this.productid = productid;
		this.productname = productname;
		this.producttype = producttype;
		this.productcategory = productcategory;
		this.productprice = productprice;
	}
	public int getProductid() {
		return productid;
	}
	public void setProductid(int productid) {
		this.productid = productid;
	}
	public String getProductname() {
		return productname;
	}
	public void setProductname(String productname) {
		this.productname = productname;
	}
	public String getProducttype() {
		return producttype;
	}
	public void setProducttype(String producttype) {
		this.producttype = producttype;
	}
	public String getProductcategory() {
		return productcategory;
	}
	public void setProductcategory(String productcategory) {
		this.productcategory = productcategory;
	}
	public int getProductprice() {
		return productprice;
	}
	public void setProductprice(int productprice) {
		this.productprice = productprice;
	}
	@Override
	public String toString() {
		return "Aproduct [productid=" + productid + ", productname=" + productname + ", producttype=" + producttype
				+ ", productcategory=" + productcategory + ", productprice=" + productprice + "]";
	}
	/*
	 * //public static void setDiscount(double discount) { // TODO Auto-generated
	 * method stub
	 * 
	 * } public static void setCharges(Charges charges) { // TODO Auto-generated
	 * method stub
	 * 
	 * }
	 */

}
