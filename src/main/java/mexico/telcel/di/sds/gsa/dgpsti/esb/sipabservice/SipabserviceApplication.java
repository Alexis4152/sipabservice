package mexico.telcel.di.sds.gsa.dgpsti.esb.sipabservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@ComponentScan("mexico.telcel.di.sds.gsa.dgpsti.esb.sipabservice")
public class SipabserviceApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(SipabserviceApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(SipabserviceApplication.class, args);
    }

}
