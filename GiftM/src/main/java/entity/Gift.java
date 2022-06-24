package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "gift")
public class Gift {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "giftId",nullable = false)
	private long giftId;
	@Column(name = "giftName",nullable = false)
	private String giftName;
	@Column(name = "giftImageUrl",nullable = false)
	private String giftImageUrl;
	@Column(name = "giftDetails",nullable = false)
	private String giftDetails;
	@Column(name = "giftPrice",nullable = false)
	private int giftPrice;
	public Gift() {
		
	}
	public Gift(String giftName, String giftImageUrl, String giftDetails, int giftPrice) {
		this.giftName = giftName;
		this.giftImageUrl = giftImageUrl;
		this.giftDetails = giftDetails;
		this.giftPrice = giftPrice;
	}
	public long getGiftId() {
		return giftId;
	}
	public void setGiftId(long giftId) {
		this.giftId = giftId;
	}
	public String getGiftName() {
		return giftName;
	}
	public void setGiftName(String giftName) {
		this.giftName = giftName;
	}
	public String getGiftImageUrl() {
		return giftImageUrl;
	}
	public void setGiftImageUrl(String giftImageUrl) {
		this.giftImageUrl = giftImageUrl;
	}
	public String getGiftDetails() {
		return giftDetails;
	}
	public void setGiftDetails(String giftDetails) {
		this.giftDetails = giftDetails;
	}
	public int getGiftPrice() {
		return giftPrice;
	}
	public void setGiftPrice(int giftPrice) {
		this.giftPrice = giftPrice;
	}
	@Override
	public String toString() {
		return "Gift [giftId=" + giftId + ", giftName=" + giftName + ", giftImageUrl=" + giftImageUrl + ", giftDetails="
				+ giftDetails + ", giftPrice=" + giftPrice + "]";
	}
	

}
