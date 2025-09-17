package com.unifor.paymment.builder;

import com.unifor.paymment.exceptions.PaymentException;

public class CreditCardPaymentBuilder extends PaymentBuilder {
    public CreditCardPaymentBuilder() {
        super.setPaymentType("creditcard");
        // Inicializa com valores padrão vazios
        super.setPaymentParams("", "", "", "");
    }

    public CreditCardPaymentBuilder setCardNumber(String cardNumber) {
        String[] currentParams = super.getPaymentParams();
        super.setPaymentParams(
                cardNumber,
                currentParams[1],
                currentParams[2],
                currentParams[3]
        );
        return this;
    }

    public CreditCardPaymentBuilder setCvv(String cvv) {
        String[] currentParams = super.getPaymentParams();
        super.setPaymentParams(
                currentParams[0],
                cvv,
                currentParams[2],
                currentParams[3]
        );
        return this;
    }

    public CreditCardPaymentBuilder setName(String name) {
        String[] currentParams = super.getPaymentParams();
        super.setPaymentParams(
                currentParams[0],
                currentParams[1],
                name,
                currentParams[3]
        );
        return this;
    }

    public CreditCardPaymentBuilder setExpiryDate(String expiryDate) {
        String[] currentParams = super.getPaymentParams();
        super.setPaymentParams(
                currentParams[0],
                currentParams[1],
                currentParams[2],
                expiryDate
        );
        return this;
    }
}
