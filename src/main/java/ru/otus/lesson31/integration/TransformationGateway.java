package ru.otus.lesson31.integration;

import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;
import ru.otus.lesson31.model.Butterfly;
import ru.otus.lesson31.model.Caterpillar;


@MessagingGateway
public interface TransformationGateway {
    @Gateway(requestChannel = "caterpillarChannel", replyChannel = "butterflyChannel")
    Butterfly transform(Caterpillar caterpillar);
}
