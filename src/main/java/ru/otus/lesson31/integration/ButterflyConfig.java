package ru.otus.lesson31.integration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.dsl.MessageChannels;
import ru.otus.lesson31.model.Butterfly;
import ru.otus.lesson31.model.Cocoon;

@Configuration
public class ButterflyConfig {

    @Autowired
    private CaterpillarHandler caterpillarHandler;

    @Autowired
    private CocoonHandler cocoonHandler;

    @Bean
    public IntegrationFlow butterflyFlow(CaterpillarHandler caterpillarHandler, CocoonHandler cocoonHandler) {
        return IntegrationFlows.from(MessageChannels.direct("caterpillarChannel"))
                .handle(caterpillarHandler)
                .transform(Cocoon.class, cocoonHandler::transform)
                .transform(Butterfly.class, cocoon -> new Butterfly(cocoon.getName(), cocoon.getAge()))
                .channel(MessageChannels.direct("butterflyChannel"))
                .get();
    }
}