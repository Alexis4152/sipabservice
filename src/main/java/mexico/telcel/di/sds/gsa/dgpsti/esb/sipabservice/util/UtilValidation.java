package mexico.telcel.di.sds.gsa.dgpsti.esb.sipabservice.util;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.xml.datatype.XMLGregorianCalendar;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import mexico.telcel.di.sds.gsa.dgpsti.esb.sipabservice.model.ControlDataRequestHeaderType;
import mexico.telcel.di.sds.gsa.dgpsti.esb.sipabservice.model.CrearFolioPetType;
import mexico.telcel.di.sds.gsa.dgpsti.esb.sipabservice.model.ErrorType;
import mexico.telcel.di.sds.gsa.dgpsti.esb.sipabservice.model.ValidationRule;
import mexico.telcel.di.sds.gsa.dgpsti.esb.sipabservice.util.Constantes.ErrorLongitud;
import mexico.telcel.di.sds.gsa.dgpsti.esb.sipabservice.util.Constantes.ErrorVacio;
import mexico.telcel.di.sds.gsa.dgpsti.esb.sipabservice.util.Constantes.Longitud;

public class UtilValidation {

    private static final Logger LOGGER = LogManager.getLogger(UtilValidation.class);

    Util util = new Util();

    public boolean validateLongitudBigDecimal(BigDecimal valor, Integer esperado) {
        int valorReal = valor.unscaledValue().toString().length();
        return valorReal > esperado;
    }

    public boolean validateBigDecimal(BigDecimal valor) {
        return valor != null;
    }

    public boolean validateString(String valor) {
        return valor != null && !valor.isEmpty();
    }

    public boolean validateRango(String valor, String rango) {
        String[] result = rango.split("\\|");
        Integer inicio = Integer.parseInt(result[0]);
        Integer fin = Integer.parseInt(result[1]);
        return valor.length() >= inicio && valor.length() <= fin;
    }

    public static boolean validateDateTime(XMLGregorianCalendar fecha) {
        String fechaStr = fecha.toString();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
        try {
            LocalDateTime.parse(fechaStr, formatter);
            return true; // Si se parsea sin excepciones, es válido
        } catch (DateTimeParseException e) {
            return false; // Si lanza excepción, el formato no es válido
        }
    }
 
    public boolean isDateNull(XMLGregorianCalendar fecha) {
        return fecha != null;
    }

    public List<ErrorType> validateTextos(ValidationRule rule) {
        List<ErrorType> errores = new ArrayList<>();
        if (!validateString(rule.getValue())){
            LOGGER.info("Es vacio o nulo");
            errores.add(util.setErrorType(rule.getCodeVacio(), rule.getCodeVacioDescripcion()));
        }
        if (!validateRango(rule.getValue(), rule.getRango())){
            LOGGER.info("No cumple con el rango {}",rule.getRango());
            errores.add(util.setErrorType(rule.getCodeLongitud(), rule.getCodeLongitudDescripcion()));
        }
        return errores;
    }

    public List<ErrorType> validateNumericos(ValidationRule rule) {
        List<ErrorType> errores = new ArrayList<>();
        if (!validateBigDecimal(rule.getValueBigDecimal())){
            LOGGER.info("Es nulo");
            errores.add(util.setErrorType(rule.getCodeVacio(), rule.getCodeVacioDescripcion()));
        }
        if (validateLongitudBigDecimal(rule.getValueBigDecimal(), rule.getLongitudFinal())){
            LOGGER.info("Es diferente de {}",rule.getLongitudFinal());
            errores.add(util.setErrorType(rule.getCodeLongitud(), rule.getCodeLongitudDescripcion()));
        }
        return errores;
    }

    public List<ErrorType> validateDates(ValidationRule rule) {
        List<ErrorType> errores = new ArrayList<>();
        if (!isDateNull(rule.getValueDate())){
            LOGGER.info("Es nula");
            errores.add(util.setErrorType(rule.getCodeVacio(), rule.getCodeVacioDescripcion()));
        }
        if (validateDateTime(rule.getValueDate())){
            LOGGER.info("No cumple con el formato ");
            errores.add(util.setErrorType(rule.getCodeVacio(), rule.getCodeVacioDescripcion()));
        }
        return errores;
    }


    public Map<String, List<ErrorType>> validate(CrearFolioPetType data, ControlDataRequestHeaderType control) {
        Map<String, List<ErrorType>> response = new HashMap<>();
        List<ErrorType> errores = new ArrayList<>();

        List<ValidationRule> rules = util.setRules(data, control);

        // Aplicar reglas de validación
        for (ValidationRule rule : rules) {
            LOGGER.info("Validando el campo: {}",rule.getRule());

            Map<String, String> val = util.values();
            
            //Se obtiene el tipo de validación respecto al campo
            if (val.get(rule.getRule()).equals("1")) {
                errores.addAll(validateTextos(rule));
            }
            if (val.get(rule.getRule()).equals("2")) {
                errores.addAll(validateNumericos(rule));
            }
            if (val.get(rule.getRule()).equals("3")) {
                errores.addAll(validateDates(rule));
            }
        }

        response.put("errores", errores);

        return response;
    }


}
