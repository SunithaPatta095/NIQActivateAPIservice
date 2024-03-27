package PersonalizedDataAPIController;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import PersonalizedDataAPIEntity.Product;
import PersonalizedDataAPIRepository.ProductRepository;
import PersonalizedDataAPIService.ProductService;
import PersonalizedDataAPIService.ShopperService;
//import io.swagger.v3.oas.annotations.Operation;
//import io.swagger.v3.oas.annotations.responses.ApiResponse;

import java.util.List;

@RestController
@RequestMapping("/external/api")
public class ExternalApiController {

	private final ProductRepository productRepository;

	@Autowired
	public ExternalApiController(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

//	@GetMapping("/products")
//	@Operation(summary = "Get products by shopper ID", description = "Fetch products based on shopper ID with optional filters")
//	@ApiResponse(responseCode = "200", description = "Successful retrieval of products")
//	public ResponseEntity<List<Product>> getProductsByShopper(@RequestParam String shopperId,
//			@RequestParam(required = false) String category, @RequestParam(required = false) String brand,
//			@RequestParam(defaultValue = "10") int limit) {
//		List<Product> products = productService.getProductsByShopper(shopperId, category, brand, limit);
//		return new ResponseEntity<>(products, HttpStatus.OK);
//	}

	@GetMapping("/products")
	public List<Product> getProductsByShopper(String shopperId, String category, String brand, int limit) {
		if (category != null && brand != null) {
			return productRepository.findByShopperIdAndCategoryAndBrand(shopperId, category, brand, limit);
		} else if (category != null) {
			return productRepository.findByShopperIdAndCategory(shopperId, category, limit);
		} else if (brand != null) {
			return productRepository.findByShopperIdAndBrand(shopperId, brand, limit);
		} else {
			return productRepository.findByShopperId(shopperId, limit);
		}
	}

}
