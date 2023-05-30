package com.future.payments.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@JsonIgnoreProperties (
    ignoreUnknown = true
)
@ToString
public class Payments {
    private String merchantName;
    private String merchantCity;
    private String merchantState;
    private String merchnatId;
    private String mmc;
    @NotNull(message = "Transaction amount can not be null")
    private long transactionAmount;

}
