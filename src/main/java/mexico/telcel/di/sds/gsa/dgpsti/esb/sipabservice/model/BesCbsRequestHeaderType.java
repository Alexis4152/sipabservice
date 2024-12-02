//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.7 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2024.11.24 a las 04:17:51 PM CST 
//


package mexico.telcel.di.sds.gsa.dgpsti.esb.sipabservice.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Request Message Header for CBS API services. BES Project.
 * 
 * <p>Clase Java para BesCbsRequestHeaderType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="BesCbsRequestHeaderType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ownershipInfo" type="{http://amx.com/mexico/telcel/esb/v1_2}BesCbsOwnershipInfoType" minOccurs="0"/>
 *         &lt;element name="operatorInfo" type="{http://amx.com/mexico/telcel/esb/v1_2}BesCbsOperatorInfoType" minOccurs="0"/>
 *         &lt;element name="accessMode" type="{http://amx.com/mexico/telcel/esb/v1_2}CadenaType" minOccurs="0"/>
 *         &lt;element name="msgLanguageCode" type="{http://amx.com/mexico/telcel/esb/v1_2}CadenaType" minOccurs="0"/>
 *         &lt;element name="timeFormat" type="{http://amx.com/mexico/telcel/esb/v1_2}BesCbsTimeFormatType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "BesCbsRequestHeaderType", namespace = "http://amx.com/mexico/telcel/esb/v1_2")
@XmlType(name = "BesCbsRequestHeaderType", namespace = "http://amx.com/mexico/telcel/esb/v1_2", propOrder = {
    "ownershipInfo",
    "operatorInfo",
    "accessMode",
    "msgLanguageCode",
    "timeFormat"
})
public class BesCbsRequestHeaderType {

    @XmlElement(name = "ownershipInfo", namespace = "http://amx.com/mexico/telcel/esb/v1_2")
    protected BesCbsOwnershipInfoType ownershipInfo;
    @XmlElement(name = "operatorInfo", namespace = "http://amx.com/mexico/telcel/esb/v1_2")
    protected BesCbsOperatorInfoType operatorInfo;
    @XmlElement(name = "accessMode", namespace = "http://amx.com/mexico/telcel/esb/v1_2")
    protected String accessMode;
    @XmlElement(name = "msgLanguageCode", namespace = "http://amx.com/mexico/telcel/esb/v1_2")
    protected String msgLanguageCode;
    @XmlElement(name = "timeFormat", namespace = "http://amx.com/mexico/telcel/esb/v1_2")
    protected BesCbsTimeFormatType timeFormat;

    /**
     * Obtiene el valor de la propiedad ownershipInfo.
     * 
     * @return
     *     possible object is
     *     {@link BesCbsOwnershipInfoType }
     *     
     */
    public BesCbsOwnershipInfoType getOwnershipInfo() {
        return ownershipInfo;
    }

    /**
     * Define el valor de la propiedad ownershipInfo.
     * 
     * @param value
     *     allowed object is
     *     {@link BesCbsOwnershipInfoType }
     *     
     */
    public void setOwnershipInfo(BesCbsOwnershipInfoType value) {
        this.ownershipInfo = value;
    }

    /**
     * Obtiene el valor de la propiedad operatorInfo.
     * 
     * @return
     *     possible object is
     *     {@link BesCbsOperatorInfoType }
     *     
     */
    public BesCbsOperatorInfoType getOperatorInfo() {
        return operatorInfo;
    }

    /**
     * Define el valor de la propiedad operatorInfo.
     * 
     * @param value
     *     allowed object is
     *     {@link BesCbsOperatorInfoType }
     *     
     */
    public void setOperatorInfo(BesCbsOperatorInfoType value) {
        this.operatorInfo = value;
    }

    /**
     * Obtiene el valor de la propiedad accessMode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAccessMode() {
        return accessMode;
    }

    /**
     * Define el valor de la propiedad accessMode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAccessMode(String value) {
        this.accessMode = value;
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
     * Obtiene el valor de la propiedad timeFormat.
     * 
     * @return
     *     possible object is
     *     {@link BesCbsTimeFormatType }
     *     
     */
    public BesCbsTimeFormatType getTimeFormat() {
        return timeFormat;
    }

    /**
     * Define el valor de la propiedad timeFormat.
     * 
     * @param value
     *     allowed object is
     *     {@link BesCbsTimeFormatType }
     *     
     */
    public void setTimeFormat(BesCbsTimeFormatType value) {
        this.timeFormat = value;
    }

}
