package src.usuarios;
import java.util.*;

public class VectorUsuarios {
    Scanner scanner=new Scanner(System.in);
    private static Usuario[] usuarios=new Usuario[10];
    private static int contador;
    
    public VectorUsuarios(){
        contador=0;
    }

    public static Usuario[] getUsuario(){
        return usuarios;
    }

    public static void setUsuario(Usuario[] usuario){
        usuarios=usuario;
    }

    public static int getContador(){
        return contador;
    }

    public void ingresarUsuarios(){
        String nombre;
        System.out.print("Ingrese Nombre de usuario: ");
        nombre=scanner.next();
        if(nombre!=null){
            usuarios[contador]=new Usuario(contador,nombre,0,0,0);
            System.out.println("------USUARIO REGISTRADO-------\n");
            contador++;
        } else {
            System.out.println("Ingrese un nombre correcto");
        }
    }

    public void ordenarmientoUsuarios(){
        for (int i = 0; i <contador; i++) {
            for (int j = 0; j < (contador-i-1); j++) {
                if(usuarios[j].getNombre().compareTo(usuarios[j+1].getNombre()) > 0){
                    Usuario aux = usuarios[j];
                    usuarios[j] = usuarios[j+1];
                    usuarios[j+1]= aux;
                }
            }
        }
        mostrarUsuario();
    }

    public void mostrarUsuario(){
        System.out.println("\n-------Usuarios de Mini Damas--------");
        for(int i=0;i<contador;i++){
            System.out.print(usuarios[i].getInformacion());
            System.out.println("");
            
        }
        if(usuarios[0]==null){
            System.out.println("\nNo hay usuarios registrados.\n");
        }
        
    }
}