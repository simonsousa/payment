package com.unifor.paymment.builder;

import com.unifor.paymment.exceptions.PaymentException;
import com.unifor.paymment.interfaces.PaymentStrategy;
import com.unifor.paymment.factories.PaymentFactory;

public class PaymentBuilder {
    private String paymentType;
    private String[] paymentParams;
    private double amount;

    public PaymentBuilder() {
        // Construtor padrão
    }

    public PaymentBuilder setPaymentType(String paymentType) {
        this.paymentType = paymentType;
        return this;
    }

    public PaymentBuilder setPaymentParams(String... params) {
        this.paymentParams = params;
        return this;
    }

    public PaymentBuilder setAmount(double amount) {
        this.amount = amount;
        return this;
    }

    // Método protegido para acesso das subclasses
    protected String[] getPaymentParams() {
        return this.paymentParams;
    }

    public PaymentStrategy build() throws PaymentException {
        if (paymentType == null || paymentParams == null) {
            throw new PaymentException("Tipo de pagamento e parâmetros são obrigatórios");
        }

        return PaymentFactory.createPayment(paymentType, paymentParams);
    }

    public void executePayment() throws PaymentException {
        PaymentStrategy strategy = build();
        strategy.pay(amount);
    }
}
