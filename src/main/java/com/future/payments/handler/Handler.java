package com.future.payments.handler;

import com.future.payments.model.Payments;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import org.springframework.web.server.ServerWebInputException;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@Component
public class Handler {
    public Mono<ServerResponse> payments(final ServerRequest serverRequest) {
        Mono<Payments> monoRequest = serverRequest.bodyToMono(Payments.class);
        return monoRequest.flatMap(dto -> {
            pickMerchant(dto);
            return ok().body(BodyInserters.fromValue(dto));
        }).switchIfEmpty(Mono.error(new ServerWebInputException("Request body can not be empty")));
    }

    private void pickMerchant(Payments dto) {
        dto.setMerchantName(
                dto.getMerchantName() == null
                        ? "Google"
                        : dto.getMerchantName()
        );

        dto.setMerchantCity(
                dto.getMerchantCity() == null
                        ? "Phoenix"
                        : dto.getMerchantCity()
        );

        dto.setMerchantState(
                dto.getMerchantState() == null
                        ? "Arizona"
                        : dto.getMerchantState()
        );

        dto.setMmc(
                dto.getMmc() == null
                        ? "3424"
                        : dto.getMmc()
        );

        dto.setMerchnatId(
                dto.getMerchnatId() == null
                        ? "897891234567812"
                        : dto.getMerchnatId()
        );

    }
}
