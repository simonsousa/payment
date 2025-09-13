package com.unifor.paymment.strategies;

import com.unifor.paymment.exceptions.PaymentException;
import com.unifor.paymment.interfaces.PaymentStrategy;


public class PaymentByBankSlip implements PaymentStrategy {
    private String idBoleto;
    private String beneficiario;
    private String pagador;
    private String numeroDocumento;

    public PaymentByBankSlip(String idBoleto, String beneficiario,
            String pagador, String numeroDocumento) {
                this.idBoleto = idBoleto;
                this.beneficiario = beneficiario;
                this.pagador = pagador;
                this.numeroDocumento = numeroDocumento;
    }

    @Override
    public void pay(double amount) throws PaymentException {
        if (idBoleto.length() < 48) { // Verifica se os dígitos identificadores do boleto são validos
            throw new PaymentException("Identificador do boleto inválido!");
        } else if (beneficiario == null || pagador == null || numeroDocumento == null) {
            throw new PaymentException("Beneficiario, pagador ou numero do documento do pagador não podem ser nulos!");
        } else {

            //implementa sua regra de negocio
            System.out.println("Pagamento de R$ " + amount +
                    " realizado via boleto bancário, de número: "
                    + idBoleto + ", beneficiario: " + beneficiario +
                    ", pagador: " + pagador + ", de documento: " + numeroDocumento);
        }
    }

    @Override
    public String getPaymentDetails() {
        return "PaymentByBankSlip{" +
                "idBoleto='" + idBoleto + '\'' +
                ", beneficiario='" + beneficiario + '\'' +
                ", pagador='" + pagador + '\'' +
                ", numeroDocumento='" + numeroDocumento + '\'' +
                '}';
    }
}
