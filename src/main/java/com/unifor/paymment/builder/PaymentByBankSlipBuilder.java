package com.unifor.paymment.builder;

public class PaymentByBankSlipBuilder extends PaymentBuilder {
    public PaymentByBankSlipBuilder () {
        super.setPaymentType("bankslip");
        // Inicializa com valores padrão vazios
        super.setPaymentParams("", "", "", "");
    }

    public PaymentByBankSlipBuilder  setIdBoleto(String idBoleto) {
        String[] currentParams = super.getPaymentParams();
        super.setPaymentParams(
                idBoleto,
                currentParams[1],
                currentParams[2],
                currentParams[3]
        );
        return this;
    }

    public PaymentByBankSlipBuilder  setBeneficiario(String beneficiario) {
        String[] currentParams = super.getPaymentParams();
        super.setPaymentParams(
                currentParams[0],
                beneficiario,
                currentParams[2],
                currentParams[3]
        );
        return this;
    }

    public PaymentByBankSlipBuilder  setPagador(String pagador) {
        String[] currentParams = super.getPaymentParams();
        super.setPaymentParams(
                currentParams[0],
                currentParams[1],
                pagador,
                currentParams[3]
        );
        return this;
    }

    public PaymentByBankSlipBuilder  setNumeroDocumento(String numeroDocumento) {
        String[] currentParams = super.getPaymentParams();
        super.setPaymentParams(
                currentParams[0],
                currentParams[1],
                currentParams[2],
                numeroDocumento
        );
        return this;
    }
}
