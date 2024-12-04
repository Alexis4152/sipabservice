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
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.ws.wsdl.wsdl11.SimpleWsdl11Definition;
import org.springframework.xml.xsd.XsdSchema;
import org.springframework.xml.xsd.XsdSchemaCollection;
import org.springframework.xml.xsd.commons.CommonsXsdSchemaCollection;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.core.io.ClassPathResource;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.resource.ResourceResolver;
import org.springframework.web.servlet.resource.ResourceResolverChain;
import org.w3c.dom.ls.LSResourceResolver;

import mexico.telcel.di.sds.gsa.dgpsti.esb.sipabservice.interceptors.CustomInterceptor;
import mexico.telcel.di.sds.gsa.dgpsti.esb.sipabservice.interceptors.CustomSoapInterceptor;

import org.springframework.core.io.Resource;
import org.springframework.xml.validation.XmlValidator;
import javax.servlet.http.HttpServletRequest;
import org.springframework.ws.soap.server.endpoint.interceptor.PayloadValidatingInterceptor;


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
        // Este es el nombre del puerto que se verá en el WSDL
        Properties actions = new Properties();
        actions.setProperty("CrearFolioRequest", "http://www.amx.com.mx/mexico/telcel/di/sds/gsa/dgpsti/esb/sipabservice");
        wsdl11Definition.setSoapActions(actions);
        wsdl11Definition.setPortTypeName("sipabServiceHttpPort");
        wsdl11Definition.setLocationUri("/mexico/telcel/di/sds/gsa/dgpsti/esb/");
        wsdl11Definition.setTargetNamespace("http://www.amx.com.mx/mexico/telcel/di/sds/gsa/dgpsti/esb/sipabservice");
        wsdl11Definition.setSchemaCollection(schemaCollection);
        return wsdl11Definition;
    }
 

    // @Bean(name = "sipabService")
    // public SimpleWsdl11Definition simpleWsdl11Definition() {
    //     SimpleWsdl11Definition wsdl11Definition = new SimpleWsdl11Definition();
    //    // wsdl11Definition.setWsdl(null);
    //     wsdl11Definition.setWsdl(new ClassPathResource("sipabService_esb.wsdl"));
    //     return wsdl11Definition;
    // }

    
    // public void addResourceHandlers(ResourceHandlerRegistry registry) {
    //     registry.addResourceHandler("/**/*.wsdl", "/**/*.xsd")
    //             .addResourceLocations("classpath:/");
    // }

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

    @Override
    public void addInterceptors(List<EndpointInterceptor> interceptors) {
        interceptors.add(new CustomInterceptor());
        interceptors.add(new CustomSoapInterceptor());
        interceptors.add(validatingInterceptor());
    }

}