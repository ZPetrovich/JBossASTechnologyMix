package my.company.best.shop.ws;

import javax.inject.Inject;
import javax.jws.WebService;

import my.company.best.shop.dto.AccountDTO;
import my.company.best.shop.service.AccountManagementService;

/**
 * Class serves as Web Service for account management.
 */
@WebService
public class AccountManagementWebService {

	/** The Account Management Service EJB. */
	@Inject
	private AccountManagementService accountManagementService;

	/**
	 * Retrieves account/client specific information for specified parameters.
	 * 
	 * @param clientId
	 *            the client ID
	 * @param accountId
	 *            the account ID
	 * @return the DTO represented retrieved information from the service
	 */
	public AccountDTO getAccount(String clientId, String accountId) {
		return accountManagementService.getAccount(clientId, accountId);
	}
}
