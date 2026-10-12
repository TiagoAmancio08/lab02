public class Disciplina {
    private String nomeDisciplina;
    private int horasEstudo;
    private double[] notas;
    private int[] pesos;

    public Disciplina(String nomeDisciplina) {
        this.nomeDisciplina = nomeDisciplina;
        this.horasEstudo = 0;
        this.notas = new double[4];
        this.pesos = new int[4];

        for (int i = 0; i < pesos.length; i++) {
            this.pesos[i] = 1;
        }
    }

    public Disciplina(String nomeDisciplina, int numeroNotas){
        this.nomeDisciplina = nomeDisciplina;
        this.horasEstudo = 0;
        this.notas = new double[numeroNotas];
        this.pesos = new int[numeroNotas];

        for (int i = 0; i < numeroNotas; i++) {
            this.pesos[i] = 1;
        }
    }

    public Disciplina(String nomeDisciplina, int numeroNotas, int[] pesos){
        this.nomeDisciplina = nomeDisciplina;
        this.horasEstudo = 0;
        this.notas = new double[numeroNotas];
        this.pesos = pesos;

    }

    public void cadastraHoras(int horas) {
        this.horasEstudo += horas;
    }

    public void cadastraNota(int nota, double valorNota) {
        if (nota >= 1 && nota <= notas.length) {
            this.notas[nota - 1] = valorNota;
        }
    }

    private double calculaMedia() {
        double soma = 0;
        int somaPesos = 0;

        for (int i = 0; i < notas.length; i++) {
            soma += notas[i] * pesos[i];
            somaPesos += pesos[i];
        }

        return soma / somaPesos;
    }

    public boolean aprovado() {
        return calculaMedia() >= 7.0;
    }

    @Override
    public String toString() {
        String resultado = "[";

        for (int i = 0; i < notas.length; i++) {
            resultado += notas[i];

            if (i < notas.length - 1) {
                resultado += ", ";
            }
        }

        resultado += "]";

        return nomeDisciplina + " " + horasEstudo +
                " " + calculaMedia() + " " + resultado;
    }
}