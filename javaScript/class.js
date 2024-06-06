class carro {
    constructor(marca, modelo, placa, cantidadLLanteas, color, numeroSillas) {
        this.marca = marca;
        this.modelo = modelo;
        this.placa = placa;
        this.cantidadLLanteas = cantidadLLanteas;
        this.color = color;
        this.numeroSillas = numeroSillas;
    }

    encender(){
        console.log("El carro esta encendido");
    }

    apagar(){
        console.log("El carro esta apagado");
    }

    acelerar(posiInicial){
        console.log("El carro esta acelerando desde la posición");
        return posiInicial + 10;
    }

    frenar(velocidad){
        console.log("El carro esta frenando");
        if (velocidad > 5){
            return velocidad -5;
        }else{
            return velocidad - velocidad;
        }
    }

    cambiarMarcha(numeroMarcha){
        console.log("El carro esta cambiando a la marcha ");
        this.clutch();
        return numeroMarcha + 1;
    }

    clutch(){
        console.log("Presionando el clutch");
    }

    pitar(){
        console.log("piiiiii");
    }
}