//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.7 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2024.11.24 a las 04:17:51 PM CST 
//


package mexico.telcel.di.sds.gsa.dgpsti.esb.sipabservice.model;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para CrearFolioRespType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="CrearFolioRespType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="idResp" type="{http://amx.com/mexico/telcel/esb/v1_2}CadenaAlfanumerica20Type"/>
 *         &lt;element name="descResp" type="{http://www.amx.com.mx/mexico/telcel/di/sds/gsa/dgpsti/esb/sipabservice}CadenaAlfanumerica1000Type"/>
 *         &lt;element name="idFolio" type="{http://www.amx.com.mx/mexico/telcel/di/sds/gsa/dgpsti/esb/sipabservice}Decimal22Type" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "CrearFolioRespType", namespace = "http://www.amx.com.mx/mexico/telcel/di/sds/gsa/dgpsti/esb/sipabservice")
@XmlType(name = "CrearFolioRespType", namespace = "http://www.amx.com.mx/mexico/telcel/di/sds/gsa/dgpsti/esb/sipabservice", propOrder = {
    "idResp",
    "descResp",
    "idFolio"
})
public class CrearFolioRespType {

    @XmlElement(namespace = "http://amx.com/mexico/telcel/esb/v1_2", required = true)
    protected String idResp;
    @XmlElement(namespace = "http://www.amx.com.mx/mexico/telcel/di/sds/gsa/dgpsti/esb/sipabservice", required = true)
    protected String descResp;
    @XmlElement(namespace = "http://www.amx.com.mx/mexico/telcel/di/sds/gsa/dgpsti/esb/sipabservice")
    protected BigDecimal idFolio;

    /**
     * Obtiene el valor de la propiedad idResp.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdResp() {
        return idResp;
    }

    /**
     * Define el valor de la propiedad idResp.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdResp(String value) {
        this.idResp = value;
    }

    /**
     * Obtiene el valor de la propiedad descResp.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescResp() {
        return descResp;
    }

    /**
     * Define el valor de la propiedad descResp.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescResp(String value) {
        this.descResp = value;
    }

    /**
     * Obtiene el valor de la propiedad idFolio.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getIdFolio() {
        return idFolio;
    }

    /**
     * Define el valor de la propiedad idFolio.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setIdFolio(BigDecimal value) {
        this.idFolio = value;
    }

}
