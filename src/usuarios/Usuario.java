package src.usuarios;

public class Usuario {
    private String nombre;
    private int puntuacion;
    private int partidasGanadas;
    private int partidasPerdidas;
    private int id;

    public Usuario(int id,String nombre,int puntuacion,int partidasGanadas,int partidasPerdidas){
        this.id=id;
        this.nombre=nombre;
        this.puntuacion=puntuacion;
        this.partidasGanadas=partidasGanadas;
        this.partidasPerdidas=partidasPerdidas;
    }


    public void setNombre(String nombre){
        this.nombre=nombre;
    }

    public void setPuntuacion(int puntuacion){
        this.puntuacion=puntuacion;
    }
    public void setPartidasGanadas(int partidasGanadas){
        this.partidasGanadas=partidasGanadas;
    }

    public void setPartidasPerdidas(int partidasPerdidas){
        this.partidasPerdidas=partidasPerdidas;
    }

    public String getNombre(){
        return nombre;
    }

    public int getPuntuacion(){
        return puntuacion;
    }

    public int getPartidasGanadas(){
        return partidasGanadas;
    }

    public int getPartidasPerdidas(){
        return partidasPerdidas;
    }

    public int getId(){
        return id;
    }

    public String getInformacion(){
        return "Id: "+id+". Nombre: "+nombre+". Puntuacion: "+puntuacion+". Partidas Ganadas: "+partidasGanadas+". Partidas Perdidas: "+partidasPerdidas;
    }
}