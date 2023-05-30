package com.future.payments.handler;

import com.future.payments.exception.PaymentsExceptionHandler;
import com.future.payments.model.Payments;
import com.future.payments.utils.Utils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import java.util.Iterator;

import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@Component
public class Handler {

    @Autowired
    private Utils utils;

    public Mono<ServerResponse> payments(final ServerRequest serverRequest) {
        Log logger = LogFactory.getLog(Handler.class);
        logger.info("handler process started ");

        Mono<Payments> monoRequest = serverRequest.bodyToMono(Payments.class);
        return monoRequest.flatMap(dto -> {
            logger.info("request from syndrome " + dto.toString());
            utils.pickMerchant(dto);
            return ok().body(BodyInserters.fromValue(dto));
        }).switchIfEmpty(Mono.error(new PaymentsExceptionHandler("Request body can not be empty")));
    }



}
