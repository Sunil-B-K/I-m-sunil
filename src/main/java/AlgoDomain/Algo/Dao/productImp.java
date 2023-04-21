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
	// TODO Auto-generated constructor stub
}
	@Override
	public List<Aproduct> getProduct() {
		Session sess=eman.unwrap(Session.class);
	Query<Aproduct> que=	sess.createQuery("from Aproduct",Aproduct.class);
	List<Aproduct> plist=    que.getResultList();
	return plist;
	
	}
	
	public Categorys getOneData(int productid) {
		// TODO Auto-generated method stub
		Session sess=eman.unwrap(Session.class);
      Aproduct p=sess.get(Aproduct.class,productid);// same to category
         Category d= (Category) sess.createQuery(" from Category  where p.Category="+productid);
    //Category d=sess.get(Category.class,productcategory);
         
		//d.getDiscount();
   // d.getGst();
  
//fetch the data from discount table based on p.categoty
    
   
//calculate final price
    Categorys s =new Categorys();
    //Category category = categories.get(p.getCategory().productcategory());
    double discount =  (d.getDiscount()/100) * p.getProductprice();//0.15
    double gst =  (d.getGst()/100)* (p.getProductprice() - discount);//
    double deliverycharge =  d.getDeliveryCharge();
    double finalPrice = p.getProductprice() - discount + gst + deliverycharge;
   // s.setProductId(p.getProductid());
    //s.setName(p.getProductname());
  //  s.setProductType(p.getProducttype());
  // s.setCategory(p.getProductcategory());
   //  s.setBasePrice(p.getProductprice());
     
    s.setDiscount(discount);
    s.setCharges(new Charges(gst, deliverycharge));
    s.setFinalPrice(finalPrice);
//crreate Categories object and instert values 
    
//return ctargories object
     return s;
	}
	private Object getproductcategory() {
		// TODO Auto-generated method stub
		return null;
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
	 * public static int getBasePrice() { // TODO Auto-generated method stub return
	 * 0; }
	 */
	
	
   	 
       
	/*
	 * @Override public Categorys calculatePrice(Categorys cast) { Category category
	 * = categories.get(cast.getCategory().productcategory()); double discount =
	 * category.getDiscount() * cast.getBasePrice(); double gst = category.getGst()
	 * * (cast.getBasePrice() - discount); double deliveryCharge =
	 * category.getDeliveryCharge(); double finalPrice = cast.getBasePrice() -
	 * discount + gst + deliveryCharge;
	 * 
	 * cast.setDiscount(discount); cast.setCharges(new Charges(gst,
	 * deliveryCharge)); cast.setFinalPrice(finalPrice);
	 * 
	 * 
	 * return cast; }
	 */
	
	
	
   	 
    

		
	}



