package com.example.Transfer_UY.Demo_1V.models;

public class Transferencia {
    private Long jugadorId;
    private Long equipoDestinoId;
    private Double valorTransferencia;
    private String tipoTransferencia;


    public Long getJugadorId() {
        return jugadorId;
    }

    public void setJugadorId(Long jugadorId) {
        this.jugadorId = jugadorId;
    }

    public Long getEquipoDestinoId() {
        return equipoDestinoId;
    }

    public void setEquipoDestinoId(Long equipoDestinoId) {
        this.equipoDestinoId = equipoDestinoId;
    }

    public Double getValorTransferencia() {
        return valorTransferencia;
    }

    public void setValorTransferencia(Double valorTransferencia) {
        this.valorTransferencia = valorTransferencia;
    }

    public String getTipoTransferencia() {
        return tipoTransferencia;
    }

    public void setTipoTransferencia(String tipoTransferencia) {
        this.tipoTransferencia = tipoTransferencia;
    }
}
