package tw.idv.leo.com.jamigo.promotion.dao;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import tw.idv.leo.com.jamigo.promotion.entity.PromotionPoint;

public interface PromotionPRepository extends JpaRepository<PromotionPoint, Integer>{
	
	@Query("SELECT pp.promotionPointNo, pp.promotionPointName, pp.promotionName FROM PromotionPoint pp")
	List<Object[]> getPromotionPointData();
}
