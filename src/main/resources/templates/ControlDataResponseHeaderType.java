//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.7 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2024.10.02 a las 12:24:11 AM CDT 
//


package mexico.telcel.di.sds.gsa.dgpsti.esb.sipabservice.model;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * Dato Corporativo redefinido por las definiciones del nuevo facturador BES. Contiene los datos de control que viajan en la Respuesta de servicios web.
 * 
 * <p>Clase Java para ControlDataResponseHeaderType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="ControlDataResponseHeaderType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="version" type="{http://amx.com/mexico/telcel/esb/v1_2}CadenaAlfanumerica24Type"/>
 *         &lt;element name="resultCode" type="{http://amx.com/mexico/telcel/esb/v1_2}CadenaAlfanumerica20Type"/>
 *         &lt;element name="resultDesc" type="{http://amx.com/mexico/telcel/esb/v1_2}CadenaAlfanumerica1024Type"/>
 *         &lt;element name="additionalProperty" type="{http://amx.com/mexico/telcel/esb/v1_2}BesAdditionalPropertyType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="msgLanguageCode" type="{http://amx.com/mexico/telcel/esb/v1_2}BesCbsLanguageCodeType" minOccurs="0"/>
 *         &lt;element name="messageUUID" type="{http://amx.com/mexico/telcel/esb/v1_2}MessageUUIDType"/>
 *         &lt;element name="responseDate" type="{http://amx.com/mexico/telcel/esb/v1_2}DateTimeType"/>
 *         &lt;element name="sendBy" type="{http://amx.com/mexico/telcel/esb/v1_2}SenderType"/>
 *         &lt;element name="latency" type="{http://amx.com/mexico/telcel/esb/v1_2}LatencyType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ControlDataResponseHeaderType", propOrder = {
    "version",
    "resultCode",
    "resultDesc",
    "additionalProperty",
    "msgLanguageCode",
    "messageUUID",
    "responseDate",
    "sendBy",
    "latency"
})
public class ControlDataResponseHeaderType {

    @XmlElement(required = true)
    protected String version;
    @XmlElement(required = true)
    protected String resultCode;
    @XmlElement(required = true)
    protected String resultDesc;
    protected List<BesAdditionalPropertyType> additionalProperty;
    protected String msgLanguageCode;
    @XmlElement(required = true)
    protected String messageUUID;
    @XmlElement(required = true)
    protected XMLGregorianCalendar responseDate;
    @XmlElement(required = true)
    protected String sendBy;
    protected int latency;

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
     * Obtiene el valor de la propiedad resultCode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getResultCode() {
        return resultCode;
    }

    /**
     * Define el valor de la propiedad resultCode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setResultCode(String value) {
        this.resultCode = value;
    }

    /**
     * Obtiene el valor de la propiedad resultDesc.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getResultDesc() {
        return resultDesc;
    }

    /**
     * Define el valor de la propiedad resultDesc.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setResultDesc(String value) {
        this.resultDesc = value;
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
     * Obtiene el valor de la propiedad msgLanguageCode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMsgLanguageCode() {
        return msgLanguageCode;
    }

    /**
     * Define el valor de la propiedad msgLanguageCode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMsgLanguageCode(String value) {
        this.msgLanguageCode = value;
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
     * Obtiene el valor de la propiedad responseDate.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getResponseDate() {
        return responseDate;
    }

    /**
     * Define el valor de la propiedad responseDate.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setResponseDate(XMLGregorianCalendar value) {
        this.responseDate = value;
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
     * Obtiene el valor de la propiedad latency.
     * 
     */
    public int getLatency() {
        return latency;
    }

    /**
     * Define el valor de la propiedad latency.
     * 
     */
    public void setLatency(int value) {
        this.latency = value;
    }

}
