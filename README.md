Java wrapper for Edipost REST api
==================================

Connect to service
-------------------

```java
EdipostService service = EdipostServiceFactory.getService(
	"http://localhost:2847/edipost-integration",
	"f666b087a3bf58ef24082882dcd056cde3e7a2ec" );
```



Build and save consignee
-------------------------

```java
ConsigneeBuilder builder = service.consigneeBuilder();

Consignee myConsignee = builder
	.setCompanyName( "Et annet navn" )
	.setPostZip( "1337" )
	.setStreetZip( "1337" )
	.setCountry( "NO" )
	.build();

// Save consignee
Consignee newConsignee = myConsignee.save();

// Remove consignee
myConsignee.remove();
```



Get default consignor
----------------------

```java
Consignor consignor = service.getDefaultConsignor();
System.out.println( consignor.getCompanyName() );
```



Get consigee by ID
-------------------

```java
Consignee consignee = service.getConsignee( 102533 );
System.out.println( consignee.getCompanyName() )
```



Search for consignees
----------------------

```java
List<Consignee> consigneeList = service.findConsignee( "test" );
for( Consignee c : consigneeList ) {
	System.out.println( c.getCompanyName() );
}
```



Get consignment by ID
----------------------

```java
Consignment consignment = service.getConsignment( 95256 );
System.out.println( "SHIPMENT NUMBER: " + consignment.getShipmentNumber() );

for( Item item : consignment.getItems().getEntries() ) {
	System.out.println( "ITEM NUMBER: " + item.getConnoteNumber() );
}
```



Search for consignees
---------------------

```java
List<Consignment> consignmentList = service.findConsignment( "*" );

for( Consignment c : consignmentList ) {
	System.out.println(c.getShipmentNumber());
}
```



Get consignment label as PDF InputStream
-----------------------------------------

```java
Consignment consignment = service.getConsignment( 95256 );
InputStream in = consignment.pdf();
FileUtilities.saveInputStreamAsFile( in, "test.pdf" );
```



Save consignment label as file
-------------------------------

```java
Consignment consignment = service.getConsignment( 95256 );
consignment.pdf( "test.pdf" );
```



Print consignment label
------------------------

```java
Consignment consignment = service.getConsignment( 95256 );
consignment.print( "MyPrinterName" );
```



Build and save consignment
---------------------------

```java
ConsignmentBuilder builder = service.consignmentBuilder();

Consignment myConsignment = builder
	.setConsignorID( 3311 )
	.setConsigneeID( 191511 )
	.addItem( new Item( 1.0, 10.0, 10.0, 10.0 ) )
	.setProductID( 13 )
	.addService( new BringDomesticCodService( 1200.00, "123456789" ) )
	.setContentReference( "Innholdet" )
	.build();


myConsignment.save();
```



Calculate postage for consignment
----------------------------------

```java
Consignment postageConsignment = myConsignment.postage();

for( Item item : postageConsignment.getItems().getEntries() ) {
	System.out.println( item.getCost() + " - " + item.getVat() );
}
```



Get available products for shipment
------------------------------------

```java
List<Product> products = myConsignment.products();
```