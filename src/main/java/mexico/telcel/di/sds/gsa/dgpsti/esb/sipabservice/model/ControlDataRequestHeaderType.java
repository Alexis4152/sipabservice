//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.7 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2024.11.24 a las 04:17:51 PM CST 
//


package mexico.telcel.di.sds.gsa.dgpsti.esb.sipabservice.model;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * Dato Corporativo redefinido por las definiciones del nuevo facturador BES. Contiene los datos de control que viajan en la Peticiones de servicios web.
 * 
 * <p>Clase Java para ControlDataRequestHeaderType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="ControlDataRequestHeaderType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="version" type="{http://amx.com/mexico/telcel/esb/v1_2}CadenaAlfanumerica24Type"/>
 *         &lt;element name="businessCode" type="{http://amx.com/mexico/telcel/esb/v1_2}CadenaAlfanumerica128Type" minOccurs="0"/>
 *         &lt;element name="messageUUID" type="{http://amx.com/mexico/telcel/esb/v1_2}MessageUUIDType"/>
 *         &lt;element name="additionalProperty" type="{http://amx.com/mexico/telcel/esb/v1_2}BesAdditionalPropertyType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="requestDate" type="{http://amx.com/mexico/telcel/esb/v1_2}DateTimeType"/>
 *         &lt;element name="sendBy" type="{http://amx.com/mexico/telcel/esb/v1_2}SenderType"/>
 *         &lt;element name="ipClient" type="{http://amx.com/mexico/telcel/esb/v1_2}IPv4AddressType" minOccurs="0"/>
 *         &lt;element name="ipServer" type="{http://amx.com/mexico/telcel/esb/v1_2}IPv4AddressType" minOccurs="0"/>
 *         &lt;element name="user" type="{http://amx.com/mexico/telcel/esb/v1_2}UserType" minOccurs="0"/>
 *         &lt;element name="besCbsRequestHeader" type="{http://amx.com/mexico/telcel/esb/v1_2}BesCbsRequestHeaderType" minOccurs="0"/>
 *         &lt;element name="besCrmRequestHeader" type="{http://amx.com/mexico/telcel/esb/v1_2}BesCrmRequestHeaderType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "ControlDataRequestHeaderType", namespace = "http://amx.com/mexico/telcel/esb/v1_2")
@XmlType(name = "ControlDataRequestHeaderType", namespace = "http://amx.com/mexico/telcel/esb/v1_2", propOrder = {
    "version",
    "businessCode",
    "messageUUID",
    "additionalProperty",
    "requestDate",
    "sendBy",
    "ipClient",
    "ipServer",
    "user",
    "besCbsRequestHeader",
    "besCrmRequestHeader"
})
public class ControlDataRequestHeaderType {

    @XmlElement(name = "version", namespace = "http://amx.com/mexico/telcel/esb/v1_2", required = true)
    protected String version;
    @XmlElement(name = "businessCode", namespace = "http://amx.com/mexico/telcel/esb/v1_2")
    protected String businessCode;
    @XmlElement(name = "messageUUID", namespace = "http://amx.com/mexico/telcel/esb/v1_2", required = true)
    protected String messageUUID;
    @XmlElement(name = "additionalProperty", namespace = "http://amx.com/mexico/telcel/esb/v1_2")
    protected List<BesAdditionalPropertyType> additionalProperty;
    @XmlElement(name = "requestDate", namespace = "http://amx.com/mexico/telcel/esb/v1_2", required = true)
    protected XMLGregorianCalendar requestDate;
    @XmlElement(name = "sendBy", namespace = "http://amx.com/mexico/telcel/esb/v1_2", required = true)
    protected String sendBy;
    @XmlElement(name = "ipClient", namespace = "http://amx.com/mexico/telcel/esb/v1_2")
    protected String ipClient;
    @XmlElement(name = "ipServer", namespace = "http://amx.com/mexico/telcel/esb/v1_2")
    protected String ipServer;
    @XmlElement(name = "user", namespace = "http://amx.com/mexico/telcel/esb/v1_2")
    protected String user;
    @XmlElement(name = "besCbsRequestHeader", namespace = "http://amx.com/mexico/telcel/esb/v1_2")
    protected BesCbsRequestHeaderType besCbsRequestHeader;
    @XmlElement(name = "besCrmRequestHeader", namespace = "http://amx.com/mexico/telcel/esb/v1_2")
    protected BesCrmRequestHeaderType besCrmRequestHeader;

    /**
     * Obtiene el valor de la propiedad version.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVersion() {
        return version;
    }

    /**
     * Define el valor de la propiedad version.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVersion(String value) {
        this.version = value;
    }

    /**
     * Obtiene el valor de la propiedad businessCode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBusinessCode() {
        return businessCode;
    }

    /**
     * Define el valor de la propiedad businessCode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBusinessCode(String value) {
        this.businessCode = value;
    }

    /**
     * Obtiene el valor de la propiedad messageUUID.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMessageUUID() {
        return messageUUID;
    }

    /**
     * Define el valor de la propiedad messageUUID.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMessageUUID(String value) {
        this.messageUUID = value;
    }

    /**
     * Gets the value of the additionalProperty property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the additionalProperty property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAdditionalProperty().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link BesAdditionalPropertyType }
     * 
     * 
     */
    public List<BesAdditionalPropertyType> getAdditionalProperty() {
        if (additionalProperty == null) {
            additionalProperty = new ArrayList<BesAdditionalPropertyType>();
        }
        return this.additionalProperty;
    }

    /**
     * Obtiene el valor de la propiedad requestDate.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getRequestDate() {
        return requestDate;
    }

    /**
     * Define el valor de la propiedad requestDate.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setRequestDate(XMLGregorianCalendar value) {
        this.requestDate = value;
    }

    /**
     * Obtiene el valor de la propiedad sendBy.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSendBy() {
        return sendBy;
    }

    /**
     * Define el valor de la propiedad sendBy.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSendBy(String value) {
        this.sendBy = value;
    }

    /**
     * Obtiene el valor de la propiedad ipClient.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIpClient() {
        return ipClient;
    }

    /**
     * Define el valor de la propiedad ipClient.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIpClient(String value) {
        this.ipClient = value;
    }

    /**
     * Obtiene el valor de la propiedad ipServer.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIpServer() {
        return ipServer;
    }

    /**
     * Define el valor de la propiedad ipServer.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIpServer(String value) {
        this.ipServer = value;
    }

    /**
     * Obtiene el valor de la propiedad user.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUser() {
        return user;
    }

    /**
     * Define el valor de la propiedad user.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUser(String value) {
        this.user = value;
    }

    /**
     * Obtiene el valor de la propiedad besCbsRequestHeader.
     * 
     * @return
     *     possible object is
     *     {@link BesCbsRequestHeaderType }
     *     
     */
    public BesCbsRequestHeaderType getBesCbsRequestHeader() {
        return besCbsRequestHeader;
    }

    /**
     * Define el valor de la propiedad besCbsRequestHeader.
     * 
     * @param value
     *     allowed object is
     *     {@link BesCbsRequestHeaderType }
     *     
     */
    public void setBesCbsRequestHeader(BesCbsRequestHeaderType value) {
        this.besCbsRequestHeader = value;
    }

    /**
     * Obtiene el valor de la propiedad besCrmRequestHeader.
     * 
     * @return
     *     possible object is
     *     {@link BesCrmRequestHeaderType }
     *     
     */
    public BesCrmRequestHeaderType getBesCrmRequestHeader() {
        return besCrmRequestHeader;
    }

    /**
     * Define el valor de la propiedad besCrmRequestHeader.
     * 
     * @param value
     *     allowed object is
     *     {@link BesCrmRequestHeaderType }
     *     
     */
    public void setBesCrmRequestHeader(BesCrmRequestHeaderType value) {
        this.besCrmRequestHeader = value;
    }

}
