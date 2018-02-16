package de.br.aff.bean_resolve.bean_resolving.primary_based;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@Primary
public class PbFirstImplementation implements PbInterface {

    public PbFirstImplementation() {
        log.info(this + " created");
    }

    @Override
    public void logSomething() {
        log.info(this + " currently logging");
    }

}
