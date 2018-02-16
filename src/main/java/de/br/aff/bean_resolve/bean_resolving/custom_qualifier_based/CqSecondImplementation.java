package de.br.aff.bean_resolve.bean_resolving.custom_qualifier_based;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class CqSecondImplementation implements CqInterface{
    public CqSecondImplementation()
    {
        log.info(this + " created");
    }

    @Override
    public void logSomething() {
        log.info(this + " currently logging");
    }
}
