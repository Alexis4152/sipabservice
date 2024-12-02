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
import javax.xml.bind.annotation.XmlType;


/**
 * Objeto perteneciente al Contrato Corporativo TELCEL v1.2. Representacion de un mensaje de error.
 * 
 * <p>Clase Java para ErrorType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="ErrorType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="code" type="{http://amx.com/mexico/telcel/esb/v1_2}CodeType"/>
 *         &lt;element name="severityLevel" type="{http://amx.com/mexico/telcel/esb/v1_2}SeverityType"/>
 *         &lt;element name="description" type="{http://amx.com/mexico/telcel/esb/v1_2}DescriptionType"/>
 *         &lt;element name="actor" type="{http://amx.com/mexico/telcel/esb/v1_2}ActorType" minOccurs="0"/>
 *         &lt;element name="businessMeaning" type="{http://amx.com/mexico/telcel/esb/v1_2}MeaningType"/>
 *         &lt;element name="properties" type="{http://amx.com/mexico/telcel/esb/v1_2}PropertyErrorType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ErrorType", propOrder = {
    "code",
    "severityLevel",
    "description",
    "actor",
    "businessMeaning",
    "properties"
})
public class ErrorType {

    @XmlElement(required = true)
    protected String code;
    protected int severityLevel;
    @XmlElement(required = true)
    protected String description;
    protected String actor;
    @XmlElement(required = true)
    protected String businessMeaning;
    protected List<PropertyErrorType> properties;

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
     */
    public int getSeverityLevel() {
        return severityLevel;
    }

    /**
     * Define el valor de la propiedad severityLevel.
     * 
     */
    public void setSeverityLevel(int value) {
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

    /**
     * Gets the value of the properties property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the properties property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getProperties().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PropertyErrorType }
     * 
     * 
     */
    public List<PropertyErrorType> getProperties() {
        if (properties == null) {
            properties = new ArrayList<PropertyErrorType>();
        }
        return this.properties;
    }

}
