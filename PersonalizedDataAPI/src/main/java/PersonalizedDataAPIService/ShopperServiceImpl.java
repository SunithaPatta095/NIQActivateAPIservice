package PersonalizedDataAPIService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import PersonalizedDataAPIEntity.Shopper;
import PersonalizedDataAPIRepository.ShopperRepository;

@Service
public class ShopperServiceImpl implements ShopperService {

	private final ShopperRepository shopperRepository;

	@Autowired
	public ShopperServiceImpl(ShopperRepository shopperRepository) {
		this.shopperRepository = shopperRepository;
	}

	@Override
	public Shopper createShopper(Shopper shopper) {
		return shopperRepository.save(shopper);
	}

	public Shopper saveShopperPersonalizedProductList(Shopper shopper) {
		Shopper productList = saveShopperPersonalizedProductList(shopper);
		return shopperRepository.save(productList);
	}

}
