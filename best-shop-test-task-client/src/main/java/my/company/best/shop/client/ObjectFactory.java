
package my.company.best.shop.client;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the my.company.best.shop.client package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GetAccountResponse_QNAME = new QName("http://ws.shop.best.company.my/", "getAccountResponse");
    private final static QName _GetAccount_QNAME = new QName("http://ws.shop.best.company.my/", "getAccount");
    private final static QName _AccountDTO_QNAME = new QName("http://ws.shop.best.company.my/", "accountDTO");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: my.company.best.shop.client
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link AccountDTO }
     * 
     */
    public AccountDTO createAccountDTO() {
        return new AccountDTO();
    }

    /**
     * Create an instance of {@link GetAccount }
     * 
     */
    public GetAccount createGetAccount() {
        return new GetAccount();
    }

    /**
     * Create an instance of {@link GetAccountResponse }
     * 
     */
    public GetAccountResponse createGetAccountResponse() {
        return new GetAccountResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAccountResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.shop.best.company.my/", name = "getAccountResponse")
    public JAXBElement<GetAccountResponse> createGetAccountResponse(GetAccountResponse value) {
        return new JAXBElement<GetAccountResponse>(_GetAccountResponse_QNAME, GetAccountResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAccount }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.shop.best.company.my/", name = "getAccount")
    public JAXBElement<GetAccount> createGetAccount(GetAccount value) {
        return new JAXBElement<GetAccount>(_GetAccount_QNAME, GetAccount.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AccountDTO }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.shop.best.company.my/", name = "accountDTO")
    public JAXBElement<AccountDTO> createAccountDTO(AccountDTO value) {
        return new JAXBElement<AccountDTO>(_AccountDTO_QNAME, AccountDTO.class, null, value);
    }

}
