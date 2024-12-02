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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
  

/**
 * <p>Clase Java para CrearFolio complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="CrearFolio">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="controlData" type="{http://amx.com/mexico/telcel/esb/v1_2}ControlDataRequestHeaderType"/>
 *         &lt;element name="crearFolio" type="{http://www.amx.com.mx/mexico/telcel/di/sds/gsa/dgpsti/esb/sipabservice}CrearFolioPetType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "CrearFolio", namespace = "http://www.amx.com.mx/mexico/telcel/di/sds/gsa/dgpsti/esb/sipabservice")
@XmlType(name = "CrearFolio", namespace = "http://www.amx.com.mx/mexico/telcel/di/sds/gsa/dgpsti/esb/sipabservice", propOrder = {
    "controlData",
    "crearFolio"
})
public class CrearFolio {

    @XmlElement(name = "controlData", namespace = "http://amx.com/mexico/telcel/esb/v1_2", required = true)
    //@XmlElement(namespace = "http://www.amx.com.mx/mexico/telcel/di/sds/gsa/dgpsti/esb/sipabservice", required = true)
    protected ControlDataRequestHeaderType controlData;
    @XmlElement(name = "crearFolio", namespace = "http://www.amx.com.mx/mexico/telcel/di/sds/gsa/dgpsti/esb/sipabservice", required = true)
    //@XmlElement(namespace = "http://www.amx.com.mx/mexico/telcel/di/sds/gsa/dgpsti/esb/sipabservice", required = true)
    protected CrearFolioPetType crearFolio;

    /**
     * Obtiene el valor de la propiedad controlData.
     * 
     * @return
     *     possible object is
     *     {@link ControlDataRequestHeaderType }
     *     
     */
    public ControlDataRequestHeaderType getControlData() {
        return controlData;
    }

    /**
     * Define el valor de la propiedad controlData.
     * 
     * @param value
     *     allowed object is
     *     {@link ControlDataRequestHeaderType }
     *     
     */
    public void setControlData(ControlDataRequestHeaderType value) {
        this.controlData = value;
    }

    /**
     * Obtiene el valor de la propiedad crearFolio.
     * 
     * @return
     *     possible object is
     *     {@link CrearFolioPetType }
     *     
     */
    public CrearFolioPetType getCrearFolio() {
        return crearFolio;
    }

    /**
     * Define el valor de la propiedad crearFolio.
     * 
     * @param value
     *     allowed object is
     *     {@link CrearFolioPetType }
     *     
     */
    public void setCrearFolio(CrearFolioPetType value) {
        this.crearFolio = value;
    }

}
