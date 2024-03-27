package PersonalizedDataAPIController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import PersonalizedDataAPIEntity.Product;
import PersonalizedDataAPIEntity.Shopper;
import PersonalizedDataAPIService.ProductService;
import PersonalizedDataAPIService.ShopperService;

@RestController
@RequestMapping("/internal")
public class InternalApiController {

	private final ShopperService shopperService;
	private final ProductService productService;

	@Autowired
	public InternalApiController(ShopperService shopperService, ProductService productService) {
		this.shopperService = shopperService;
		this.productService = productService;
	}

	@PostMapping("/internal/shopper")
	public ResponseEntity<?> storeShopperPersonalizedProductList(
			@RequestBody Shopper productList) {
		shopperService.saveShopperPersonalizedProductList(productList);
		return ResponseEntity.ok().build();
	}

	@PostMapping("/internal/product")
	public ResponseEntity<?> storeProductMetadata(@RequestBody Product product) {
		productService.saveProductMetadata(product);
		return ResponseEntity.ok().build();
	}
}
