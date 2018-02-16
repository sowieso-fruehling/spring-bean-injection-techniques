package de.br.aff.bean_resolve.bean_resolving.primary_based;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class PbSecondImplementation implements PbInterface {

    public PbSecondImplementation() {
        log.info(this + " created");
    }

    @Override
    public void logSomething() {
        log.info(this + " currently logging");
    }
}
