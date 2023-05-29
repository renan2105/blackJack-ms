package com.renan.bjcarta.entities.enums;

public enum StatusJogadorEnum {

    JOGANDO(1),
    PAROU(2),
    ULTRAPASSOU(3);


    private int codigo;


    StatusJogadorEnum(int codigo) {
        this.codigo = codigo;
    }

    
    public int getCodigo() {
        return codigo;
    }

    
    public static StatusJogadorEnum valueOf(int codigo){

        for(StatusJogadorEnum value : StatusJogadorEnum.values()){
            if(value.getCodigo() == codigo)
                return value;
        }
        throw new IllegalArgumentException("Invalid StatusJogadorEnum");
    }
}
