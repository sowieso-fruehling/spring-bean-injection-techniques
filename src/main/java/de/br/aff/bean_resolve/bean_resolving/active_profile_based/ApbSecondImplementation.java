package de.br.aff.bean_resolve.bean_resolving.active_profile_based;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@Profile("second-implementation")
public class ApbSecondImplementation implements ApbInterface {

    public ApbSecondImplementation() {
        log.info(this + " created");
    }

    @Override
    public void logSomething() {
        log.info(this + " currently logging");
    }
}
