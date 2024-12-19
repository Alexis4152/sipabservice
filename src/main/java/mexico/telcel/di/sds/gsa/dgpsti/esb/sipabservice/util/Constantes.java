package mexico.telcel.di.sds.gsa.dgpsti.esb.sipabservice.util;

public class Constantes {
    
    public static final String NAMESPACE_URI = "http://www.amx.com.mx/mexico/telcel/di/sds/gsa/dgpsti/esb/sipabservice";
    public static final String PATRON_FECHA = "YYYY-MM-DDThh:mm:ss";
    public static final String EXCEPTION = "exception";


    public enum SeverityLevel {
        VALIDATION(1),
        NEGOCIO(2),
        EXCEPTCION(3);

        private final int code;

        SeverityLevel(int code){
            this.code = code;
        }

        public int getCode() {
            return code;
        }
    }

    public enum StatusCode {
        OK(202, "Respuesta éxitosa"),
        ERROR(0, "Respuesta no éxitosa"),
        ERROR_TICKET(100, "No se pudo crear el ticket"),
        ERROR_TICKET_EMPLEADO(101, "No se pudo asociar el ticket con el empleado"),
        // EXCEPTCION(500, "Excepcion ocurrida"),
        VALIDATION(300, "Error de validación");
    
        private final int code;
        private final String description;
    
        StatusCode(int code, String description) {
            this.code = code;
            this.description = description;
        }
    
        public int getCode() {
            return code;
        }
    
        public String getDescription() {
            return description;
        }
    
    }

    public enum ErrorVacio {
        SERIAL_NO("301", "El campo 'serialNo' está vacío o nulo"),
        EMPLOYEE_ID("302", "El campo 'employeeId' está vacío o nulo"),
        NUMBER("303", "El campo 'number' está vacío o nulo"),
        CUSTOMER_NAME("304", "El campo 'customerName' está vacío o nulo"),
        MOBILE_NO("305", "El campo 'mobileNo' está vacío o nulo"),
        TIMESTAMP("306", "El campo 'timeStamp' está vacío o nulo"),
        TROUBLE_TICKET_ID("307", "El campo 'idtroubleTicket' está vacío o nulo"),
        VERSION("308", "El campo 'version' está vacío o nulo"),
        MESSAGE_UUID("309", "El campo 'messageUUID' está vacío o nulo"),
        REQUEST_DATE("310", "El campo 'requestDate' está vacío o nulo"),
        SEND_BY("311", "El campo 'sendBy' está vacío o nulo"),
        NO_BIGDECIMAL("312", "no es BigDeicmal"),
        NO_XMLGREGORYCALENDAR("313", "no es XmlGregorianCalendar yyyy-MM-ddTHH:mm:ss");

        private final String code;
        private final String description;
    
        ErrorVacio(String code, String description) {
            this.code = code;
            this.description = description;
        }
    
        public String getCode() {
            return code;
        }
    
        public String getDescription() {
            return description;
        }
    }
    
    public enum ErrorLongitud {
        SERIAL_NO("314", "El campo 'serialNo' no cumple con la longitud requerida de 0-20"),
        EMPLOYEE_ID("315", "El campo 'employeeId' no cumple con la longitud requerida de 0-10"),
        NUMBER("316", "El campo 'number' no cumple con la longitud requerida de 10"),
        CUSTOMER_NAME("317", "El campo 'customerName' no cumple con la longitud requerida 0-50"),
        MOBILE_NO("318", "El campo 'mobileNo' no cumple con la longitud requerida de 10"),
        TROUBLE_TICKET_ID("319", "El campo 'idtroubleTicket' no cumple con la longitud requerida de 22"),
        VERSION("320", "El campo 'version' no cumple con la longitud requerida de 0-24"),
        MESSAGE_UUID("321", "El campo 'messageUUID' no cumple con la longitud requerida de 1-128"),
        SEND_BY("322", "El campo 'sendBy' no cumple con la longitud requerida de 3-32");
    
        private final String code;
        private final String description;
    
        ErrorLongitud(String code, String description) {
            this.code = code;
            this.description = description;
        }
    
        public String getCode() {
            return code;
        }
    
        public String getDescription() {
            return description;
        }
    }
    
    public enum ErrorDataBase {
        GENERICO("400", "Error en base de datos:"),
        PAASWORD_INCORRECTO("401", "El password de la base de datos es incorrecto"),
        PASSWORD_EXPIRADO("402", "El password de la base de datos expiró"),
        ESTRUCTURA_GRAMATICA("403", "Error en la estructura o gramatica sql"),
        DUPLICADO("404", "El ticket ya se encuentra creado"),
        TIME_OUT("405", "No se pudo conectar a la base de datos");
    
        private final String code;
        private final String description;
    
        ErrorDataBase(String code, String description) {
            this.code = code;
            this.description = description;
        }
    
        public String getCode() {
            return code;
        }
    
        public String getDescription() {
            return description;
        }
    }

    public enum Longitud {
        VERSION("0|24"),
        MESSAGE_UUID("1|128"),
        SERIAL_NO("0|20"),
        EMPLOYEE_ID("0|10"),
        CUSTOMER_NAME("0|50"),
        SEND_BY("3|32");

        private final String rango;
    
        Longitud(String rango) {
            this.rango = rango;
        }

        public String getRango() {
            return rango;
        }

    }
    
}
