public class Disciplina {
    private String nomeDisciplina;
    private int horasEstudo;
    private double[] notas;

    public Disciplina(String nomeDisciplina) {
        this.nomeDisciplina = nomeDisciplina;
        this.horasEstudo = 0;
        this.notas = new double[4];
    }

    public void cadastraHoras(int horas) {
        this.horasEstudo += horas;
    }

    public void cadastraNota(int nota, double valorNota) {
        if (nota >= 1 && nota <= 4) {
            this.notas[nota - 1] = valorNota;
        }
    }

    private double calculaMedia() {
        double soma = 0;

        for (int i = 0; i < notas.length; i++) {
            soma += notas[i];
        }

        return soma / 4;
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