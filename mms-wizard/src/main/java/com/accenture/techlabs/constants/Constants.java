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
		public static String CAPABILITY_COMPONENT_API = "http://ec2-54-200-155-235.us-west-2.compute.amazonaws.com:8080/openrdf-sesame/repositories/ConnectedHome2?query=PREFIX%20rdfs%3A%3Chttp%3A%2F%2Fwww.w3.org%2F2000%2F01%2Frdf-schema%23%3E%20PREFIX%20p1%3A%3Chttp%3A%2F%2Fmetadatamodel.accenture.com%23%3E%20PREFIX%20xsd%3A%3Chttp%3A%2F%2Fwww.w3.org%2F2001%2FXMLSchema%23%3E%20PREFIX%20owl%3A%3Chttp%3A%2F%2Fwww.w3.org%2F2002%2F07%2Fowl%23%3E%20PREFIX%20rdf%3A%3Chttp%3A%2F%2Fwww.w3.org%2F1999%2F02%2F22-rdf-syntax-ns%23%3E%20SELECT%20%3Fcap%20%3Fcom%20%3Fapi%20WHERE%20%7B%20p1%3AHasConnectHomeCapability%20rdfs%3Arange%20%3Fcap%20.%20%3Fcapcom%20rdfs%3Adomain%20%3Fcap%20.%20%3Fcapcom%20rdfs%3Arange%20%3Fcom%20.%20%3Fcomapi%20rdfs%3Adomain%20%3Fcom%20.%20%3Fcomapi%20rdfs%3Arange%20%3Fapi%20%7D";
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
