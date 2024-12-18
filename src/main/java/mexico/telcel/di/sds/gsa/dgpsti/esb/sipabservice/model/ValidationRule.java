package mexico.telcel.di.sds.gsa.dgpsti.esb.sipabservice.model;

import java.math.BigDecimal;

import javax.xml.datatype.XMLGregorianCalendar;

public class ValidationRule {
    private String rule;
    private String value;
    private String codeVacio;
    private String codeVacioDescripcion;
    private String codeLongitud;
    private String codeLongitudDescripcion;
    private String rango;
    private Integer longitudFinal;
    private BigDecimal valueBigDecimal;
    private XMLGregorianCalendar valueDate;

    public ValidationRule(String rule, String value, String codeVacio, String codeVacioDescripcion, String codeLongitud,
            String codeLongitudDescripcion, String rango) {
        this.rule = rule;
        this.value = value;
        this.codeVacio = codeVacio;
        this.codeVacioDescripcion = codeVacioDescripcion;
        this.codeLongitud = codeLongitud;
        this.codeLongitudDescripcion = codeLongitudDescripcion;
        this.rango = rango;
    }

    public ValidationRule(String rule, BigDecimal valueBigDecimal, String codeVacio, String codeVacioDescripcion, String codeLongitud,
            String codeLongitudDescripcion, Integer longitudfinal ) {
        this.rule = rule;
        this.valueBigDecimal = valueBigDecimal;
        this.codeVacio = codeVacio;
        this.codeVacioDescripcion = codeVacioDescripcion;
        this.codeLongitud = codeLongitud;
        this.codeLongitudDescripcion = codeLongitudDescripcion;
        this.longitudFinal = longitudfinal;
    }

    
    public ValidationRule(String rule, XMLGregorianCalendar valueDate, String codeVacio, String codeVacioDescripcion) {
        this.rule = rule;
        this.codeVacio = codeVacio;
        this.codeVacioDescripcion = codeVacioDescripcion;
        this.valueDate = valueDate;
    }

    public String getRule() {
        return rule;
    }

    public String getValue() {
        return value;
    }

    public String getCodeVacio() {
        return codeVacio;
    }

    public String getCodeVacioDescripcion() {
        return codeVacioDescripcion;
    }

    public String getCodeLongitud() {
        return codeLongitud;
    }

    public String getCodeLongitudDescripcion() {
        return codeLongitudDescripcion;
    }

    public String getRango() {
        return rango;
    }

    public Integer getLongitudFinal() {
        return longitudFinal;
    }

    public BigDecimal getValueBigDecimal() {
        return valueBigDecimal;
    }

    public XMLGregorianCalendar getValueDate() {
        return valueDate;
    }
}
