package AlgoDomain.Algo.Dao;

import java.util.List;

import AlgoDomain.Algo.entity.Aproduct;
import AlgoDomain.Algo.entity.Categorys;

public interface Product {
	List<Aproduct>getProduct();
	Categorys getProducts(int productid);
	void delproduct(int productid);
	void insert(Aproduct aproduct);
	void update(Aproduct aproduct);
	//static void setDiscount(double discount) 
		// TODO Auto-generated method stub
	//Categorys calculatePrice(Categorys product);
	
	
		
	
}



