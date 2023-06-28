package tw.idv.leo.com.jamigo.promotion.dao;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import tw.idv.leo.com.jamigo.promotion.entity.PromotionPoint34;

public interface PromotionPRepository extends JpaRepository<PromotionPoint34 , Integer>{
	
	@Query("SELECT pp.promotionPointNo, pp.promotionPointName, pp.promotionName FROM PromotionPoint34 pp")
	List<Object[]> getPromotionPointData();
}
