//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.01.03 at 05:10:40 PM IST 
//


package org.example.eligibleproductinfo;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.example.eligibleproductinfo package. 
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

    private final static QName _IsActive_QNAME = new QName("http://www.example.org/EligibleProductInfo", "IsActive");
    private final static QName _ProductId_QNAME = new QName("http://www.example.org/EligibleProductInfo", "ProductId");
    private final static QName _EligibleProduct_QNAME = new QName("http://www.example.org/EligibleProductInfo", "EligibleProduct");
    private final static QName _EligibleProductList_QNAME = new QName("http://www.example.org/EligibleProductInfo", "EligibleProductList");
    private final static QName _MutuallyExclusiveProduct_QNAME = new QName("http://www.example.org/EligibleProductInfo", "MutuallyExclusiveProduct");
    private final static QName _IsMutuallyExclusive_QNAME = new QName("http://www.example.org/EligibleProductInfo", "IsMutuallyExclusive");
    private final static QName _ProductDescription_QNAME = new QName("http://www.example.org/EligibleProductInfo", "ProductDescription");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.example.eligibleproductinfo
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link MutuallyExclusiveProductType }
     * 
     */
    public MutuallyExclusiveProductType createMutuallyExclusiveProductType() {
        return new MutuallyExclusiveProductType();
    }

    /**
     * Create an instance of {@link EligibleProductType }
     * 
     */
    public EligibleProductType createEligibleProductType() {
        return new EligibleProductType();
    }

    /**
     * Create an instance of {@link EligibleProductListType }
     * 
     */
    public EligibleProductListType createEligibleProductListType() {
        return new EligibleProductListType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.example.org/EligibleProductInfo", name = "IsActive")
    public JAXBElement<Boolean> createIsActive(Boolean value) {
        return new JAXBElement<Boolean>(_IsActive_QNAME, Boolean.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.example.org/EligibleProductInfo", name = "ProductId")
    public JAXBElement<Integer> createProductId(Integer value) {
        return new JAXBElement<Integer>(_ProductId_QNAME, Integer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EligibleProductType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.example.org/EligibleProductInfo", name = "EligibleProduct")
    public JAXBElement<EligibleProductType> createEligibleProduct(EligibleProductType value) {
        return new JAXBElement<EligibleProductType>(_EligibleProduct_QNAME, EligibleProductType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EligibleProductListType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.example.org/EligibleProductInfo", name = "EligibleProductList")
    public JAXBElement<EligibleProductListType> createEligibleProductList(EligibleProductListType value) {
        return new JAXBElement<EligibleProductListType>(_EligibleProductList_QNAME, EligibleProductListType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MutuallyExclusiveProductType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.example.org/EligibleProductInfo", name = "MutuallyExclusiveProduct")
    public JAXBElement<MutuallyExclusiveProductType> createMutuallyExclusiveProduct(MutuallyExclusiveProductType value) {
        return new JAXBElement<MutuallyExclusiveProductType>(_MutuallyExclusiveProduct_QNAME, MutuallyExclusiveProductType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.example.org/EligibleProductInfo", name = "IsMutuallyExclusive")
    public JAXBElement<Boolean> createIsMutuallyExclusive(Boolean value) {
        return new JAXBElement<Boolean>(_IsMutuallyExclusive_QNAME, Boolean.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.example.org/EligibleProductInfo", name = "ProductDescription")
    public JAXBElement<String> createProductDescription(String value) {
        return new JAXBElement<String>(_ProductDescription_QNAME, String.class, null, value);
    }

}
