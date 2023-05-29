package com.renan.bjpartida.entities.enums;

public enum NaipeCartaEnum {

    ESPADAS(1),
    PAUS(2),
    COPAS(3),
    OUROS(4);


    private int codigo;


    NaipeCartaEnum(int codigo) {
        this.codigo = codigo;
    }

    
    public int getCodigo() {
        return codigo;
    }

    
    public static NaipeCartaEnum valueOf(int codigo){

        for(NaipeCartaEnum value : NaipeCartaEnum.values()){
            if(value.getCodigo() == codigo)
                return value;
        }
        throw new IllegalArgumentException("Invalid NaipeCartaEnum");
    }
}
