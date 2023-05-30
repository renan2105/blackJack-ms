package com.renan.bjcarta.entities.enums;

public enum NaipeCartaEnum {

    ESPADAS(0),
    PAUS(1),
    COPAS(2),
    OUROS(3);


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
