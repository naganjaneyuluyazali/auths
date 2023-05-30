package com.future.payments.utils;

import com.future.payments.model.Payments;
import org.springframework.stereotype.Component;

@Component
public class Utils {
    public void pickMerchant(Payments dto) {
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
