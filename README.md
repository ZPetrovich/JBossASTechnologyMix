#Demo app to show J2EE technologies work at JBossAS environment

## Prerequisites
Using the following technologies implement the requirements.
* JBoss 7.1.1 / JBossWS / EJB 3 / JPA / JMS
* Java 2 SE 6
* H2 database's in memory mode
* Maven 3

## Demo Story
Implements three database tables to support the Web Service and relate the tables through foreign key
constraints.
* Table 1 is Client, table 2 is Account, and table 3 is Order. 
* JPA will manage the persistence layer over the database. No any JDBC used. Implemented the necessary JPA objects and
abstracted by creating a business logic CRUD access layer over it with an EJB.
* We need separation between the data access layer (CRUD) and the web service logic. Implemented an EJB
business layer to fulfill the GetAccount functionality and also as the source to generate the web service
and WSDL.
* Inputs are Client ID and Account ID.
* Outputs are Client ID, Account ID, Account Name, Order Count
* The business layer does not access the JPA directly. The CRUD layer provides data to the
business layer functions.
* Created a SOAP web service from the business layer EJB.
* Web Service and WSDL are generated using development tools in a “bottom-up” approach
from an EJB definition. JBoss Developer Studio provides this functionality. The
web services were generated from the business logic EJBs.
* Finally, created a test web service client to access the GetAccount function of our new web service and
proved solution works.

## Deployment Guide
#### Start JBoss Enterprise Application Platform 6 or JBoss AS 7 with the Web Profile
1. Open a command line and navigate to the root of the JBoss server directory.
2. The following shows the command line to start the server with the web profile:
For Linux:
JBOSS_HOME/bin/standalone.sh
For Windows: JBOSS_HOME\bin\standalone.bat

#### Build and Deploy

Make sure you have started the JBoss Server as described above.
1. Open a command line and navigate to the root directory of best-shop-test-task.
2. Type this command to build and deploy the archive:<br>
_mvn clean package jboss-as:deploy_<br>
3. This will deploy target/best-shop-test-task-ear.ear to the running instance of
the server.

#### Verification
1. Go to best-shop-test-task-client folder
2. Type this command to build the archive:<br>
**mvn clean package**
3. Run client with parameters clientId = 1 and accountId = 101<br>
**mvn exec:java -Dexec.args="1 101"**<br>
Following output should be received:<br>
>Entered clientId <1> and accountId <101><br>
***********************<br>
Create Web Service Client...<br>
Trying to invoke GetAccount...<br>
Call Web Service Operation...<br>
[clientId=1, accountId=101, accountName=Manager, orderCount=2]<br>
***********************<br>
Call Over!<br>

4. Run client with parameters clientId = 2 and accountId = 101<br>
**mvn exec:java -Dexec.args="2 101"**<br>
Following output should be received:<br>
>Entered clientId <2> and accountId <101><br>
***********************<br>
Create Web Service Client...<br>
Trying to invoke GetAccount...<br>
Call Web Service Operation...<br>
[clientId=2, accountId=101, accountName=Manager, orderCount=1]<br>
***********************<br>
Call Over!<br>

5. Run client with parameters clientId = 3 and accountId = 101<br>
**mvn exec:java -Dexec.args="3 101"**<br>
Following output should be received:<br>
>Entered clientId <3> and accountId <101><br>
***********************<br>
Create Web Service Client...<br>
Trying to invoke GetAccount...<br>
Call Web Service Operation...<br>
[clientId=3, accountId=101, accountName=Manager, orderCount=0]<br>
***********************<br>

6. Run client with parameters clientId = 1 and accountId = 102<br>
**mvn exec:java -Dexec.args="1 102"**<br>
>Following output should be received:<br>
Entered clientId <1> and accountId <102><br>
***********************<br>
Create Web Service Client...<br>
Trying to invoke GetAccount...<br>
Call Web Service Operation...<br>
[WARNING] <br>
java.lang.reflect.InvocationTargetException<br>
at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)<br>
at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:57)<br>
at <br>
sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)<br>
at java.lang.reflect.Method.invoke(Method.java:601)<br>
at org.codehaus.mojo.exec.ExecJavaMojo$1.run(ExecJavaMojo.java:297)<br>
at java.lang.Thread.run(Thread.java:722)<br>
Caused by: javax.xml.ws.soap.SOAPFaultException: java.lang.IllegalStateException: <br>
Account with id <102> is not authorized to retrieve information for clientId <1><br>
at 
com.sun.xml.internal.ws.fault.SOAP11Fault.getProtocolException(SOAP11Fault.java:178)<br>
at 
com.sun.xml.internal.ws.fault.SOAPFaultBuilder.createException(SOAPFaultBuilder.java:111<br>
)
at 
com.sun.xml.internal.ws.client.sei.SyncMethodHandler.invoke(SyncMethodHandler.java:108)<br>
at 
com.sun.xml.internal.ws.client.sei.SyncMethodHandler.invoke(SyncMethodHandler.java:78)<br>
at com.sun.xml.internal.ws.client.sei.SEIStub.invoke(SEIStub.java:129)<br>
at sun.proxy.$Proxy41.getAccount(Unknown Source)<br>
at 
my.company.best.shop.client.clientsample.ClientSample.getAccount(ClientSample.java:46)<br>
at 
my.company.best.shop.client.clientsample.ClientSample.main(ClientSample.java:32)<br>
... 6 more<br>

We got **SoapFault** from WebService here because account with _id = 102_ is not authorized to
request account information (it is part of business logic (see _my.company.best.shop.service.AccountManagementService.isAuthorized(Account)_)).
