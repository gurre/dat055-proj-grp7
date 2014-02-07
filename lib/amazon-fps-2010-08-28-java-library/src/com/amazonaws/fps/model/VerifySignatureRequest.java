
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
 *         &lt;element name="UrlEndPoint" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="HttpParameters" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "urlEndPoint",
    "httpParameters"
})
@XmlRootElement(name = "VerifySignatureRequest")
public class VerifySignatureRequest {

    @XmlElement(name = "UrlEndPoint")
    protected String urlEndPoint;
    @XmlElement(name = "HttpParameters")
    protected String httpParameters;

    /**
     * Default constructor
     * 
     */
    public VerifySignatureRequest() {
        super();
    }

    /**
     * Value constructor
     * 
     */
    public VerifySignatureRequest(final String urlEndPoint, final String httpParameters) {
        this.urlEndPoint = urlEndPoint;
        this.httpParameters = httpParameters;
    }

    /**
     * Gets the value of the urlEndPoint property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUrlEndPoint() {
        return urlEndPoint;
    }

    /**
     * Sets the value of the urlEndPoint property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUrlEndPoint(String value) {
        this.urlEndPoint = value;
    }

    public boolean isSetUrlEndPoint() {
        return (this.urlEndPoint!= null);
    }

    /**
     * Gets the value of the httpParameters property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHttpParameters() {
        return httpParameters;
    }

    /**
     * Sets the value of the httpParameters property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHttpParameters(String value) {
        this.httpParameters = value;
    }

    public boolean isSetHttpParameters() {
        return (this.httpParameters!= null);
    }

    /**
     * Sets the value of the UrlEndPoint property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public VerifySignatureRequest withUrlEndPoint(String value) {
        setUrlEndPoint(value);
        return this;
    }

    /**
     * Sets the value of the HttpParameters property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public VerifySignatureRequest withHttpParameters(String value) {
        setHttpParameters(value);
        return this;
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
        if (isSetUrlEndPoint()) {
            if (!first) json.append(", ");
            json.append(quoteJSON("UrlEndPoint"));
            json.append(" : ");
            json.append(quoteJSON(getUrlEndPoint()));
            first = false;
        }
        if (isSetHttpParameters()) {
            if (!first) json.append(", ");
            json.append(quoteJSON("HttpParameters"));
            json.append(" : ");
            json.append(quoteJSON(getHttpParameters()));
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
