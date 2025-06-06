package Strategy;

import Modelo.*;

public class TransferenciaStrategy implements Strategy {

    @Override
    public void ejecutar (Transferencia transferencia){
        if (transferencia.getCuentaOrigen().getSaldo() < transferencia.getMonto()){
            System.out.println("Saldo insuficiente");
        }
        if (esInterbancaria(transferencia)){
            double comision = transferencia.getMonto() * 0.01;
            transferencia.setComision(comision);
        }
        transferencia.getCuentaOrigen().debitar(transferencia.getMonto());
    }

    private boolean esInterbancaria(Transferencia transferencia){
        return !transferencia.getCuentaOrigen().getBanco()
                .equals(transferencia.getCuentaDestino().getBanco());
    }


}
