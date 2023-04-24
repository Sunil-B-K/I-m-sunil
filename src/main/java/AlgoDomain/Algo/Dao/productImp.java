package AlgoDomain.Algo.Dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import AlgoDomain.Algo.entity.Aproduct;
import AlgoDomain.Algo.entity.Category;
import AlgoDomain.Algo.entity.Categorys;
import AlgoDomain.Algo.entity.Charges;
import jakarta.persistence.EntityManager;

@Repository
    public class productImp implements Product{
	
	private Map<String, Category> categories;

    void productImp() {
        categories = new HashMap<>();
        categories.put("Electronics", new Category("Electronics", 0.15, 0.18, 350));
        categories.put("Home Appliances", new Category("Home Appliances", 0.22, 0.24, 800));
        categories.put("Clothing", new Category("Clothing", 0.4, 0.12, 0));
        categories.put("Furniture", new Category("Furniture", 0.1, 0.18, 300));
}
   EntityManager eman;
    @Autowired
	public productImp(EntityManager eman) {
	super();
	this.eman=eman;
}
	@Override
	public List<Aproduct> getProduct() {
		Session sess=eman.unwrap(Session.class);
	Query<Aproduct> que=	sess.createQuery("from Aproduct",Aproduct.class);
	List<Aproduct> plist=    que.getResultList();
	return plist;
   }
	
	public Categorys getProducts(int productid) {
		Session sess=eman.unwrap(Session.class);
      Aproduct p=sess.get(Aproduct.class,productid);// same to category
        //Category d= (Category) sess.createQuery(" from Category  where p.get(Category.class)="+productid);
   //Category d=sess.p.get(Category.class,productcategory);
         
		//d.getDiscount();
   // d.getGst();
  
    
   
//calculate final price
      Categorys s =new Categorys();
  // Category d = p.get(Category.productcategory().getCategoryName());
    double discount =  0.15 * p.getProductprice();// (d.getDiscount()/100)
    double gst = 0.18 * (p.getProductprice() - discount);// (d.getGst()/100)
    double deliverycharge =  350;  //d.getDeliveryCharge();                // ;
    double finalPrice = p.getProductprice() - discount + gst + deliverycharge;
    s.setProductId(p.getProductid());
    s.setName(p.getProductname());
    s.setProductType(p.getProducttype());
  
     s.setCategory(p.getProductcategory());
     s.setBasePrice(p.getProductprice());
     
    s.setDiscount(discount);
    s.setCharges(new Charges(gst, deliverycharge));
    s.setFinalPrice(finalPrice);
//crreate Categories object and instert values 
    
//return ctargories object
     return s;
	}
	
	
	@Override
	public void delproduct(int productid) {
		Session sess=eman.unwrap(Session.class);
		Query<Aproduct> del=	 sess.createQuery(" delete from Aproduct where productid ="+productid);
      del.executeUpdate();
		
	}
	
	@Override
	public void insert(Aproduct aproduct) {
		Session sess=eman.unwrap(Session.class);
		sess.persist(aproduct);
		}
	
	@Override
	public void update( Aproduct aproduct) {
		Session sess=eman.unwrap(Session.class);
	    sess.persist(aproduct);
		}
	
		/*
		 * public Categorys calculatePrice(Categorys product) { Category category =
		 * categories.get(product.getCategory().productcategory()); double discount =
		 * category.getDiscount() * product.getBasePrice(); double gst =
		 * category.getGst() * (product.getBasePrice() - discount); double
		 * deliveryCharge = category.getDeliveryCharge(); double finalPrice =
		 * product.getBasePrice() - discount + gst + deliveryCharge;
		 * 
		 * product.setDiscount(discount); product.setCharges(new Charges(gst,
		 * deliveryCharge)); product.setFinalPrice(finalPrice);
		 * 
		 * 
		 * return product; }
		 */
}



