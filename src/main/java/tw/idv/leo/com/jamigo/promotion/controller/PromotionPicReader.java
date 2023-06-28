package tw.idv.leo.com.jamigo.promotion.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import tw.idv.leo.com.jamigo.promotion.dao.PromotionCRepository;
import tw.idv.leo.com.jamigo.promotion.dao.PromotionPRepository;
import tw.idv.leo.com.jamigo.promotion.entity.PromotionCoupon;
import tw.idv.leo.com.jamigo.promotion.entity.PromotionPoint;

@Controller
public class PromotionPicReader {

	@Autowired
	public PromotionPRepository promotionPRepository;

	@Autowired
	public PromotionCRepository promotionCRepository;

	@GetMapping("/promotionPPic/{promotionPointNo}")
	public void promotionPPic(@PathVariable Integer promotionPointNo, HttpServletResponse response) throws IOException {

		PromotionPoint pp = promotionPRepository.findById(promotionPointNo).orElse(null);

		if (pp != null && pp.getPromotionPic() != null) {
			response.setContentType("image/jpg");
			response.getOutputStream().write(pp.getPromotionPic());
		}
	}

	@GetMapping("/promotionCPic/{promotionCouponNo}")
	public void promotionCPic(@PathVariable Integer promotionCouponNo, HttpServletResponse response) throws IOException {

		PromotionCoupon cp = promotionCRepository.findById(promotionCouponNo).orElse(null);

		if (cp != null && cp.getPromotionPic() != null) {
			response.setContentType("image/jpg");
			response.getOutputStream().write(cp.getPromotionPic());
		}
	}
}
