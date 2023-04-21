package AlgoDomain.Algo.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import AlgoDomain.Algo.Dao.Product;
import AlgoDomain.Algo.Dao.productImp;
import AlgoDomain.Algo.entity.Aproduct;
import AlgoDomain.Algo.entity.Category;
import AlgoDomain.Algo.entity.Categorys;
@RestController
@RequestMapping("/api1")
public class PrestController {
	 /*private final Map<String, Double> categoryDiscounts = new HashMap<>();
	    private final Map<String, Double> categoryGST = new HashMap<>();
	    private final Map<String, Double> categoryDeliveryCharges = new HashMap<>();
	    public void ProductController() {
	        // initialize discount, GST, and delivery charges for each category
	        categoryDiscounts.put("Electronics", 0.15);
	        categoryDiscounts.put("Home Appliances", 0.22);
	        categoryDiscounts.put("Clothing", 0.40);
	        categoryDiscounts.put("Furniture", 0.10);

	        categoryGST.put("Electronics", 0.18);
	        categoryGST.put("Home Appliances", 0.24);
	        categoryGST.put("Clothing", 0.12);
	        categoryGST.put("Furniture", 0.18);

	        categoryDeliveryCharges.put("Electronics", 350.0);
	        categoryDeliveryCharges.put("Home Appliances", 800.0);*/
	       // categoryDeliveryCharges.put("Clothing", 0.0);
	       // categoryDeliveryCharges.put("Furniture", 300.0);
	    //}
	Product pd;
     @Autowired
	public PrestController(Product pd) {
		super();
		this.pd = pd;
	}
     @GetMapping(value="/map")
     public List<Aproduct> getProduct(){ 
		return pd.getProduct();
    	 
     }
     

     
     @GetMapping(value="/one/{productid}")
     public Categorys getOneData(@PathVariable int productid) {
    	 return pd.getOneData(productid);
			  
     }
     
     @Transactional
     @GetMapping(value="/del/{productid}")
 	public void delproduct(@PathVariable int productid) {
 		pd.delproduct(productid);
 	}
     
     @Transactional
     @GetMapping("/Aproducts")
     public void insert(@RequestBody Aproduct aproduct) {
    	 pd.insert(aproduct);
     }
     
     @Transactional
     @PutMapping("/update")
     public void update( @RequestBody Aproduct aproduct) {
    	 pd.update(aproduct);
     }
    	 
    	     
}
