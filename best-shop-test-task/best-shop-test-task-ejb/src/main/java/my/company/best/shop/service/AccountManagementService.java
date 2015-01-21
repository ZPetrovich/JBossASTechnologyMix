package my.company.best.shop.service;

import javax.ejb.Stateless;
import javax.inject.Inject;

import my.company.best.shop.dao.AccountManagementDao;
import my.company.best.shop.dto.AccountDTO;
import my.company.best.shop.model.Account;
import my.company.best.shop.model.Role;

/**
 * Class represented stateless EJB for Account Management.
 */
@Stateless
public class AccountManagementService {

	@Inject
	private AccountManagementDao accountManagementDao;

	/**
	 * Retrieves account information for specified <code>clientId</code> and
	 * <code>accountId</code>.
	 * 
	 * @param clientId
	 * @param accountId
	 * @return the DTO with all required field populated
	 * @throws IllegalStateException
	 *             if specified <code>accountId</code> is not authorized to get
	 *             informaton
	 */
	public AccountDTO getAccount(String clientId, String accountId) {
		Account account = accountManagementDao.getAccount(accountId);

		if (!isAuthorized(account)) {
			throw new IllegalStateException(
					String.format(
							"Account with id <%s> is not authorized to retrieve information for clientId <%s>",
							accountId, clientId));
		}

		AccountDTO accountDTO = new AccountDTO();

		accountDTO.setClientId(clientId);
		accountDTO.setAccountId(accountId);

		Integer orderCount = accountManagementDao.getOrdersCount(clientId);
		accountDTO.setOrderCount(String.valueOf(orderCount));

		String accountName = account.getName();
		accountDTO.setAccountName(accountName);

		return accountDTO;
	}

	/**
	 * Checks whether specified account is authorized to perform operation.
	 * 
	 * @param account
	 *            the Account to check
	 * @return <code>true</code> if account allowed to perform operation;
	 *         <code>false</code> otherwise
	 */
	private boolean isAuthorized(Account account) {
		return account.getRole() == Role.MANAGER;
	}

}
