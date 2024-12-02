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
 * <p>Clase Java para CrearFolioResponse complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="CrearFolioResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="controlData" type="{http://amx.com/mexico/telcel/esb/v1_2}ControlDataResponseHeaderType"/>
 *         &lt;element name="detailResponse" type="{http://amx.com/mexico/telcel/esb/v1_2}DetailResponseType"/>
 *         &lt;element name="crearFolioResponse" type="{http://www.amx.com.mx/mexico/telcel/di/sds/gsa/dgpsti/esb/sipabservice}CrearFolioRespType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "CrearFolioResponse", namespace = "http://www.amx.com.mx/mexico/telcel/di/sds/gsa/dgpsti/esb/sipabservice")
@XmlType(name = "CrearFolioResponse", namespace = "http://www.amx.com.mx/mexico/telcel/di/sds/gsa/dgpsti/esb/sipabservice", propOrder = {
    "controlData",
    "detailResponse",
    "crearFolioResponse"
})
public class CrearFolioResponse {

    @XmlElement(namespace = "http://amx.com/mexico/telcel/esb/v1_2", required = true)
    protected ControlDataResponseHeaderType controlData;
    @XmlElement(namespace = "http://amx.com/mexico/telcel/esb/v1_2", required = true)
    protected DetailResponseType detailResponse;
    @XmlElement(namespace = "http://www.amx.com.mx/mexico/telcel/di/sds/gsa/dgpsti/esb/sipabservice", required = true)
    protected CrearFolioRespType crearFolioResponse;

    /**
     * Obtiene el valor de la propiedad controlData.
     * 
     * @return
     *     possible object is
     *     {@link ControlDataResponseHeaderType }
     *     
     */
    public ControlDataResponseHeaderType getControlData() {
        return controlData;
    }

    /**
     * Define el valor de la propiedad controlData.
     * 
     * @param value
     *     allowed object is
     *     {@link ControlDataResponseHeaderType }
     *     
     */
    public void setControlData(ControlDataResponseHeaderType value) {
        this.controlData = value;
    }

    /**
     * Obtiene el valor de la propiedad detailResponse.
     * 
     * @return
     *     possible object is
     *     {@link DetailResponseType }
     *     
     */
    public DetailResponseType getDetailResponse() {
        return detailResponse;
    }

    /**
     * Define el valor de la propiedad detailResponse.
     * 
     * @param value
     *     allowed object is
     *     {@link DetailResponseType }
     *     
     */
    public void setDetailResponse(DetailResponseType value) {
        this.detailResponse = value;
    }

    /**
     * Obtiene el valor de la propiedad crearFolioResponse.
     * 
     * @return
     *     possible object is
     *     {@link CrearFolioRespType }
     *     
     */
    public CrearFolioRespType getCrearFolioResponse() {
        return crearFolioResponse;
    }

    /**
     * Define el valor de la propiedad crearFolioResponse.
     * 
     * @param value
     *     allowed object is
     *     {@link CrearFolioRespType }
     *     
     */
    public void setCrearFolioResponse(CrearFolioRespType value) {
        this.crearFolioResponse = value;
    }

}
