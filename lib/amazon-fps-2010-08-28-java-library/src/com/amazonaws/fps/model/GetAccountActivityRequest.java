
package com.amazonaws.fps.model;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


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
 *         &lt;element name="MaxBatchSize" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="StartDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="EndDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="SortOrderByDate" type="{http://fps.amazonaws.com/doc/2010-08-28/}SortOrder" minOccurs="0"/>
 *         &lt;element name="FPSOperation" type="{http://fps.amazonaws.com/doc/2010-08-28/}FPSOperation" minOccurs="0"/>
 *         &lt;element name="PaymentMethod" type="{http://fps.amazonaws.com/doc/2010-08-28/}PaymentMethod" minOccurs="0"/>
 *         &lt;element name="Role" type="{http://fps.amazonaws.com/doc/2010-08-28/}TransactionalRole" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="TransactionStatus" type="{http://fps.amazonaws.com/doc/2010-08-28/}TransactionStatus" minOccurs="0"/>
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
    "maxBatchSize",
    "startDate",
    "endDate",
    "sortOrderByDate",
    "fpsOperation",
    "paymentMethod",
    "role",
    "transactionStatus"
})
@XmlRootElement(name = "GetAccountActivityRequest")
public class GetAccountActivityRequest {

    @XmlElement(name = "MaxBatchSize")
    protected Integer maxBatchSize;
    @XmlElement(name = "StartDate")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar startDate;
    @XmlElement(name = "EndDate")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar endDate;
    @XmlElement(name = "SortOrderByDate", defaultValue = "Descending")
    protected SortOrder sortOrderByDate;
    @XmlElement(name = "FPSOperation")
    protected FPSOperation fpsOperation;
    @XmlElement(name = "PaymentMethod")
    protected PaymentMethod paymentMethod;
    @XmlElement(name = "Role")
    protected List<TransactionalRole> role;
    @XmlElement(name = "TransactionStatus")
    protected TransactionStatus transactionStatus;

    /**
     * Default constructor
     * 
     */
    public GetAccountActivityRequest() {
        super();
    }

    /**
     * Value constructor
     * 
     */
    public GetAccountActivityRequest(final Integer maxBatchSize, final XMLGregorianCalendar startDate, final XMLGregorianCalendar endDate, final SortOrder sortOrderByDate, final FPSOperation fpsOperation, final PaymentMethod paymentMethod, final List<TransactionalRole> role, final TransactionStatus transactionStatus) {
        this.maxBatchSize = maxBatchSize;
        this.startDate = startDate;
        this.endDate = endDate;
        this.sortOrderByDate = sortOrderByDate;
        this.fpsOperation = fpsOperation;
        this.paymentMethod = paymentMethod;
        this.role = role;
        this.transactionStatus = transactionStatus;
    }

    /**
     * Gets the value of the maxBatchSize property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getMaxBatchSize() {
        return maxBatchSize;
    }

    /**
     * Sets the value of the maxBatchSize property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setMaxBatchSize(Integer value) {
        this.maxBatchSize = value;
    }

    public boolean isSetMaxBatchSize() {
        return (this.maxBatchSize!= null);
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
     * Gets the value of the sortOrderByDate property.
     * 
     * @return
     *     possible object is
     *     {@link SortOrder }
     *     
     */
    public SortOrder getSortOrderByDate() {
        return sortOrderByDate;
    }

    /**
     * Sets the value of the sortOrderByDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link SortOrder }
     *     
     */
    public void setSortOrderByDate(SortOrder value) {
        this.sortOrderByDate = value;
    }

    public boolean isSetSortOrderByDate() {
        return (this.sortOrderByDate!= null);
    }

    /**
     * Gets the value of the fpsOperation property.
     * 
     * @return
     *     possible object is
     *     {@link FPSOperation }
     *     
     */
    public FPSOperation getFPSOperation() {
        return fpsOperation;
    }

    /**
     * Sets the value of the fpsOperation property.
     * 
     * @param value
     *     allowed object is
     *     {@link FPSOperation }
     *     
     */
    public void setFPSOperation(FPSOperation value) {
        this.fpsOperation = value;
    }

    public boolean isSetFPSOperation() {
        return (this.fpsOperation!= null);
    }

    /**
     * Gets the value of the paymentMethod property.
     * 
     * @return
     *     possible object is
     *     {@link PaymentMethod }
     *     
     */
    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    /**
     * Sets the value of the paymentMethod property.
     * 
     * @param value
     *     allowed object is
     *     {@link PaymentMethod }
     *     
     */
    public void setPaymentMethod(PaymentMethod value) {
        this.paymentMethod = value;
    }

    public boolean isSetPaymentMethod() {
        return (this.paymentMethod!= null);
    }

    /**
     * Gets the value of the role property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the role property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRole().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TransactionalRole }
     * 
     * 
     */
    public List<TransactionalRole> getRole() {
        if (role == null) {
            role = new ArrayList<TransactionalRole>();
        }
        return this.role;
    }

    public boolean isSetRole() {
        return ((this.role!= null)&&(!this.role.isEmpty()));
    }

    public void unsetRole() {
        this.role = null;
    }

    /**
     * Gets the value of the transactionStatus property.
     * 
     * @return
     *     possible object is
     *     {@link TransactionStatus }
     *     
     */
    public TransactionStatus getTransactionStatus() {
        return transactionStatus;
    }

    /**
     * Sets the value of the transactionStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link TransactionStatus }
     *     
     */
    public void setTransactionStatus(TransactionStatus value) {
        this.transactionStatus = value;
    }

    public boolean isSetTransactionStatus() {
        return (this.transactionStatus!= null);
    }

    /**
     * Sets the value of the MaxBatchSize property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public GetAccountActivityRequest withMaxBatchSize(Integer value) {
        setMaxBatchSize(value);
        return this;
    }

    /**
     * Sets the value of the StartDate property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public GetAccountActivityRequest withStartDate(XMLGregorianCalendar value) {
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
    public GetAccountActivityRequest withEndDate(XMLGregorianCalendar value) {
        setEndDate(value);
        return this;
    }

    /**
     * Sets the value of the SortOrderByDate property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public GetAccountActivityRequest withSortOrderByDate(SortOrder value) {
        setSortOrderByDate(value);
        return this;
    }

    /**
     * Sets the value of the FPSOperation property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public GetAccountActivityRequest withFPSOperation(FPSOperation value) {
        setFPSOperation(value);
        return this;
    }

    /**
     * Sets the value of the PaymentMethod property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public GetAccountActivityRequest withPaymentMethod(PaymentMethod value) {
        setPaymentMethod(value);
        return this;
    }

    /**
     * Sets the value of the Role property.
     * 
     * @param values
     * @return
     *     this instance
     */
    public GetAccountActivityRequest withRole(TransactionalRole... values) {
        for (TransactionalRole value: values) {
            getRole().add(value);
        }
        return this;
    }

    /**
     * Sets the value of the TransactionStatus property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public GetAccountActivityRequest withTransactionStatus(TransactionStatus value) {
        setTransactionStatus(value);
        return this;
    }

    /**
     * Sets the value of the role property.
     * 
     * @param role
     *     allowed object is
     *     {@link TransactionalRole }
     *     
     */
    public void setRole(List<TransactionalRole> role) {
        this.role = role;
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
        if (isSetMaxBatchSize()) {
            if (!first) json.append(", ");
            json.append(quoteJSON("MaxBatchSize"));
            json.append(" : ");
            json.append(quoteJSON(getMaxBatchSize() + ""));
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
        if (isSetSortOrderByDate()) {
            if (!first) json.append(", ");
            json.append(quoteJSON("SortOrderByDate"));
            json.append(" : ");
            json.append(quoteJSON(getSortOrderByDate().value()));
            first = false;
        }
        if (isSetFPSOperation()) {
            if (!first) json.append(", ");
            json.append(quoteJSON("FPSOperation"));
            json.append(" : ");
            json.append(quoteJSON(getFPSOperation().value()));
            first = false;
        }
        if (isSetPaymentMethod()) {
            if (!first) json.append(", ");
            json.append(quoteJSON("PaymentMethod"));
            json.append(" : ");
            json.append(quoteJSON(getPaymentMethod().value()));
            first = false;
        }
        if (isSetRole()) {
            if (!first) json.append(", ");
            json.append("\"Role\" : [");
            java.util.List<TransactionalRole> roleList  =  getRole();
            int roleListIndex  =  0;
            for (TransactionalRole role : roleList) {
                if (roleListIndex > 0) json.append(", ");
                    json.append(role.value());
                ++roleListIndex;
            }
            json.append("]");
            first = false;
        }
        if (isSetTransactionStatus()) {
            if (!first) json.append(", ");
            json.append(quoteJSON("TransactionStatus"));
            json.append(" : ");
            json.append(quoteJSON(getTransactionStatus().value()));
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
