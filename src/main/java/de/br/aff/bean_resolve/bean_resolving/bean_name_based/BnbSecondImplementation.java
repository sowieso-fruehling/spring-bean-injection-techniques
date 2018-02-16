package de.br.aff.bean_resolve.bean_resolving.bean_name_based;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class BnbSecondImplementation implements BnbInterface {

    public BnbSecondImplementation()
    {
        log.info(this + " created");
    }

    @Override
    public void logSomething() {
        log.info(this + " currently logging");
    }
}
