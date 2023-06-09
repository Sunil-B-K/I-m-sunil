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
import io.swagger.annotations.ApiOperation;
@RestController
@RequestMapping("/api1")
public class PrestController {
	 
	Product pd;
     @Autowired
	public PrestController(Product pd) {
		super();
		this.pd = pd;
	}
     @ApiOperation(value = "/map")
     @GetMapping(value="/map")
     public List<Aproduct> getProduct(){ 
		return pd.getProduct();
    	 
     }
     

     @ApiOperation(value = "/one/{@ApiParam}")
     @GetMapping(value="/one/{productid}")
     public Categorys getProducts(@PathVariable int productid) {
    	 return pd.getProducts(productid);
			  
     }
     
     @ApiOperation(value = "/del/{@ApiParam}")
     @Transactional
     @GetMapping(value="/del/{productid}")
 	public void delproduct(@PathVariable int productid) {
 		pd.delproduct(productid);
 	}
     
     @ApiOperation("/Aproducts")
     @Transactional
     @GetMapping("/Aproducts")
     public void insert(@RequestBody Aproduct aproduct) {
    	 pd.insert(aproduct);
     }
     
     @ApiOperation("/update")
     @Transactional
     @PutMapping("/update")
     public void update( @RequestBody Aproduct aproduct) {
    	 pd.update(aproduct);
     }
     
		/*
		 * @GetMapping(value="/one/{product}") public Categorys
		 * getProductsy(@RequestBody Categorys product) { return pd.
		 * calculatePrice(product);
		 * 
		 * }
		 */
      
    	     
}
