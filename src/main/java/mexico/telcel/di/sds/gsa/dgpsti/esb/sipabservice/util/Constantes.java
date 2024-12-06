package mexico.telcel.di.sds.gsa.dgpsti.esb.sipabservice.util;

public class Constantes {
    
    public static final String NAMESPACE_URI = "http://www.amx.com.mx/mexico/telcel/di/sds/gsa/dgpsti/esb/sipabservice";

    public enum StatusCode {
        OK(202, "Respuesta éxitosa"),
        ERROR(0, "Respuesta no éxitosa"),
        ERROR_TICKET(100, "No se pudo crear el ticket"),
        ERROR_TICKET_EMPLEADO(101, "No se pudo asociar el ticket con el empleado"),
        VALIDATION(300, "Solicitud incorrecta"),
        EXCEPTCION(500, "Excepcion ocurrida");
    
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
    
}
