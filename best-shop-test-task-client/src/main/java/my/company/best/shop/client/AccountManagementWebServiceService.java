package my.company.best.shop.client;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;

/**
 * This class was generated by Apache CXF 2.7.7.redhat-1
 * 2014-12-07T00:00:45.177+02:00
 * Generated source version: 2.7.7.redhat-1
 * 
 */
@WebServiceClient(name = "AccountManagementWebServiceService", 
                  wsdlLocation = "file:/home/michael/workspaceJBoss/best-shop-test-task-client/src/main/resources/AccountManagementWebService.wsdl",
                  targetNamespace = "http://ws.shop.best.company.my/") 
public class AccountManagementWebServiceService extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://ws.shop.best.company.my/", "AccountManagementWebServiceService");
    public final static QName AccountManagementWebServicePort = new QName("http://ws.shop.best.company.my/", "AccountManagementWebServicePort");
    static {
        URL url = null;
        try {
            url = new URL("file:/home/michael/workspaceJBoss/best-shop-test-task-client/src/main/resources/AccountManagementWebService.wsdl");
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(AccountManagementWebServiceService.class.getName())
                .log(java.util.logging.Level.INFO, 
                     "Can not initialize the default wsdl from {0}", "file:/home/michael/workspaceJBoss/best-shop-test-task-client/src/main/resources/AccountManagementWebService.wsdl");
        }
        WSDL_LOCATION = url;
    }

    public AccountManagementWebServiceService(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public AccountManagementWebServiceService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public AccountManagementWebServiceService() {
        super(WSDL_LOCATION, SERVICE);
    }
    
    //This constructor requires JAX-WS API 2.2. You will need to endorse the 2.2
    //API jar or re-run wsdl2java with "-frontend jaxws21" to generate JAX-WS 2.1
    //compliant code instead.
    public AccountManagementWebServiceService(WebServiceFeature ... features) {
        super(WSDL_LOCATION, SERVICE, features);
    }

    //This constructor requires JAX-WS API 2.2. You will need to endorse the 2.2
    //API jar or re-run wsdl2java with "-frontend jaxws21" to generate JAX-WS 2.1
    //compliant code instead.
    public AccountManagementWebServiceService(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE, features);
    }

    //This constructor requires JAX-WS API 2.2. You will need to endorse the 2.2
    //API jar or re-run wsdl2java with "-frontend jaxws21" to generate JAX-WS 2.1
    //compliant code instead.
    public AccountManagementWebServiceService(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     *
     * @return
     *     returns AccountManagementWebService
     */
    @WebEndpoint(name = "AccountManagementWebServicePort")
    public AccountManagementWebService getAccountManagementWebServicePort() {
        return super.getPort(AccountManagementWebServicePort, AccountManagementWebService.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns AccountManagementWebService
     */
    @WebEndpoint(name = "AccountManagementWebServicePort")
    public AccountManagementWebService getAccountManagementWebServicePort(WebServiceFeature... features) {
        return super.getPort(AccountManagementWebServicePort, AccountManagementWebService.class, features);
    }

}