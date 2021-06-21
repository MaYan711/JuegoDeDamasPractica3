package src.usuarios;
import java.util.*;

import src.tablero.Ficha;

public class PiedraPapelTijera {
    Ficha ficha;
    Scanner scanner=new Scanner(System.in);
    public PiedraPapelTijera(Ficha ficha){
        this.ficha=ficha;
    }


    public void turnoJugador( int id1,int id2){
        boolean id1Existente=false;
        boolean id2Existente=false;
        for(int i=0;i<VectorUsuarios.getContador();i++){
            if(VectorUsuarios.getUsuario()[i].getId()==id1){
                id1Existente=true;
            }
        }

        for(int i=0;i<VectorUsuarios.getContador();i++){
            if(VectorUsuarios.getUsuario()[i].getId()==id2){
                id2Existente=true;
            }        
        }

        if(id1Existente==true && id2Existente==true){
            if(id1==id2){
                System.out.println("No puede ingresar ID's iguales");
            } else {
                int idGanador=opcionGanadora(id1, id2);
                if(idGanador==id1){
                    opcionesDeGanador(id1, id2);
                }
                if(idGanador==id2){
                    opcionesDeGanador(id2, id1);
                }
            }
        } else {
            System.out.println("Id ingresado no existe, intentelo nuevamente");
        }
    }

    public int opcionGanadora(int id1,int id2){
        int numero1=(int)((Math.random()*(3-1))+1);
        int numero2=(int)((Math.random())*(3-1)+1);
        int ganador=12;
        System.out.println("------------------------------------");
        System.out.println("------------------------------------");
        System.out.println("------------------------------------");
        System.out.println("------------------------------------");
        System.out.println("------------------------------------");
        System.out.println("------------------------------------");
        System.out.println("------------------------------------");
        
        if(numero1==1 && numero2==1){
            System.out.println(VectorUsuarios.getUsuario()[id1].getNombre()+ ": Piedra");
            System.out.println(VectorUsuarios.getUsuario()[id2].getNombre()+" : Papel");
            System.out.println("----------------"+VectorUsuarios.getUsuario()[id2].getNombre()+" : Ganador-------------");
            ganador=id2;
        } else if(numero1==1 && numero2==2){
            System.out.println(VectorUsuarios.getUsuario()[id1].getNombre()+" :Piedra ");
            System.out.println(VectorUsuarios.getUsuario()[id2].getNombre()+" : Tijeras");
            System.out.println("-------------"+VectorUsuarios.getUsuario()[id1].getNombre()+" : Ganador-----------");
            ganador=id1;
        } else if(numero1==1 && numero2==3){
            System.out.println(VectorUsuarios.getUsuario()[id1].getNombre()+" : Piedra");
            System.out.println(VectorUsuarios.getUsuario()[id2].getNombre()+" : Piedra");
            System.out.println("------EMPATE---------");
        }

        if(numero1==2 && numero2==1){
            System.out.println(VectorUsuarios.getUsuario()[id1].getNombre()+" : Tijeras");
            System.out.println(VectorUsuarios.getUsuario()[id2].getNombre()+" : Papel");
            System.out.println("-----------"+VectorUsuarios.getUsuario()[id1].getNombre()+" : Ganador---------");
            ganador=id1;
        } else if(numero1==2 && numero2==2){
            System.out.println(VectorUsuarios.getUsuario()[id1].getNombre()+" : Tijeras");
            System.out.println(VectorUsuarios.getUsuario()[id2].getNombre()+" : Tijeras");
            System.out.println("-------Empate--------");
        } else if(numero1==2 && numero2==3){
            System.out.println(VectorUsuarios.getUsuario()[id1].getNombre()+" : Tijeras");
            System.out.println(VectorUsuarios.getUsuario()[id2].getNombre()+" : Piedra");
            System.out.println("----------"+VectorUsuarios.getUsuario()[id2].getNombre()+" : Ganador--------");
            ganador=id2;
        }

        if(numero1==3 && numero2==1){
            System.out.println(VectorUsuarios.getUsuario()[id1].getNombre()+" : Papel");
            System.out.println(VectorUsuarios.getUsuario()[id2].getNombre()+" : Papel");
            System.out.println("-------EMPATE--------");
        }

        if(numero1==3 && numero2==2){
            System.out.println(VectorUsuarios.getUsuario()[id1].getNombre()+" : Papel");
            System.out.println(VectorUsuarios.getUsuario()[id2].getNombre()+" : Tijeras");
            System.out.println("-------------"+VectorUsuarios.getUsuario()[id2].getNombre()+" : Ganador---------");
            ganador=id2;
        }

        if(numero1==3 && numero2==3){
            System.out.println(VectorUsuarios.getUsuario()[id1].getNombre()+" : Papel");
            System.out.println(VectorUsuarios.getUsuario()[id2].getNombre()+" : Piedra");
            System.out.println("---------"+VectorUsuarios.getUsuario()[id1].getNombre()+" : Ganador----------");
            ganador=id1;
        }
        return ganador;
    }

    public void opcionesDeGanador(int idGanador,int idPerdedor){
        System.out.println("Elija El simbolo, 1.X      2.O");
        int opcion=scanner.nextInt();
        if(opcion==1){
            System.out.println("     Id: "+VectorUsuarios.getUsuario()[idGanador].getId()+"  Nombre: "+VectorUsuarios.getUsuario()[idGanador].getNombre());
            this.ficha.colocarSimboloEnTablero();
            System.out.println("     Id: "+VectorUsuarios.getUsuario()[idPerdedor].getId()+"  Nombre: "+VectorUsuarios.getUsuario()[idPerdedor].getNombre());
            this.ficha.pedirPosicionDeCambio(VectorUsuarios.getUsuario()[idGanador],VectorUsuarios.getUsuario()[idPerdedor]);
        } else if(opcion==2){
            System.out.println("     Id: "+VectorUsuarios.getUsuario()[idPerdedor].getId()+" Nombre: "+VectorUsuarios.getUsuario()[idPerdedor].getNombre());
            this.ficha.colocarSimboloEnTablero();
            System.out.println("     Id: "+VectorUsuarios.getUsuario()[idGanador].getId()+" Nombre: "+VectorUsuarios.getUsuario()[idGanador].getNombre());
            this.ficha.pedirPosicionDeCambio(VectorUsuarios.getUsuario()[idGanador],VectorUsuarios.getUsuario()[idPerdedor]);
        }
    } 
    
}