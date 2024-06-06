//import * as carro from "class.js";

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
        this.numeroMarcha = numeroMarcha;
        switch(numeroMarcha){
            case 1:
                console.log("la marcha está en 1");
            break;
            case 2:
                console.log("la marcha está en 2");
            break;
            case 3:
                console.log("la marcha está en 3");
            break;
            case 4:
                console.log("la marcha está en 4");
            break;
            case 5:
                console.log("la marcha está en 5");
            break;
            case 6:
                console.log("la marcha está en 6");
            break;
            default:
                console.log("No hay marcha seleccionada");
            
        }
    }

    clutch(){
        console.log("Presionando el clutch");
    }

    pitar(){
        console.log("piiiiii");
    }
}

var tiempo = 10;
var velocidad = 0;
var ferrari = new carro('Ferrari', 2021, 'JGR653', 4, 'Rojo', 2);

ferrari.encender();

ferrari.pitar();

ferrari.cambiarMarcha(1);

ferrari.acelerar(0);

var posicionActual = 0;


while(velocidad < 50) {
    posicionActual = ferrari.acelerar(posicionActual);
    velocidad = posicionActual / tiempo;

    console.log("La posición actual es: " + posicionActual);
    console.log("La velocidad actual es: " + velocidad);
}

var i = 0;
while(velocidad > 0){
    
    velocidad = ferrari.frenar(velocidad);
    console.log("La velocidad actual es: " + velocidad)
    i++;
    console.log("Hemos frenado: " + i + " veces");
}

console.log("La marha está en: " + ferrari.numeroMarcha);

