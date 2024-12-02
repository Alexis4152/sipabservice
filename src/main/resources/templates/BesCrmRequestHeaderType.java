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
 * Request Message Header for CRM API services. BES Project.
 * 
 * <p>Clase Java para BesCrmRequestHeaderType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="BesCrmRequestHeaderType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="beId" type="{http://amx.com/mexico/telcel/esb/v1_2}Decimal20Type"/>
 *         &lt;element name="regionId" type="{http://amx.com/mexico/telcel/esb/v1_2}Decimal20Type"/>
 *         &lt;element name="operatorInfo" type="{http://amx.com/mexico/telcel/esb/v1_2}BesCrmOperatorInfoType" minOccurs="0"/>
 *         &lt;element name="channelType" type="{http://amx.com/mexico/telcel/esb/v1_2}BesCrmChannelType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BesCrmRequestHeaderType", propOrder = {
    "beId",
    "regionId",
    "operatorInfo",
    "channelType"
})
public class BesCrmRequestHeaderType {

    @XmlElement(required = true)
    protected BigDecimal beId;
    @XmlElement(required = true)
    protected BigDecimal regionId;
    protected BesCrmOperatorInfoType operatorInfo;
    @XmlElement(required = true)
    protected String channelType;

    /**
     * Obtiene el valor de la propiedad beId.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getBeId() {
        return beId;
    }

    /**
     * Define el valor de la propiedad beId.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setBeId(BigDecimal value) {
        this.beId = value;
    }

    /**
     * Obtiene el valor de la propiedad regionId.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getRegionId() {
        return regionId;
    }

    /**
     * Define el valor de la propiedad regionId.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setRegionId(BigDecimal value) {
        this.regionId = value;
    }

    /**
     * Obtiene el valor de la propiedad operatorInfo.
     * 
     * @return
     *     possible object is
     *     {@link BesCrmOperatorInfoType }
     *     
     */
    public BesCrmOperatorInfoType getOperatorInfo() {
        return operatorInfo;
    }

    /**
     * Define el valor de la propiedad operatorInfo.
     * 
     * @param value
     *     allowed object is
     *     {@link BesCrmOperatorInfoType }
     *     
     */
    public void setOperatorInfo(BesCrmOperatorInfoType value) {
        this.operatorInfo = value;
    }

    /**
     * Obtiene el valor de la propiedad channelType.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getChannelType() {
        return channelType;
    }

    /**
     * Define el valor de la propiedad channelType.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setChannelType(String value) {
        this.channelType = value;
    }

}
