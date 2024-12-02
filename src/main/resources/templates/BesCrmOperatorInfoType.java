//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.7 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2024.10.02 a las 12:24:11 AM CDT 
//


package mexico.telcel.di.sds.gsa.dgpsti.esb.sipabservice.model;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Information of the operator who initiates the operation. For selfcare channels, it is optional.
 * 
 * <p>Clase Java para BesCrmOperatorInfoType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="BesCrmOperatorInfoType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="operatorCode" type="{http://amx.com/mexico/telcel/esb/v1_2}CadenaAlfanumerica1a20Type"/>
 *         &lt;element name="orgId" type="{http://amx.com/mexico/telcel/esb/v1_2}Decimal20Type"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BesCrmOperatorInfoType", propOrder = {
    "operatorCode",
    "orgId"
})
public class BesCrmOperatorInfoType {

    @XmlElement(required = true)
    protected String operatorCode;
    @XmlElement(required = true)
    protected BigDecimal orgId;

    /**
     * Obtiene el valor de la propiedad operatorCode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOperatorCode() {
        return operatorCode;
    }

    /**
     * Define el valor de la propiedad operatorCode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOperatorCode(String value) {
        this.operatorCode = value;
    }

    /**
     * Obtiene el valor de la propiedad orgId.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getOrgId() {
        return orgId;
    }

    /**
     * Define el valor de la propiedad orgId.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setOrgId(BigDecimal value) {
        this.orgId = value;
    }

}
