package PersonalizedDataAPIRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import PersonalizedDataAPIEntity.Shopper;

public interface ShopperRepository extends JpaRepository<Shopper, Long> {
	// We can add custom methods here if needed
}
