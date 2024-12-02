package mexico.telcel.di.sds.gsa.dgpsti.esb.sipabservice.config;

import org.xml.sax.EntityResolver;
import org.xml.sax.InputSource;

import java.io.IOException;
import org.springframework.core.io.ClassPathResource;

public class CustomEntityResolver implements EntityResolver {

    @Override
    public InputSource resolveEntity(String publicId, String systemId) throws IOException {
        if (systemId.contains("sipabService_esb_schema1.xsd")) {
            return new InputSource(new ClassPathResource("sipabService_esb_schema1.xsd").getInputStream());
        }
        // Si no es el XSD esperado, devuelve null para el comportamiento estándar
        return null;
    }
}