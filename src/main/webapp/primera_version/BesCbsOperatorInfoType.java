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
 * Information about an operator who initiates a service.
 * 
 * <p>Clase Java para BesCbsOperatorInfoType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="BesCbsOperatorInfoType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="operatorID" type="{http://amx.com/mexico/telcel/esb/v1_2}CadenaType"/>
 *         &lt;element name="channelID" type="{http://amx.com/mexico/telcel/esb/v1_2}CadenaType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "BesCbsOperatorInfoType", namespace = "http://amx.com/mexico/telcel/esb/v1_2")
@XmlType(name = "BesCbsOperatorInfoType", namespace = "http://amx.com/mexico/telcel/esb/v1_2", propOrder = {
    "operatorID",
    "channelID"
})
public class BesCbsOperatorInfoType {

    @XmlElement(namespace = "http://amx.com/mexico/telcel/esb/v1_2", required = true)
    protected String operatorID;
    @XmlElement(namespace = "http://amx.com/mexico/telcel/esb/v1_2")
    protected String channelID;

    /**
     * Obtiene el valor de la propiedad operatorID.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOperatorID() {
        return operatorID;
    }

    /**
     * Define el valor de la propiedad operatorID.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOperatorID(String value) {
        this.operatorID = value;
    }

    /**
     * Obtiene el valor de la propiedad channelID.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getChannelID() {
        return channelID;
    }

    /**
     * Define el valor de la propiedad channelID.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setChannelID(String value) {
        this.channelID = value;
    }

}
