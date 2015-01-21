package my.company.best.shop.client.clientsample;

import my.company.best.shop.client.AccountDTO;
import my.company.best.shop.client.AccountManagementWebService;
import my.company.best.shop.client.AccountManagementWebServiceService;

/**
 * This is test Client to verify Web service correct work.
 */
public class ClientSample {

	public static void main(String[] args) {

		if (args == null || args.length != 2) {
			System.out
					.println("Please provide clientId and accountId as arguments");
			System.exit(0);
		}

		String clientId = args[0];
		String accountId = args[1];

		System.out.println(String
				.format("Entered clientId <%s> and accountId <%s>", clientId,
						accountId));

		System.out.println("***********************");
		System.out.println("Create Web Service Client...");
		AccountManagementWebServiceService service = new AccountManagementWebServiceService();

		System.out.println("Trying to invoke GetAccount...");
		AccountManagementWebService port = service
				.getAccountManagementWebServicePort();
		
		System.out.println("Call Web Service Operation...");
		
		AccountDTO account = port.getAccount(clientId, accountId);
		String clientId1 = account.getClientId();
		String accountId1 = account.getAccountId();
		String accountName = account.getAccountName();
		String orderCount = account.getOrderCount();
		
		String output = "[clientId=" + clientId1 + ", accountId=" + accountId1
				+ ", accountName=" + accountName + ", orderCount=" + orderCount
				+ "]";
		System.out.println(output);
		System.out.println("***********************");
		System.out.println("Call Over!");
	}
}
