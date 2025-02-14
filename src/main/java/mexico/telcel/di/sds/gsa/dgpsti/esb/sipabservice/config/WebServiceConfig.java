package mexico.telcel.di.sds.gsa.dgpsti.esb.sipabservice.config;

import java.util.List;
import java.util.Properties;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.server.EndpointInterceptor;
import org.springframework.ws.server.endpoint.mapping.PayloadRootQNameEndpointMapping;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.XsdSchemaCollection;
import org.springframework.xml.xsd.commons.CommonsXsdSchemaCollection;
import org.springframework.core.io.ClassPathResource;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import mexico.telcel.di.sds.gsa.dgpsti.esb.sipabservice.interceptors.CustomInterceptor;
import mexico.telcel.di.sds.gsa.dgpsti.esb.sipabservice.interceptors.CustomSoapInterceptor;
import mexico.telcel.di.sds.gsa.dgpsti.esb.sipabservice.interceptors.DatabaseExceptionInterceptor;
import org.springframework.ws.soap.server.endpoint.interceptor.PayloadValidatingInterceptor;
import org.springframework.ws.soap.server.endpoint.mapping.SoapActionEndpointMapping;

@EnableWs
@Configuration
public class WebServiceConfig extends WsConfigurerAdapter {

    @Bean
    public ServletRegistrationBean<MessageDispatcherServlet> messageDispatcherServlet(ApplicationContext context) {
        MessageDispatcherServlet servlet = new MessageDispatcherServlet();
        servlet.setApplicationContext(context);
        servlet.setTransformWsdlLocations(true);
        return new ServletRegistrationBean<>(servlet, "/mexico/telcel/di/sds/gsa/dgpsti/esb/*");
    }

    // @Bean
    // public XsdSchema sipabSchema() {
    //     return new SimpleXsdSchema(new ClassPathResource("sipabService_esb_schema1.xsd"));
    // }

     // Definimos XsdSchemaCollection para agrupar los esquemas
     @Bean
     public XsdSchemaCollection schemaCollection() {
         CommonsXsdSchemaCollection collection = new CommonsXsdSchemaCollection(
                 new ClassPathResource("sipabService_esb_schema1.xsd"));
         collection.setInline(true); // Opcional: permite que los esquemas se incluyan en línea en el WSDL
         return collection;
     }

    @Bean(name = "sipabService")
    public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchemaCollection schemaCollection) {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        Properties actions = new Properties();
        actions.setProperty("CrearFolioRequest", "http://www.amx.com.mx/mexico/telcel/di/sds/gsa/dgpsti/esb/sipabservice");
        wsdl11Definition.setSoapActions(actions);
        wsdl11Definition.setPortTypeName("sipabServiceHttpPort");
        wsdl11Definition.setLocationUri("/mexico/telcel/di/sds/gsa/dgpsti/esb/");
        wsdl11Definition.setTargetNamespace("http://www.amx.com.mx/mexico/telcel/di/sds/gsa/dgpsti/esb/sipabservice");
        wsdl11Definition.setSchemaCollection(schemaCollection);
        return wsdl11Definition;
    }





    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath("mexico.telcel.di.sds.gsa.dgpsti.esb.sipabservice.model");
        marshaller.setValidationEventHandler(event -> {
            System.err.println("Validation Error: " + event.getMessage());
            return false; // Detener en el primer error
        });
        return marshaller;
    }

    @Bean
    public WebServiceTemplate webServiceTemplate(Jaxb2Marshaller marshaller) {
        WebServiceTemplate template = new WebServiceTemplate();
        template.setMarshaller(marshaller);
        template.setUnmarshaller(marshaller);
        return template;
    }

    @Bean
    public PayloadValidatingInterceptor validatingInterceptor() {
        PayloadValidatingInterceptor interceptor = new PayloadValidatingInterceptor();
        interceptor.setSchemas(new ClassPathResource("sipabService_esb_schema1.xsd"),
        new ClassPathResource("americamovil_telcel_v1_2.xsd"));
        //Al desactivar estas dos validaciones se recibe de forma adecuada los valores en la request
        interceptor.setValidateRequest(false);
        interceptor.setValidateResponse(false);
        return interceptor;
    }

    //Debido a que en las clases en el paquete model, anteriormente necesitaba ser definido
    //el esquema en cada variable, pero con esto, esas clases solo necesitan tener definida
    //la anotación @XmlRootElement
    //las request funcionan sin practicamente ningun targetNameSpace en sus clases
    //Esto se asegura de que Spring WS mapea correctamente el Body de la solicitud SOAP al objeto CrearFolioRequest
    @Bean
    public PayloadRootQNameEndpointMapping payloadRootQNameEndpointMapping() {
        PayloadRootQNameEndpointMapping mapping = new PayloadRootQNameEndpointMapping();
        mapping.setDefaultEndpoint(new SoapActionEndpointMapping());
        return mapping;
    }


    @Override
    public void addInterceptors(List<EndpointInterceptor> interceptors) {
        interceptors.add(new CustomInterceptor());//Interceptor para mannipular y administrar las excepciones
        interceptors.add(new CustomSoapInterceptor());//Interceptor para errores de validación, creación de ticket y asociación con el empleado
        interceptors.add(new DatabaseExceptionInterceptor());//Interceptor para errores de base de datos
        interceptors.add(validatingInterceptor());//Interceptor para validar las request contra los XSD
    }

}