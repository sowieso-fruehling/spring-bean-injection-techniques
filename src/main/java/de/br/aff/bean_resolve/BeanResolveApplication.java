package de.br.aff.bean_resolve;

import de.br.aff.bean_resolve.bean_resolving.active_profile_based.ApbInterface;
import de.br.aff.bean_resolve.bean_resolving.bean_name_based.BnbInterface;
import de.br.aff.bean_resolve.bean_resolving.custom_qualifier_based.CqInterface;
import de.br.aff.bean_resolve.bean_resolving.custom_qualifier_based.UseFirstImplementation;
import de.br.aff.bean_resolve.bean_resolving.primary_based.PbInterface;
import de.br.aff.bean_resolve.bean_resolving.qualifier_based.QbInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.test.context.ActiveProfiles;

@SpringBootApplication
@ActiveProfiles("first-implementation") //affects only 5th approach)
//constructor injection is not possible in this class
public class BeanResolveApplication implements CommandLineRunner {

    // 1. approach (Bean name based)
    @Autowired //it resolves successfully because the bean name is the same as it's type (BnbFirstImplementation = bnbFirstImplementation)
    //but this way, it's hardcoded, we have no use of having an interface, also refactoring implementation class name could cause problems
    //all beans implementing QbInterface will be added into ApplicationContext
    private BnbInterface bnbFirstImplementation;

    // 2. approach (uses @Qualifier annotation)
    @Autowired @Qualifier("qbFirstImplementation")  // this way, it's hardcoded,but we can use interface, but refactoring implementation class name would cause problems
    //all beans implementing QbInterface will be added into ApplicationContext
    private QbInterface quailifierBased;

    // 3. approach (uses Custom qualifier annotation)
    @Autowired @UseFirstImplementation// this way, it's hardcoded, but we can use interface and refactoring implementation class won't cause problems.
                                    // It also requires more code ( creating annotation, adding it on implementation class and here)
    //all beans implementing CqInterface will be added into ApplicationContext
    private CqInterface customQuailifierBased;

    // 4. approach (uses @Primary)
    @Autowired // this way, it's hardcoded, but we can use interface and refactoring implementation class won't cause problems.
    //all beans implementing PbInterface will be added into ApplicationContext
    private PbInterface primaryAnnotationBased;

    // 5. approach (uses @ActiveProfile - we have to annotate our this ( BeanResolveApplication) class with it)
    @Autowired //it's defined configuration file, we can use interface and refactoring implementation class won't cause problems
    //Only here all other beans won't be added into ApplicationContext ( all other beans that don't have @Profile with value provided in @ActiveProfiles)
    //With this approach, it's necessary to put @Profile annotation on every bean implementing ApbInterface. Workaround is to combine this one with @Primary
    //annotation. Beans annotated with both of these would always have a priority if their profile is set to @ActiveProfile
    private ApbInterface activeProfileBased;

    public static void main(String[] args) {
        SpringApplication app=new SpringApplication(BeanResolveApplication.class);
        //disabling SpringBoot logo being written in console
        app.setBannerMode(Banner.Mode.OFF);
        app.run();
    }

    @Override
    public void run(String... args) throws Exception {
        bnbFirstImplementation.logSomething();

        quailifierBased.logSomething();

        customQuailifierBased.logSomething();

        primaryAnnotationBased.logSomething();

        activeProfileBased.logSomething();
    }
}
