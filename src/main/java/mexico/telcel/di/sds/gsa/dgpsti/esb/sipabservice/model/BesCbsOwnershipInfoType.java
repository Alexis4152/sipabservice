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
 * Information about the BE to which customer information belongs.

 * - In the multi-MVNO scenario, the request initiator must set this parameter to information about the BE to which customer information belongs.

 * - In other scenarios, the request initiator sets this parameter to the default BE information.

 * 
 * 
 * <p>Clase Java para BesCbsOwnershipInfoType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="BesCbsOwnershipInfoType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="BEID" type="{http://amx.com/mexico/telcel/esb/v1_2}BesCbsBEIDType"/>
 *         &lt;element name="BRID" type="{http://amx.com/mexico/telcel/esb/v1_2}BesCbsBRIDType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "BesCbsOwnershipInfoType", namespace = "http://amx.com/mexico/telcel/esb/v1_2")
@XmlType(name = "BesCbsOwnershipInfoType", namespace = "http://amx.com/mexico/telcel/esb/v1_2", propOrder = {
    "beid",
    "brid"
})
public class BesCbsOwnershipInfoType {

    @XmlElement(namespace = "http://amx.com/mexico/telcel/esb/v1_2", name = "BEID", required = true)
    protected String beid;
    @XmlElement(namespace = "http://amx.com/mexico/telcel/esb/v1_2", name = "BRID")
    protected String brid;

    /**
     * Obtiene el valor de la propiedad beid.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBEID() {
        return beid;
    }

    /**
     * Define el valor de la propiedad beid.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBEID(String value) {
        this.beid = value;
    }

    /**
     * Obtiene el valor de la propiedad brid.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBRID() {
        return brid;
    }

    /**
     * Define el valor de la propiedad brid.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBRID(String value) {
        this.brid = value;
    }

}
