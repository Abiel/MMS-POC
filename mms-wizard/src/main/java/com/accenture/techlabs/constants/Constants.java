/**
 * 
 */
package com.accenture.techlabs.constants;

/**
 * @author abiel.m.woldu
 *
 */
public class Constants {

	/**
	 * 
	 */
	public Constants() {
	}
	
	public static class URIs{
		public static String PRODUCTS = "http://ec2-54-200-155-235.us-west-2.compute.amazonaws.com:8080/openrdf-sesame/repositories/ConnectedHome2?query=PREFIX%20rdfs%3A%3Chttp%3A%2F%2Fwww.w3.org%2F2000%2F01%2Frdf-schema%23%3E%20PREFIX%20p1%3A%3Chttp%3A%2F%2Fmetadatamodel.accenture.com%23%3E%20PREFIX%20xsd%3A%3Chttp%3A%2F%2Fwww.w3.org%2F2001%2FXMLSchema%23%3E%20PREFIX%20owl%3A%3Chttp%3A%2F%2Fwww.w3.org%2F2002%2F07%2Fowl%23%3E%20PREFIX%20rdf%3A%3Chttp%3A%2F%2Fwww.w3.org%2F1999%2F02%2F22-rdf-syntax-ns%23%3E%20SELECT%20%3Fproduct%20WHERE%20%7B%20%3Fproduct%20rdfs%3AsubClassOf%20p1%3AProduct%20%7D";
		public static String CAPABILITY_COMPONENT_API = "http://ec2-54-200-155-235.us-west-2.compute.amazonaws.com:8080/openrdf-sesame/repositories/ConnectedHome2?query=PREFIX%20rdfs%3A%3Chttp%3A%2F%2Fwww.w3.org%2F2000%2F01%2Frdf-schema%23%3E%20PREFIX%20p1%3A%3Chttp%3A%2F%2Fmetadatamodel.accenture.com%23%3E%20PREFIX%20xsd%3A%3Chttp%3A%2F%2Fwww.w3.org%2F2001%2FXMLSchema%23%3E%20PREFIX%20owl%3A%3Chttp%3A%2F%2Fwww.w3.org%2F2002%2F07%2Fowl%23%3E%20PREFIX%20rdf%3A%3Chttp%3A%2F%2Fwww.w3.org%2F1999%2F02%2F22-rdf-syntax-ns%23%3E%20SELECT%20%3Fcap%20%20WHERE%20%7B%20p1%3AHasConnectHomeCapability%20rdfs%3Arange%20%3Fcap%20.%20%7D";
		public static String CAPABILITY_API = "http://ec2-54-200-155-235.us-west-2.compute.amazonaws.com:8080/openrdf-sesame/repositories/ConnectedHome4?query=PREFIX%20rdfs%3A%3Chttp%3A%2F%2Fwww.w3.org%2F2000%2F01%2Frdf-schema%23%3E%20PREFIX%20p1%3A%3Chttp%3A%2F%2Fmetadatamodel.accenture.com%23%3E%20PREFIX%20xsd%3A%3Chttp%3A%2F%2Fwww.w3.org%2F2001%2FXMLSchema%23%3E%20PREFIX%20owl%3A%3Chttp%3A%2F%2Fwww.w3.org%2F2002%2F07%2Fowl%23%3E%20PREFIX%20rdf%3A%3Chttp%3A%2F%2Fwww.w3.org%2F1999%2F02%2F22-rdf-syntax-ns%23%3E%20SELECT%20(if(%3Fproperty%20%3Dp1%3AhasConnectedHomeMandatoryCapability%2C%22Mandatory%22%2C%22Optional%22)%20as%20%3Ftype%20)%20%3Fcapability%0AWHERE%20%7B%3Fproperty%20rdfs%3Adomain%20p1%3AConnectedHome%20.%20%0A%3Fproperty%20rdfs%3Arange%20%3Frange%20.%0A%3Frange%20owl%3AunionOf%20%3Flist%20.%0A%3Flist%20rdf%3Arest*%2Frdf%3Afirst%20%3Fcapability%20.%0A%7D";
		public static String SERVICES_API = "http://ec2-54-200-155-235.us-west-2.compute.amazonaws.com:8080/openrdf-sesame/repositories/ConnectedHome4?query=PREFIX%20rdfs%3A%3Chttp%3A%2F%2Fwww.w3.org%2F2000%2F01%2Frdf-schema%23%3E%20PREFIX%20p1%3A%3Chttp%3A%2F%2Fmetadatamodel.accenture.com%23%3E%0APREFIX%20xsd%3A%3Chttp%3A%2F%2Fwww.w3.org%2F2001%2FXMLSchema%23%3E%20PREFIX%20owl%3A%3Chttp%3A%2F%2Fwww.w3.org%2F2002%2F07%2Fowl%23%3E%20PREFIX%20rdf%3A%3Chttp%3A%2F%2Fwww.w3.org%2F1999%2F02%2F22-rdf-syntax-ns%23%3E%20%0ASELECT%20%20%3Fsubcapability%20%3Fproperty%20%3Frange%20%0A(if(bound(%3Fservicetemp)%2C%20%3Fservicetemp%2C%20%3Frange)%20as%20%3Fservice)%0A%20WHERE%20%7B%20%0A%3Fsubcapability%20rdfs%3AsubClassOf%20p1%3ACapability%20.%0A%3Fproperty%20rdfs%3Adomain%20%3Fsubcapability%20.%20%0A%3Fproperty%20rdfs%3Arange%20%3Frange%20.%0A%0AFILTER%20(%3Fsubcapability%20!=p1%3ACapability%20%26%26%20%3Frange%20!=p1%3AService)%0A%0AOPTIONAL%20%7B%0A%3Frange%20owl%3AunionOf%20%3Flist%20.%0A%3Flist%20rdf%3Arest*%2Frdf%3Afirst%20%3Fservicetemp%20%0A%7D%0A%7D";
		public static String APP_COMPONENT_API = "http://ec2-54-200-155-235.us-west-2.compute.amazonaws.com:8080/openrdf-sesame/repositories/ConnectedHome4?query=PREFIX%20rdfs%3A%3Chttp%3A%2F%2Fwww.w3.org%2F2000%2F01%2Frdf-schema%23%3E%20PREFIX%20p1%3A%3Chttp%3A%2F%2Fmetadatamodel.accenture.com%23%3E%20PREFIX%20xsd%3A%3Chttp%3A%2F%2Fwww.w3.org%2F2001%2FXMLSchema%23%3E%20PREFIX%20owl%3A%3Chttp%3A%2F%2Fwww.w3.org%2F2002%2F07%2Fowl%23%3E%20PREFIX%20rdf%3A%3Chttp%3A%2F%2Fwww.w3.org%2F1999%2F02%2F22-rdf-syntax-ns%23%3E%20%0ASELECT%20%3Fservice%20%3Fsubproperty%20%3Frange%20(%20if(bound(%3Ftempcomp)%2C%20%3Ftempcomp%2C%20%3Frange)%20as%20%3Fcomponent)%0AWHERE%20%7B%20%0A%3Fsubproperty%20rdfs%3AsubPropertyOf%20p1%3AisManagedBy%20.%0A%3Fsubproperty%20rdfs%3Adomain%20%3Fservice%20.%0A%3Fsubproperty%20rdfs%3Arange%20%3Frange%0AFILTER%20(%3Fservice%20!=%20p1%3AService%20%26%26%20%3Frange%20!=%20p1%3AApplicationComponent)%0AOPTIONAL%20%7B%0A%3Frange%20owl%3AunionOf%20%3Flist%20.%0A%3Flist%20rdf%3Arest*%2Frdf%3Afirst%20%3Ftempcomp%0A%7D%0A%7D";
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

	}

}
