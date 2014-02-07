
package com.amazonaws.fps.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for SubscriptionDetails complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SubscriptionDetails">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="SubscriptionId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Description" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="SubscriptionAmount" type="{http://fps.amazonaws.com/doc/2010-08-28/}Amount"/>
 *         &lt;element name="NextTransactionAmount" type="{http://fps.amazonaws.com/doc/2010-08-28/}Amount" minOccurs="0"/>
 *         &lt;element name="PromotionalAmount" type="{http://fps.amazonaws.com/doc/2010-08-28/}Amount" minOccurs="0"/>
 *         &lt;element name="NumberOfPromotionalTransactions" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="StartDate" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="EndDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="SubscriptionPeriod" type="{http://fps.amazonaws.com/doc/2010-08-28/}Duration" minOccurs="0"/>
 *         &lt;element name="SubscriptionFrequency" type="{http://fps.amazonaws.com/doc/2010-08-28/}Duration"/>
 *         &lt;element name="OverrideIPNUrl" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SubscriptionStatus" type="{http://fps.amazonaws.com/doc/2010-08-28/}SubscriptionStatus"/>
 *         &lt;element name="NumberOfTransactionsProcessed" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="RecipientEmail" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="RecipientName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="SenderEmail" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="SenderName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="NextTransactionDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * Generated by AWS Code Generator
 * <p/>
 * Mon May 30 08:10:15 GMT+00:00 2011
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SubscriptionDetails", propOrder = {
    "subscriptionId",
    "description",
    "subscriptionAmount",
    "nextTransactionAmount",
    "promotionalAmount",
    "numberOfPromotionalTransactions",
    "startDate",
    "endDate",
    "subscriptionPeriod",
    "subscriptionFrequency",
    "overrideIPNUrl",
    "subscriptionStatus",
    "numberOfTransactionsProcessed",
    "recipientEmail",
    "recipientName",
    "senderEmail",
    "senderName",
    "nextTransactionDate"
})
public class SubscriptionDetails {

    @XmlElement(name = "SubscriptionId", required = true)
    protected String subscriptionId;
    @XmlElement(name = "Description", required = true)
    protected String description;
    @XmlElement(name = "SubscriptionAmount", required = true)
    protected Amount subscriptionAmount;
    @XmlElement(name = "NextTransactionAmount")
    protected Amount nextTransactionAmount;
    @XmlElement(name = "PromotionalAmount")
    protected Amount promotionalAmount;
    @XmlElement(name = "NumberOfPromotionalTransactions")
    protected int numberOfPromotionalTransactions;
    @XmlElement(name = "StartDate", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar startDate;
    @XmlElement(name = "EndDate")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar endDate;
    @XmlElement(name = "SubscriptionPeriod")
    protected Duration subscriptionPeriod;
    @XmlElement(name = "SubscriptionFrequency", required = true)
    protected Duration subscriptionFrequency;
    @XmlElement(name = "OverrideIPNUrl")
    protected String overrideIPNUrl;
    @XmlElement(name = "SubscriptionStatus", required = true)
    protected SubscriptionStatus subscriptionStatus;
    @XmlElement(name = "NumberOfTransactionsProcessed")
    protected int numberOfTransactionsProcessed;
    @XmlElement(name = "RecipientEmail", required = true)
    protected String recipientEmail;
    @XmlElement(name = "RecipientName", required = true)
    protected String recipientName;
    @XmlElement(name = "SenderEmail", required = true)
    protected String senderEmail;
    @XmlElement(name = "SenderName", required = true)
    protected String senderName;
    @XmlElement(name = "NextTransactionDate")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar nextTransactionDate;

    /**
     * Default constructor
     * 
     */
    public SubscriptionDetails() {
        super();
    }

    /**
     * Value constructor
     * 
     */
    public SubscriptionDetails(final String subscriptionId, final String description, final Amount subscriptionAmount, final Amount nextTransactionAmount, final Amount promotionalAmount, final int numberOfPromotionalTransactions, final XMLGregorianCalendar startDate, final XMLGregorianCalendar endDate, final Duration subscriptionPeriod, final Duration subscriptionFrequency, final String overrideIPNUrl, final SubscriptionStatus subscriptionStatus, final int numberOfTransactionsProcessed, final String recipientEmail, final String recipientName, final String senderEmail, final String senderName, final XMLGregorianCalendar nextTransactionDate) {
        this.subscriptionId = subscriptionId;
        this.description = description;
        this.subscriptionAmount = subscriptionAmount;
        this.nextTransactionAmount = nextTransactionAmount;
        this.promotionalAmount = promotionalAmount;
        this.numberOfPromotionalTransactions = numberOfPromotionalTransactions;
        this.startDate = startDate;
        this.endDate = endDate;
        this.subscriptionPeriod = subscriptionPeriod;
        this.subscriptionFrequency = subscriptionFrequency;
        this.overrideIPNUrl = overrideIPNUrl;
        this.subscriptionStatus = subscriptionStatus;
        this.numberOfTransactionsProcessed = numberOfTransactionsProcessed;
        this.recipientEmail = recipientEmail;
        this.recipientName = recipientName;
        this.senderEmail = senderEmail;
        this.senderName = senderName;
        this.nextTransactionDate = nextTransactionDate;
    }

    /**
     * Gets the value of the subscriptionId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSubscriptionId() {
        return subscriptionId;
    }

    /**
     * Sets the value of the subscriptionId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSubscriptionId(String value) {
        this.subscriptionId = value;
    }

    public boolean isSetSubscriptionId() {
        return (this.subscriptionId!= null);
    }

    /**
     * Gets the value of the description property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescription(String value) {
        this.description = value;
    }

    public boolean isSetDescription() {
        return (this.description!= null);
    }

    /**
     * Gets the value of the subscriptionAmount property.
     * 
     * @return
     *     possible object is
     *     {@link Amount }
     *     
     */
    public Amount getSubscriptionAmount() {
        return subscriptionAmount;
    }

    /**
     * Sets the value of the subscriptionAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link Amount }
     *     
     */
    public void setSubscriptionAmount(Amount value) {
        this.subscriptionAmount = value;
    }

    public boolean isSetSubscriptionAmount() {
        return (this.subscriptionAmount!= null);
    }

    /**
     * Gets the value of the nextTransactionAmount property.
     * 
     * @return
     *     possible object is
     *     {@link Amount }
     *     
     */
    public Amount getNextTransactionAmount() {
        return nextTransactionAmount;
    }

    /**
     * Sets the value of the nextTransactionAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link Amount }
     *     
     */
    public void setNextTransactionAmount(Amount value) {
        this.nextTransactionAmount = value;
    }

    public boolean isSetNextTransactionAmount() {
        return (this.nextTransactionAmount!= null);
    }

    /**
     * Gets the value of the promotionalAmount property.
     * 
     * @return
     *     possible object is
     *     {@link Amount }
     *     
     */
    public Amount getPromotionalAmount() {
        return promotionalAmount;
    }

    /**
     * Sets the value of the promotionalAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link Amount }
     *     
     */
    public void setPromotionalAmount(Amount value) {
        this.promotionalAmount = value;
    }

    public boolean isSetPromotionalAmount() {
        return (this.promotionalAmount!= null);
    }

    /**
     * Gets the value of the numberOfPromotionalTransactions property.
     * 
     */
    public int getNumberOfPromotionalTransactions() {
        return numberOfPromotionalTransactions;
    }

    /**
     * Sets the value of the numberOfPromotionalTransactions property.
     * 
     */
    public void setNumberOfPromotionalTransactions(int value) {
        this.numberOfPromotionalTransactions = value;
    }

    public boolean isSetNumberOfPromotionalTransactions() {
        return true;
    }

    /**
     * Gets the value of the startDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getStartDate() {
        return startDate;
    }

    /**
     * Sets the value of the startDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setStartDate(XMLGregorianCalendar value) {
        this.startDate = value;
    }

    public boolean isSetStartDate() {
        return (this.startDate!= null);
    }

    /**
     * Gets the value of the endDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getEndDate() {
        return endDate;
    }

    /**
     * Sets the value of the endDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setEndDate(XMLGregorianCalendar value) {
        this.endDate = value;
    }

    public boolean isSetEndDate() {
        return (this.endDate!= null);
    }

    /**
     * Gets the value of the subscriptionPeriod property.
     * 
     * @return
     *     possible object is
     *     {@link Duration }
     *     
     */
    public Duration getSubscriptionPeriod() {
        return subscriptionPeriod;
    }

    /**
     * Sets the value of the subscriptionPeriod property.
     * 
     * @param value
     *     allowed object is
     *     {@link Duration }
     *     
     */
    public void setSubscriptionPeriod(Duration value) {
        this.subscriptionPeriod = value;
    }

    public boolean isSetSubscriptionPeriod() {
        return (this.subscriptionPeriod!= null);
    }

    /**
     * Gets the value of the subscriptionFrequency property.
     * 
     * @return
     *     possible object is
     *     {@link Duration }
     *     
     */
    public Duration getSubscriptionFrequency() {
        return subscriptionFrequency;
    }

    /**
     * Sets the value of the subscriptionFrequency property.
     * 
     * @param value
     *     allowed object is
     *     {@link Duration }
     *     
     */
    public void setSubscriptionFrequency(Duration value) {
        this.subscriptionFrequency = value;
    }

    public boolean isSetSubscriptionFrequency() {
        return (this.subscriptionFrequency!= null);
    }

    /**
     * Gets the value of the overrideIPNUrl property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOverrideIPNUrl() {
        return overrideIPNUrl;
    }

    /**
     * Sets the value of the overrideIPNUrl property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOverrideIPNUrl(String value) {
        this.overrideIPNUrl = value;
    }

    public boolean isSetOverrideIPNUrl() {
        return (this.overrideIPNUrl!= null);
    }

    /**
     * Gets the value of the subscriptionStatus property.
     * 
     * @return
     *     possible object is
     *     {@link SubscriptionStatus }
     *     
     */
    public SubscriptionStatus getSubscriptionStatus() {
        return subscriptionStatus;
    }

    /**
     * Sets the value of the subscriptionStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link SubscriptionStatus }
     *     
     */
    public void setSubscriptionStatus(SubscriptionStatus value) {
        this.subscriptionStatus = value;
    }

    public boolean isSetSubscriptionStatus() {
        return (this.subscriptionStatus!= null);
    }

    /**
     * Gets the value of the numberOfTransactionsProcessed property.
     * 
     */
    public int getNumberOfTransactionsProcessed() {
        return numberOfTransactionsProcessed;
    }

    /**
     * Sets the value of the numberOfTransactionsProcessed property.
     * 
     */
    public void setNumberOfTransactionsProcessed(int value) {
        this.numberOfTransactionsProcessed = value;
    }

    public boolean isSetNumberOfTransactionsProcessed() {
        return true;
    }

    /**
     * Gets the value of the recipientEmail property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRecipientEmail() {
        return recipientEmail;
    }

    /**
     * Sets the value of the recipientEmail property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRecipientEmail(String value) {
        this.recipientEmail = value;
    }

    public boolean isSetRecipientEmail() {
        return (this.recipientEmail!= null);
    }

    /**
     * Gets the value of the recipientName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRecipientName() {
        return recipientName;
    }

    /**
     * Sets the value of the recipientName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRecipientName(String value) {
        this.recipientName = value;
    }

    public boolean isSetRecipientName() {
        return (this.recipientName!= null);
    }

    /**
     * Gets the value of the senderEmail property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSenderEmail() {
        return senderEmail;
    }

    /**
     * Sets the value of the senderEmail property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSenderEmail(String value) {
        this.senderEmail = value;
    }

    public boolean isSetSenderEmail() {
        return (this.senderEmail!= null);
    }

    /**
     * Gets the value of the senderName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSenderName() {
        return senderName;
    }

    /**
     * Sets the value of the senderName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSenderName(String value) {
        this.senderName = value;
    }

    public boolean isSetSenderName() {
        return (this.senderName!= null);
    }

    /**
     * Gets the value of the nextTransactionDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getNextTransactionDate() {
        return nextTransactionDate;
    }

    /**
     * Sets the value of the nextTransactionDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setNextTransactionDate(XMLGregorianCalendar value) {
        this.nextTransactionDate = value;
    }

    public boolean isSetNextTransactionDate() {
        return (this.nextTransactionDate!= null);
    }

    /**
     * Sets the value of the SubscriptionId property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public SubscriptionDetails withSubscriptionId(String value) {
        setSubscriptionId(value);
        return this;
    }

    /**
     * Sets the value of the Description property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public SubscriptionDetails withDescription(String value) {
        setDescription(value);
        return this;
    }

    /**
     * Sets the value of the SubscriptionAmount property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public SubscriptionDetails withSubscriptionAmount(Amount value) {
        setSubscriptionAmount(value);
        return this;
    }

    /**
     * Sets the value of the NextTransactionAmount property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public SubscriptionDetails withNextTransactionAmount(Amount value) {
        setNextTransactionAmount(value);
        return this;
    }

    /**
     * Sets the value of the PromotionalAmount property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public SubscriptionDetails withPromotionalAmount(Amount value) {
        setPromotionalAmount(value);
        return this;
    }

    /**
     * Sets the value of the NumberOfPromotionalTransactions property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public SubscriptionDetails withNumberOfPromotionalTransactions(int value) {
        setNumberOfPromotionalTransactions(value);
        return this;
    }

    /**
     * Sets the value of the StartDate property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public SubscriptionDetails withStartDate(XMLGregorianCalendar value) {
        setStartDate(value);
        return this;
    }

    /**
     * Sets the value of the EndDate property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public SubscriptionDetails withEndDate(XMLGregorianCalendar value) {
        setEndDate(value);
        return this;
    }

    /**
     * Sets the value of the SubscriptionPeriod property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public SubscriptionDetails withSubscriptionPeriod(Duration value) {
        setSubscriptionPeriod(value);
        return this;
    }

    /**
     * Sets the value of the SubscriptionFrequency property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public SubscriptionDetails withSubscriptionFrequency(Duration value) {
        setSubscriptionFrequency(value);
        return this;
    }

    /**
     * Sets the value of the OverrideIPNUrl property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public SubscriptionDetails withOverrideIPNUrl(String value) {
        setOverrideIPNUrl(value);
        return this;
    }

    /**
     * Sets the value of the SubscriptionStatus property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public SubscriptionDetails withSubscriptionStatus(SubscriptionStatus value) {
        setSubscriptionStatus(value);
        return this;
    }

    /**
     * Sets the value of the NumberOfTransactionsProcessed property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public SubscriptionDetails withNumberOfTransactionsProcessed(int value) {
        setNumberOfTransactionsProcessed(value);
        return this;
    }

    /**
     * Sets the value of the RecipientEmail property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public SubscriptionDetails withRecipientEmail(String value) {
        setRecipientEmail(value);
        return this;
    }

    /**
     * Sets the value of the RecipientName property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public SubscriptionDetails withRecipientName(String value) {
        setRecipientName(value);
        return this;
    }

    /**
     * Sets the value of the SenderEmail property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public SubscriptionDetails withSenderEmail(String value) {
        setSenderEmail(value);
        return this;
    }

    /**
     * Sets the value of the SenderName property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public SubscriptionDetails withSenderName(String value) {
        setSenderName(value);
        return this;
    }

    /**
     * Sets the value of the NextTransactionDate property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public SubscriptionDetails withNextTransactionDate(XMLGregorianCalendar value) {
        setNextTransactionDate(value);
        return this;
    }
    

    /**
     * 
     * XML fragment representation of this object
     * 
     * @return XML fragment for this object. Name for outer
     * tag expected to be set by calling method. This fragment
     * returns inner properties representation only
     */
    protected String toXMLFragment() {
        StringBuffer xml = new StringBuffer();
        if (isSetSubscriptionId()) {
            xml.append("<SubscriptionId>");
            xml.append(escapeXML(getSubscriptionId()));
            xml.append("</SubscriptionId>");
        }
        if (isSetDescription()) {
            xml.append("<Description>");
            xml.append(escapeXML(getDescription()));
            xml.append("</Description>");
        }
        if (isSetSubscriptionAmount()) {
            Amount  subscriptionAmount = getSubscriptionAmount();
            xml.append("<SubscriptionAmount>");
            xml.append(subscriptionAmount.toXMLFragment());
            xml.append("</SubscriptionAmount>");
        } 
        if (isSetNextTransactionAmount()) {
            Amount  nextTransactionAmount = getNextTransactionAmount();
            xml.append("<NextTransactionAmount>");
            xml.append(nextTransactionAmount.toXMLFragment());
            xml.append("</NextTransactionAmount>");
        } 
        if (isSetPromotionalAmount()) {
            Amount  promotionalAmount = getPromotionalAmount();
            xml.append("<PromotionalAmount>");
            xml.append(promotionalAmount.toXMLFragment());
            xml.append("</PromotionalAmount>");
        } 
        if (isSetNumberOfPromotionalTransactions()) {
            xml.append("<NumberOfPromotionalTransactions>");
            xml.append(getNumberOfPromotionalTransactions() + "");
            xml.append("</NumberOfPromotionalTransactions>");
        }
        if (isSetStartDate()) {
            xml.append("<StartDate>");
            xml.append(getStartDate() + "");
            xml.append("</StartDate>");
        }
        if (isSetEndDate()) {
            xml.append("<EndDate>");
            xml.append(getEndDate() + "");
            xml.append("</EndDate>");
        }
        if (isSetSubscriptionPeriod()) {
            Duration  subscriptionPeriod = getSubscriptionPeriod();
            xml.append("<SubscriptionPeriod>");
            xml.append(subscriptionPeriod.toXMLFragment());
            xml.append("</SubscriptionPeriod>");
        } 
        if (isSetSubscriptionFrequency()) {
            Duration  subscriptionFrequency = getSubscriptionFrequency();
            xml.append("<SubscriptionFrequency>");
            xml.append(subscriptionFrequency.toXMLFragment());
            xml.append("</SubscriptionFrequency>");
        } 
        if (isSetOverrideIPNUrl()) {
            xml.append("<OverrideIPNUrl>");
            xml.append(escapeXML(getOverrideIPNUrl()));
            xml.append("</OverrideIPNUrl>");
        }
        if (isSetSubscriptionStatus()) {
            xml.append("<SubscriptionStatus>");
            xml.append(getSubscriptionStatus().value());
            xml.append("</SubscriptionStatus>");
        }
        if (isSetNumberOfTransactionsProcessed()) {
            xml.append("<NumberOfTransactionsProcessed>");
            xml.append(getNumberOfTransactionsProcessed() + "");
            xml.append("</NumberOfTransactionsProcessed>");
        }
        if (isSetRecipientEmail()) {
            xml.append("<RecipientEmail>");
            xml.append(escapeXML(getRecipientEmail()));
            xml.append("</RecipientEmail>");
        }
        if (isSetRecipientName()) {
            xml.append("<RecipientName>");
            xml.append(escapeXML(getRecipientName()));
            xml.append("</RecipientName>");
        }
        if (isSetSenderEmail()) {
            xml.append("<SenderEmail>");
            xml.append(escapeXML(getSenderEmail()));
            xml.append("</SenderEmail>");
        }
        if (isSetSenderName()) {
            xml.append("<SenderName>");
            xml.append(escapeXML(getSenderName()));
            xml.append("</SenderName>");
        }
        if (isSetNextTransactionDate()) {
            xml.append("<NextTransactionDate>");
            xml.append(getNextTransactionDate() + "");
            xml.append("</NextTransactionDate>");
        }
        return xml.toString();
    }

    /**
     * 
     * Escape XML special characters
     */
    private String escapeXML(String string) {
        StringBuffer sb = new StringBuffer();
        int length = string.length();
        for (int i = 0; i < length; ++i) {
            char c = string.charAt(i);
            switch (c) {
            case '&':
                sb.append("&amp;");
                break;
            case '<':
                sb.append("&lt;");
                break;
            case '>':
                sb.append("&gt;");
                break;
            case '\'':
                sb.append("&#039;");
                break;
            case '"':
                sb.append("&quot;");
                break;
            default:
                sb.append(c);
            }
        }
        return sb.toString();
    }



    /**
     *
     * JSON fragment representation of this object
     *
     * @return JSON fragment for this object. Name for outer
     * object expected to be set by calling method. This fragment
     * returns inner properties representation only
     *
     */
    protected String toJSONFragment() {
        StringBuffer json = new StringBuffer();
        boolean first = true;
        if (isSetSubscriptionId()) {
            if (!first) json.append(", ");
            json.append(quoteJSON("SubscriptionId"));
            json.append(" : ");
            json.append(quoteJSON(getSubscriptionId()));
            first = false;
        }
        if (isSetDescription()) {
            if (!first) json.append(", ");
            json.append(quoteJSON("Description"));
            json.append(" : ");
            json.append(quoteJSON(getDescription()));
            first = false;
        }
        if (isSetSubscriptionAmount()) {
            if (!first) json.append(", ");
            json.append("\"SubscriptionAmount\" : {");
            Amount  subscriptionAmount = getSubscriptionAmount();


            json.append(subscriptionAmount.toJSONFragment());
            json.append("}");
            first = false;
        }
        if (isSetNextTransactionAmount()) {
            if (!first) json.append(", ");
            json.append("\"NextTransactionAmount\" : {");
            Amount  nextTransactionAmount = getNextTransactionAmount();


            json.append(nextTransactionAmount.toJSONFragment());
            json.append("}");
            first = false;
        }
        if (isSetPromotionalAmount()) {
            if (!first) json.append(", ");
            json.append("\"PromotionalAmount\" : {");
            Amount  promotionalAmount = getPromotionalAmount();


            json.append(promotionalAmount.toJSONFragment());
            json.append("}");
            first = false;
        }
        if (isSetNumberOfPromotionalTransactions()) {
            if (!first) json.append(", ");
            json.append(quoteJSON("NumberOfPromotionalTransactions"));
            json.append(" : ");
            json.append(quoteJSON(getNumberOfPromotionalTransactions() + ""));
            first = false;
        }
        if (isSetStartDate()) {
            if (!first) json.append(", ");
            json.append(quoteJSON("StartDate"));
            json.append(" : ");
            json.append(quoteJSON(getStartDate() + ""));
            first = false;
        }
        if (isSetEndDate()) {
            if (!first) json.append(", ");
            json.append(quoteJSON("EndDate"));
            json.append(" : ");
            json.append(quoteJSON(getEndDate() + ""));
            first = false;
        }
        if (isSetSubscriptionPeriod()) {
            if (!first) json.append(", ");
            json.append("\"SubscriptionPeriod\" : {");
            Duration  subscriptionPeriod = getSubscriptionPeriod();


            json.append(subscriptionPeriod.toJSONFragment());
            json.append("}");
            first = false;
        }
        if (isSetSubscriptionFrequency()) {
            if (!first) json.append(", ");
            json.append("\"SubscriptionFrequency\" : {");
            Duration  subscriptionFrequency = getSubscriptionFrequency();


            json.append(subscriptionFrequency.toJSONFragment());
            json.append("}");
            first = false;
        }
        if (isSetOverrideIPNUrl()) {
            if (!first) json.append(", ");
            json.append(quoteJSON("OverrideIPNUrl"));
            json.append(" : ");
            json.append(quoteJSON(getOverrideIPNUrl()));
            first = false;
        }
        if (isSetSubscriptionStatus()) {
            if (!first) json.append(", ");
            json.append(quoteJSON("SubscriptionStatus"));
            json.append(" : ");
            json.append(quoteJSON(getSubscriptionStatus().value()));
            first = false;
        }
        if (isSetNumberOfTransactionsProcessed()) {
            if (!first) json.append(", ");
            json.append(quoteJSON("NumberOfTransactionsProcessed"));
            json.append(" : ");
            json.append(quoteJSON(getNumberOfTransactionsProcessed() + ""));
            first = false;
        }
        if (isSetRecipientEmail()) {
            if (!first) json.append(", ");
            json.append(quoteJSON("RecipientEmail"));
            json.append(" : ");
            json.append(quoteJSON(getRecipientEmail()));
            first = false;
        }
        if (isSetRecipientName()) {
            if (!first) json.append(", ");
            json.append(quoteJSON("RecipientName"));
            json.append(" : ");
            json.append(quoteJSON(getRecipientName()));
            first = false;
        }
        if (isSetSenderEmail()) {
            if (!first) json.append(", ");
            json.append(quoteJSON("SenderEmail"));
            json.append(" : ");
            json.append(quoteJSON(getSenderEmail()));
            first = false;
        }
        if (isSetSenderName()) {
            if (!first) json.append(", ");
            json.append(quoteJSON("SenderName"));
            json.append(" : ");
            json.append(quoteJSON(getSenderName()));
            first = false;
        }
        if (isSetNextTransactionDate()) {
            if (!first) json.append(", ");
            json.append(quoteJSON("NextTransactionDate"));
            json.append(" : ");
            json.append(quoteJSON(getNextTransactionDate() + ""));
            first = false;
        }
        return json.toString();
    }

    /**
     *
     * Quote JSON string
     */
    private String quoteJSON(String string) {
        StringBuffer sb = new StringBuffer();
        sb.append("\"");
        int length = string.length();
        for (int i = 0; i < length; ++i) {
            char c = string.charAt(i);
            switch (c) {
            case '"':
                sb.append("\\\"");
                break;
            case '\\':
                sb.append("\\\\");
                break;
            case '/':
                sb.append("\\/");
                break;
            case '\b':
                sb.append("\\b");
                break;
            case '\f':
                sb.append("\\f");
                break;
            case '\n':
                sb.append("\\n");
                break;
            case '\r':
                sb.append("\\r");
                break;
            case '\t':
                sb.append("\\t");
                break;
            default:
                if (c <  ' ') {
                    sb.append("\\u" + String.format("%03x", Integer.valueOf(c)));
                } else {
                sb.append(c);
            }
        }
        }
        sb.append("\"");
        return sb.toString();
    }


}
