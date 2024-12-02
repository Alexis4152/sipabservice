//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.7 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2024.10.02 a las 12:24:11 AM CDT 
//


package mexico.telcel.di.sds.gsa.dgpsti.esb.sipabservice.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Elemento corporativo complejo
 * 
 * <p>Clase Java para DetailResponseType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="DetailResponseType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="code" type="{http://amx.com/mexico/telcel/esb/v1_2}CodeType"/>
 *         &lt;element name="severityLevel" type="{http://amx.com/mexico/telcel/esb/v1_2}SeverityType" minOccurs="0"/>
 *         &lt;element name="description" type="{http://amx.com/mexico/telcel/esb/v1_2}DescriptionType"/>
 *         &lt;element name="actor" type="{http://amx.com/mexico/telcel/esb/v1_2}ActorType" minOccurs="0"/>
 *         &lt;element name="businessMeaning" type="{http://amx.com/mexico/telcel/esb/v1_2}MeaningType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DetailResponseType", propOrder = {
    "code",
    "severityLevel",
    "description",
    "actor",
    "businessMeaning"
})
public class DetailResponseType {

    @XmlElement(required = true)
    protected String code;
    protected Integer severityLevel;
    @XmlElement(required = true)
    protected String description;
    protected String actor;
    protected String businessMeaning;

    /**
     * Obtiene el valor de la propiedad code.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCode() {
        return code;
    }

    /**
     * Define el valor de la propiedad code.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCode(String value) {
        this.code = value;
    }

    /**
     * Obtiene el valor de la propiedad severityLevel.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getSeverityLevel() {
        return severityLevel;
    }

    /**
     * Define el valor de la propiedad severityLevel.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setSeverityLevel(Integer value) {
        this.severityLevel = value;
    }

    /**
     * Obtiene el valor de la propiedad description.
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
     * Define el valor de la propiedad description.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescription(String value) {
        this.description = value;
    }

    /**
     * Obtiene el valor de la propiedad actor.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getActor() {
        return actor;
    }

    /**
     * Define el valor de la propiedad actor.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setActor(String value) {
        this.actor = value;
    }

    /**
     * Obtiene el valor de la propiedad businessMeaning.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBusinessMeaning() {
        return businessMeaning;
    }

    /**
     * Define el valor de la propiedad businessMeaning.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBusinessMeaning(String value) {
        this.businessMeaning = value;
    }

}
