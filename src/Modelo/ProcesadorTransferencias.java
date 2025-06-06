package Modelo;

import Strategy.*;

public class ProcesadorTransferencias {

    private Strategy strategy;
    private Repository repository;

    public ProcesadorTransferencias(Repository repository){
        this.repository = repository;
    }

    public void setStrategy(Strategy strategy){
        this.strategy = strategy;
    }

    public void procesar(Transferencia transferencia){
        strategy.ejecutar(transferencia);
        repository.ejecutar(transferencia);
    }
}
