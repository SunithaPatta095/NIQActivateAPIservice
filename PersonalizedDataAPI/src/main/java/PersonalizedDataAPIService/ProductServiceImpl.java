package PersonalizedDataAPIService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import PersonalizedDataAPIEntity.Product;
import PersonalizedDataAPIRepository.ProductRepository;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

	private final ProductRepository productRepository;

	@Autowired
	public ProductServiceImpl(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	@Override
	public Product createProduct(Product product) {
		return productRepository.save(product);
	}

	@Override
	public Product saveProductMetadata(Product product) {
		return productRepository.save(product);
	}

	@Override
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

	public List<Product> findByShopperIdAndFilters(String shopperId, String category, String brand, int limit) {
		List<Product> products;
		if (category != null && brand != null) {
			products = productRepository.findByShopperIdAndCategoryAndBrand(shopperId, category, brand, limit);
		} else if (category != null) {
			products = productRepository.findByShopperIdAndCategory(shopperId, category, limit);
		} else if (brand != null) {
			products = productRepository.findByShopperIdAndBrand(shopperId, brand, limit);
		} else {
			products = productRepository.findByShopperId(shopperId, limit);
		}
		// limit
		if (limit > 0 && limit < products.size()) {
			return products.subList(0, limit);
		} else {
			return products;
		}
	}

}
