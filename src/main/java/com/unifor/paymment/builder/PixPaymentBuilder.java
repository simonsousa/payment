package com.unifor.paymment.builder;

public class PixPaymentBuilder extends PaymentBuilder {
    public PixPaymentBuilder() {
        super.setPaymentType("pix");
        // Inicializa com valores padrão vazios
        super.setPaymentParams("", "");
    }

    public PixPaymentBuilder setPixKey(String pixKey) {
        String[] currentParams = super.getPaymentParams();
        super.setPaymentParams(
                pixKey,
                currentParams[1]
        );
        return this;
    }

    public PixPaymentBuilder setBeneficiary(String beneficiary) {
        String[] currentParams = super.getPaymentParams();
        super.setPaymentParams(
                currentParams[0],
                beneficiary
        );
        return this;
    }
}
