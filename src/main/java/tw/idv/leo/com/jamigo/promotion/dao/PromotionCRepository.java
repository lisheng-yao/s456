package tw.idv.leo.com.jamigo.promotion.dao;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import tw.idv.leo.com.jamigo.promotion.entity.PromotionCoupon;

public interface PromotionCRepository extends JpaRepository <PromotionCoupon , Integer>{
	
	 @Query("SELECT pc.promotionCouponNo, pc.promotionCouponName, pc.promotionName FROM PromotionCoupon pc")
	    List<Object[]> getPromotionCouponData();

}
