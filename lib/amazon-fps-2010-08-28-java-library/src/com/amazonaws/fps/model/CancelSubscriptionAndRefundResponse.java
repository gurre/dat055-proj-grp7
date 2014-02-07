
package com.amazonaws.fps.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://fps.amazonaws.com/doc/2010-08-28/}CancelSubscriptionAndRefundResult" minOccurs="0"/>
 *         &lt;element ref="{http://fps.amazonaws.com/doc/2010-08-28/}ResponseMetadata"/>
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
@XmlType(name = "", propOrder = {
    "cancelSubscriptionAndRefundResult",
    "responseMetadata"
})
@XmlRootElement(name = "CancelSubscriptionAndRefundResponse")
public class CancelSubscriptionAndRefundResponse {

    @XmlElement(name = "CancelSubscriptionAndRefundResult")
    protected CancelSubscriptionAndRefundResult cancelSubscriptionAndRefundResult;
    @XmlElement(name = "ResponseMetadata", required = true)
    protected ResponseMetadata responseMetadata;

    /**
     * Default constructor
     * 
     */
    public CancelSubscriptionAndRefundResponse() {
        super();
    }

    /**
     * Value constructor
     * 
     */
    public CancelSubscriptionAndRefundResponse(final CancelSubscriptionAndRefundResult cancelSubscriptionAndRefundResult, final ResponseMetadata responseMetadata) {
        this.cancelSubscriptionAndRefundResult = cancelSubscriptionAndRefundResult;
        this.responseMetadata = responseMetadata;
    }

    /**
     * Gets the value of the cancelSubscriptionAndRefundResult property.
     * 
     * @return
     *     possible object is
     *     {@link CancelSubscriptionAndRefundResult }
     *     
     */
    public CancelSubscriptionAndRefundResult getCancelSubscriptionAndRefundResult() {
        return cancelSubscriptionAndRefundResult;
    }

    /**
     * Sets the value of the cancelSubscriptionAndRefundResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link CancelSubscriptionAndRefundResult }
     *     
     */
    public void setCancelSubscriptionAndRefundResult(CancelSubscriptionAndRefundResult value) {
        this.cancelSubscriptionAndRefundResult = value;
    }

    public boolean isSetCancelSubscriptionAndRefundResult() {
        return (this.cancelSubscriptionAndRefundResult!= null);
    }

    /**
     * Gets the value of the responseMetadata property.
     * 
     * @return
     *     possible object is
     *     {@link ResponseMetadata }
     *     
     */
    public ResponseMetadata getResponseMetadata() {
        return responseMetadata;
    }

    /**
     * Sets the value of the responseMetadata property.
     * 
     * @param value
     *     allowed object is
     *     {@link ResponseMetadata }
     *     
     */
    public void setResponseMetadata(ResponseMetadata value) {
        this.responseMetadata = value;
    }

    public boolean isSetResponseMetadata() {
        return (this.responseMetadata!= null);
    }

    /**
     * Sets the value of the CancelSubscriptionAndRefundResult property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public CancelSubscriptionAndRefundResponse withCancelSubscriptionAndRefundResult(CancelSubscriptionAndRefundResult value) {
        setCancelSubscriptionAndRefundResult(value);
        return this;
    }

    /**
     * Sets the value of the ResponseMetadata property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public CancelSubscriptionAndRefundResponse withResponseMetadata(ResponseMetadata value) {
        setResponseMetadata(value);
        return this;
    }
    

    /**
     * 
     * XML string representation of this object
     * 
     * @return XML String
     */
    public String toXML() {
        StringBuffer xml = new StringBuffer();
        xml.append("<CancelSubscriptionAndRefundResponse xmlns=\"http://fps.amazonaws.com/doc/2010-08-28/\">");
        if (isSetCancelSubscriptionAndRefundResult()) {
            CancelSubscriptionAndRefundResult  cancelSubscriptionAndRefundResult = getCancelSubscriptionAndRefundResult();
            xml.append("<CancelSubscriptionAndRefundResult>");
            xml.append(cancelSubscriptionAndRefundResult.toXMLFragment());
            xml.append("</CancelSubscriptionAndRefundResult>");
        } 
        if (isSetResponseMetadata()) {
            ResponseMetadata  responseMetadata = getResponseMetadata();
            xml.append("<ResponseMetadata>");
            xml.append(responseMetadata.toXMLFragment());
            xml.append("</ResponseMetadata>");
        } 
        xml.append("</CancelSubscriptionAndRefundResponse>");
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
     * JSON string representation of this object
     * 
     * @return JSON String
     */
    public String toJSON() {
        StringBuffer json = new StringBuffer();
        json.append("{\"CancelSubscriptionAndRefundResponse\" : {");
        json.append(quoteJSON("@xmlns"));
        json.append(" : ");
        json.append(quoteJSON("http://fps.amazonaws.com/doc/2010-08-28/"));
        boolean first = true;
        json.append(", ");
        if (isSetCancelSubscriptionAndRefundResult()) {
            if (!first) json.append(", ");
            json.append("\"CancelSubscriptionAndRefundResult\" : {");
            CancelSubscriptionAndRefundResult  cancelSubscriptionAndRefundResult = getCancelSubscriptionAndRefundResult();

            json.append(cancelSubscriptionAndRefundResult.toJSONFragment());
            json.append("}");
            first = false;
        } 
        if (isSetResponseMetadata()) {
            if (!first) json.append(", ");
            json.append("\"ResponseMetadata\" : {");
            ResponseMetadata  responseMetadata = getResponseMetadata();

            json.append(responseMetadata.toJSONFragment());
            json.append("}");
            first = false;
        } 
        json.append("}");
        json.append("}");
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
