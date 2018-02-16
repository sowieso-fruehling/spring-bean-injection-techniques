package de.br.aff.bean_resolve.bean_resolving.qualifier_based;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class QbSecondImplementation implements QbInterface{


    public QbSecondImplementation()
    {
        log.info(this + " created");
    }

    @Override
    public void logSomething() {
        log.info(this + " currently logging");
    }
}
