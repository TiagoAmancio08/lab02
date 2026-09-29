

public class Descanso {
    int horasDescanso;
    int numeroSemanas;

    public Descanso(){
    }
    public void defineHorasDescanso(int horas){
        horasDescanso = horas;
    }
    public void defineNumeroSemanas(int s){
        numeroSemanas = s;
    }
    public String getStatusGeral(){
        if ((horasDescanso/numeroSemanas)>=26){
            return "Descansado";
        }
        return "Cansado";
    }
}
