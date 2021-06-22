package src.jugadores;

import java.util.Scanner;
import src.jugadores.*;
import src.principal.*;
import src.tablero.*;


public class VectorJugadores {
    private final int JUGADORES =10;
    Jugador[] jugador = new Jugador[JUGADORES];
    private int siguientePos;
    Jugador[] competidor = new Jugador[2];
    Scanner teclado = new Scanner(System.in);
    int aleatorio;
    private String piedra, papel, tijera;


    public VectorJugadores() {
        siguientePos=1;
    }

    public void agregarJugador(String nombre){
        if(siguientePos>JUGADORES){
            System.out.println("No se puede ingresar a otro jugador");
        }else{
            jugador[(siguientePos-1)] = new Jugador(nombre);
        }
        siguientePos++;
    }
    /*Metodo*/
    public void agregarJugador(){
        System.out.print("Ingrese el nombre");
        String nombre = teclado.nextLine();
        agregarJugador(nombre);
    }


    public void mostrarJugadores(){
        for (int i = 0; i < (siguientePos-1); i++) {
            System.out.println(i+" Nombre: " +jugador[i].getNombre()+
                    "\tpuntuacion: " +jugador[i].getPuntuacion());

        }
    }

    public void agregarCompetidor(int jug1, int jug2){

        competidor[0] = jugador[jug1];
        competidor[1] = jugador[jug2];
    }

    public void mostrarCompetidores(){
        for (int i = 0; i <2; i++) {
            System.out.println(i +" Nombre: "+ competidor[i].getNombre());
        }
    }

    
    public Jugador enviarJugador(int pos){
        Jugador jug = competidor[pos];
        return jug;
    }

    public void elegirTurnos(){
        int ju1,ju2, ganador;
        System.out.println("Se elegiran los turnos de los jugadores a competir");
        System.out.println("Se hara un juego de piedra, papel o tijera");
        System.out.println(competidor[0].getNombre()+ " Versus "+ competidor[1].getNombre());
        System.out.println("presione ENTER para ver al ganador");
        teclado.nextLine();
        do{
        ju1 = obtenerAleatorio();
        ju2 = obtenerAleatorio();
        }while(ju1 == ju2);
        System.out.println(ju1);
        System.out.println(ju2);
        String manoJ1 = resultado(ju1);
        String manoJ2 = resultado(ju2);
        System.out.println(competidor[0].getNombre()+" obtuvo: " +manoJ1);
        pintar(ju1);
        System.out.println("\n");
        pintar(ju2);
        System.out.println(competidor[1].getNombre()+ " obtuvo: " +manoJ2);
        ganador = elegirGanador(manoJ1, manoJ2);
        ordenarTurnos(ganador);
        System.out.println("ENTER para continuar");
        teclado.nextLine();

    }

    public int elegirGanador(String mano1, String mano2){

        int ganador=-1;

        if(mano1.equalsIgnoreCase("piedra")){
            if(mano2.equalsIgnoreCase("papel"))
                ganador =1;
            if(mano2.equalsIgnoreCase("tijera"))
                ganador =0;
        }
        if(mano1.equalsIgnoreCase("papel")){
            if(mano2.equalsIgnoreCase("tijera"))
                ganador = 1;
            if(mano2.equalsIgnoreCase("piedra"))
                ganador =0;
        }
        if(mano1.equalsIgnoreCase("tijera")){
            if(mano2.equalsIgnoreCase("piedra"))
                ganador=1;
            if(mano2.equalsIgnoreCase("papel"))
                ganador=0;
        }
        return ganador;
    }

    public void piedra(){
        System.out.println(" ***** ");
        System.out.println("*******");
        System.out.println(" *****");
    }
    public void papel(){
        System.out.println("||||||");
        System.out.println("||||||");
        System.out.println("||||||");
    }
    public void tijera(){
        System.out.println("  / > ");
        System.out.println(" / >>> ");
        System.out.println("/   >> ");
    }

    public void pintar(int op){
        if(op ==1)
            piedra();
        if(op ==2)
            papel();
        if(op ==3)
            tijera();
    }

    public void ordenarTurnos(int ganador){
        Jugador[] aux = new Jugador[1];
        if(ganador ==0){
            System.out.println("El Ganador es: " +competidor[0].getNombre());


        }if(ganador ==1){
            System.out.println("El Ganador es: "+competidor[1].getNombre());
            aux[0] =competidor[1]; //var auxiliar para guardar al competidor
            competidor[1]= competidor[0];
            competidor[0]= aux[0];
        }

    }

    public String resultado(int num){
        String resultado="";
        if(num == 1){
            resultado = "piedra";
        }if(num ==2){
            resultado = "papel";
        } if(num ==3){
            resultado = "tijeras";
        }
        return resultado;
    }

    public String componerNombre(String dato){
        String comp = ""+dato;
        if(dato.length() <10)
            comp = "  "+comp;
        return comp;

    }

    public int obtenerAleatorio(){
        aleatorio = (int)(Math.random()*(4-1)+1);
        return aleatorio;
    }

    public void mostrarReportePartidas(){
        for(int i=0; i<(siguientePos -1); i++){
            System.out.println(i+" Nombre: "+jugador[i].getNombre()+
                    "\tPuntuacion: " +jugador[i].getPuntuacion()+ "\tha ganado: " +
                    jugador[i].getPartidasGanadas() + "  partidas, en: "+jugador[i].getPartidasJugadas()+ "  partidas jugadas");
        }
    }

    public Jugador[] getJugador() {
        return jugador;
    }

    public void setJugador(Jugador[] jugador) {
        this.jugador = jugador;
    }
}