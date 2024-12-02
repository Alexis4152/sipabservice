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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Clase Java para CrearFolioPetType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="CrearFolioPetType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="serialNo" type="{http://amx.com/mexico/telcel/esb/v1_2}CadenaAlfanumerica20Type"/>
 *         &lt;element name="employeeId" type="{http://www.amx.com.mx/mexico/telcel/di/sds/gsa/dgpsti/esb/sipabservice}CadenaAlfanumerica10Type"/>
 *         &lt;element name="number" type="{http://www.amx.com.mx/mexico/telcel/di/sds/gsa/dgpsti/esb/sipabservice}Decimal10Type"/>
 *         &lt;element name="customerName" type="{http://www.amx.com.mx/mexico/telcel/di/sds/gsa/dgpsti/esb/sipabservice}CadenaAlfanumerica50Type" minOccurs="0"/>
 *         &lt;element name="mobileNo" type="{http://www.amx.com.mx/mexico/telcel/di/sds/gsa/dgpsti/esb/sipabservice}Decimal10Type" minOccurs="0"/>
 *         &lt;element name="timeStamp" type="{http://www.amx.com.mx/mexico/telcel/di/sds/gsa/dgpsti/esb/sipabservice}DateType"/>
 *         &lt;element name="idtroubleTicket" type="{http://www.amx.com.mx/mexico/telcel/di/sds/gsa/dgpsti/esb/sipabservice}Decimal22Type"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "CrearFolioPetType", namespace = "http://www.amx.com.mx/mexico/telcel/di/sds/gsa/dgpsti/esb/sipabservice")
@XmlType(name = "CrearFolioPetType", namespace = "http://www.amx.com.mx/mexico/telcel/di/sds/gsa/dgpsti/esb/sipabservice", propOrder = {
    "serialNo",
    "employeeId",
    "number",
    "customerName",
    "mobileNo",
    "timeStamp",
    "idtroubleTicket"
})
public class CrearFolioPetType {

    @XmlElement(name = "serialNo", namespace = "http://amx.com/mexico/telcel/esb/v1_2", required = true)
    //@XmlElement(namespace = "", required = true)
    protected String serialNo;
    @XmlElement(name = "employeeId", namespace = "http://www.amx.com.mx/mexico/telcel/di/sds/gsa/dgpsti/esb/sipabservice", required = true)
    //@XmlElement(namespace = "", required = true)
    protected String employeeId;
    @XmlElement(name = "number", namespace = "http://www.amx.com.mx/mexico/telcel/di/sds/gsa/dgpsti/esb/sipabservice", required = true)
    //@XmlElement(namespace = "", required = true)
    protected BigDecimal number;
    @XmlElement(name = "customerName", namespace = "http://www.amx.com.mx/mexico/telcel/di/sds/gsa/dgpsti/esb/sipabservice")
    //@XmlElement(namespace = "")
    protected String customerName;
    @XmlElement(name = "mobileNo", namespace = "http://www.amx.com.mx/mexico/telcel/di/sds/gsa/dgpsti/esb/sipabservice")
    //@XmlElement(namespace = "")
    protected BigDecimal mobileNo;
    @XmlElement(name = "timeStamp", namespace = "http://www.amx.com.mx/mexico/telcel/di/sds/gsa/dgpsti/esb/sipabservice", required = true)
    //@XmlElement(namespace = "", required = true)
    protected XMLGregorianCalendar timeStamp;
    @XmlElement(name = "idtroubleTicket", namespace = "http://www.amx.com.mx/mexico/telcel/di/sds/gsa/dgpsti/esb/sipabservice", required = true)
    //@XmlElement(namespace = "", required = true)
    protected BigDecimal idtroubleTicket;

    /**
     * Obtiene el valor de la propiedad serialNo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSerialNo() {
        return serialNo;
    }

    /**
     * Define el valor de la propiedad serialNo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSerialNo(String value) {
        this.serialNo = value;
    }

    /**
     * Obtiene el valor de la propiedad employeeId.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmployeeId() {
        return employeeId;
    }

    /**
     * Define el valor de la propiedad employeeId.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmployeeId(String value) {
        this.employeeId = value;
    }

    /**
     * Obtiene el valor de la propiedad number.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getNumber() {
        return number;
    }

    /**
     * Define el valor de la propiedad number.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setNumber(BigDecimal value) {
        this.number = value;
    }

    /**
     * Obtiene el valor de la propiedad customerName.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCustomerName() {
        return customerName;
    }

    /**
     * Define el valor de la propiedad customerName.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCustomerName(String value) {
        this.customerName = value;
    }

    /**
     * Obtiene el valor de la propiedad mobileNo.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getMobileNo() {
        return mobileNo;
    }

    /**
     * Define el valor de la propiedad mobileNo.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setMobileNo(BigDecimal value) {
        this.mobileNo = value;
    }

    /**
     * Obtiene el valor de la propiedad timeStamp.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getTimeStamp() {
        return timeStamp;
    }

    /**
     * Define el valor de la propiedad timeStamp.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setTimeStamp(XMLGregorianCalendar value) {
        this.timeStamp = value;
    }

    /**
     * Obtiene el valor de la propiedad idtroubleTicket.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getIdtroubleTicket() {
        return idtroubleTicket;
    }

    /**
     * Define el valor de la propiedad idtroubleTicket.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setIdtroubleTicket(BigDecimal value) {
        this.idtroubleTicket = value;
    }

}
