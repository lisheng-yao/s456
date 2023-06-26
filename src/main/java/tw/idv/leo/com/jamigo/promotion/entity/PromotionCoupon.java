package tw.idv.leo.com.jamigo.promotion.entity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@Table(name= "Promotion_Point")
@ToString
public class PromotionCoupon {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Integer promotionPointNo;
	private String promotionPointName;
	private String promotionName;
	private String getPointConditions;
	private Integer getPointMag;
	private Date promotionExpireDate;
	private Date promotionEffectiveDate;
	private Date promotionCreateDate;
	private byte[] promotionPic;
	
	public Integer getPromotionPointNo() {
		return promotionPointNo;
	}
	public void setPromotionPointNo(Integer promotionPointNo) {
		this.promotionPointNo = promotionPointNo;
	}
	public String getPromotionPointName() {
		return promotionPointName;
	}
	public void setPromotionPointName(String promotionPointName) {
		this.promotionPointName = promotionPointName;
	}
	public String getPromotionName() {
		return promotionName;
	}
	public void setPromotionName(String promotionName) {
		this.promotionName = promotionName;
	}
	public String getGetPointConditions() {
		return getPointConditions;
	}
	public void setGetPointConditions(String getPointConditions) {
		this.getPointConditions = getPointConditions;
	}
	public Integer getGetPointMag() {
		return getPointMag;
	}
	public void setGetPointMag(Integer getPointMag) {
		this.getPointMag = getPointMag;
	}
	public Date getPromotionExpireDate() {
		return promotionExpireDate;
	}
	public void setPromotionExpireDate(Date promotionExpireDate) {
		this.promotionExpireDate = promotionExpireDate;
	}
	public Date getPromotionEffectiveDate() {
		return promotionEffectiveDate;
	}
	public void setPromotionEffectiveDate(Date promotionEffectiveDate) {
		this.promotionEffectiveDate = promotionEffectiveDate;
	}
	public Date getPromotionCreateDate() {
		return promotionCreateDate;
	}
	public void setPromotionCreateDate(Date promotionCreateDate) {
		this.promotionCreateDate = promotionCreateDate;
	}
	public byte[] getPromotionPic() {
		return promotionPic;
	}
	public void setPromotionPic(byte[] promotionPic) {
		this.promotionPic = promotionPic;
	}

	
	
}
