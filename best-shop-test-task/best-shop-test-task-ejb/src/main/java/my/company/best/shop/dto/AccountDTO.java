package my.company.best.shop.dto;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * DTO with all output values needed to test GetAccount method.
 */
@XmlRootElement
public class AccountDTO {

	private String clientId;
	private String accountId;
	private String accountName;
	private String orderCount;

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getOrderCount() {
		return orderCount;
	}

	public void setOrderCount(String orderCount) {
		this.orderCount = orderCount;
	}

	@Override
	public String toString() {
		return "AccountDTO [clientId=" + clientId + ", accountId=" + accountId
				+ ", accountName=" + accountName + ", orderCount=" + orderCount
				+ "]";
	}
}
