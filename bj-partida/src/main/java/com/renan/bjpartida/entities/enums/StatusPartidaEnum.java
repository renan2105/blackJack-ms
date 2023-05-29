package com.renan.bjpartida.entities.enums;

public enum StatusPartidaEnum {

    PROGRESSO(1),
    FINALIZADO(2);


    private int codigo;


    StatusPartidaEnum(int codigo) {
        this.codigo = codigo;
    }

    
    public int getCodigo() {
        return codigo;
    }

    
    public static StatusPartidaEnum valueOf(int codigo){

        for(StatusPartidaEnum value : StatusPartidaEnum.values()){
            if(value.getCodigo() == codigo)
                return value;
        }
        throw new IllegalArgumentException("Invalid StatusPartidaEnum");
    }
}
