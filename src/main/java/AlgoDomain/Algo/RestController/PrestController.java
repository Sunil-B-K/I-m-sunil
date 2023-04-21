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
     public Categorys getProducts(@PathVariable int productid) {
    	 return pd.getProducts(productid);
			  
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
