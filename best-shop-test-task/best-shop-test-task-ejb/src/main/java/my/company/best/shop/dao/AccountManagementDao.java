package my.company.best.shop.dao;

import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import my.company.best.shop.model.Account;
import my.company.best.shop.model.Client;
import my.company.best.shop.model.Role;
import my.company.best.shop.model.SuperOrder;

/**
 * DAO for account information retrieving.
 */
@Stateless
public class AccountManagementDao {

	@Inject
	private Logger log;

	@Inject
	private EntityManager em;

	/**
	 * Initializes data. This is just for Demo purposes!
	 */
	@PostConstruct
	public void initData() {//
		log.info("Creating test data...");

		Account account1 = new Account();
		account1.setId(Long.valueOf(101));
		account1.setName("Manager");
		account1.setRole(Role.MANAGER);
		em.persist(account1);

		Account account2 = new Account();
		account2.setId(Long.valueOf(102));
		account2.setName("Client");
		account2.setRole(Role.CLIENT);
		em.persist(account2);

		// ~~~~~~~ Clients
		Client client1 = new Client();
		client1.setId(Long.valueOf(1));
		client1.setName("Newton");
		em.persist(client1);

		Client client2 = new Client();
		client2.setId(Long.valueOf(2));
		client2.setName("Gauss");
		em.persist(client2);

		Client client3 = new Client();
		client3.setId(Long.valueOf(3));
		client3.setName("Euler");
		em.persist(client3);

		// ~~~~~~~ Orders
		SuperOrder order1 = new SuperOrder();
		order1.setClient(client1);
		em.persist(order1);

		SuperOrder order2 = new SuperOrder();
		order2.setClient(client1);
		em.persist(order2);

		SuperOrder order3 = new SuperOrder();
		order3.setClient(client2);
		em.persist(order3);

		log.info("Test data were created successfully!");
	}

	/**
	 * Retrieves order count from DB for specified <code>clientId</code>.
	 * 
	 * @param clientId
	 *            the client ID to retrieve orders number for
	 * @return the number of orders for appropriate client
	 * @throws RuntimeException
	 *             if there is <code>clientId</code> in DB
	 * @throws IllegalArgumentException
	 *             if <code>clientId</code> is null or empty
	 */
	public Integer getOrdersCount(String clientId) {
		if (clientId == null || clientId.trim().isEmpty()) {
			throw new IllegalArgumentException(
					"Specified clientId is null or empty");
		}

		log.info(String.format(
				"Trying to retrieve orders count for client <%s>", clientId));

		Client client = em.find(Client.class, Long.valueOf(clientId));
		if (client == null) {
			throw new RuntimeException(String.format(
					"Client with id <%s> is not found in DB!", clientId));
		}

		StringBuilder builder = new StringBuilder();
		builder.append("SELECT COUNT(*) ");
		builder.append("FROM SuperOrder so ");
		builder.append("WHERE so.client = :clientId");

		Query q = em.createQuery(builder.toString());
		q.setParameter("clientId", client);

		Long result = (Long) q.getSingleResult();

		log.info("@@ Retrieved orders count = " + result);

		return result.intValue();
	}

	/**
	 * Retrieves account from DB for specified <code>accountId</code>.
	 * 
	 * @param accountId
	 *            the account ID to retrieve from DB
	 * @return the Account object mapped from DB table
	 * @throws RuntimeException
	 *             if there is <code>accountId</code> in DB
	 * @throws IllegalArgumentException
	 *             if <code>accountId</code> is null or empty
	 */
	public Account getAccount(String accountId) {
		if (accountId == null || accountId.trim().isEmpty()) {
			throw new IllegalArgumentException(
					"Specified accountId is null or empty");
		}

		Account account = em.find(Account.class, Long.valueOf(accountId));
		if (account == null) {
			throw new IllegalAccessError(String.format(
					"Account  with id <%s> is not found in DB!", accountId));
		}

		return account;
	}
}
