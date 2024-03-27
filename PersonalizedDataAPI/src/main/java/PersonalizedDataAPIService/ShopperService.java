package PersonalizedDataAPIService;

import PersonalizedDataAPIEntity.Shopper;

public interface ShopperService {

	public Shopper createShopper(Shopper shopper);

	public Shopper saveShopperPersonalizedProductList(Shopper productList);

}
