

public class Descanso {
    int horasDescanso;
    int numeroSemanas;

    public Descanso(){
        this.horasDescanso = 0;
        this.numeroSemanas = 0;
    }

    public void defineHorasDescanso(int horas){
        horasDescanso = horas;
    }

    public void defineNumeroSemanas(int s){
        numeroSemanas = s;
    }

    public String getStatusGeral(){
        if (numeroSemanas > 0 && (horasDescanso/numeroSemanas)>=26){
            return "Descansado";
        }
        return "Cansado";
    }
}
