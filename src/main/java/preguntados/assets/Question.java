package preguntados.assets;

// Clase a ser instanciada por cada pregunta que haya
// contiene la información necesaria para cada pregunta (la pregunta en sí, sus opciones posibles y la resp correcta)
public class Question {
    private String text; // el texto de la pregunta, por ej. "¿Cuál es la capital de X?"
    private String[] options; // las respuestas posibles, por ej. {"Paris", "Roma", "Londres", "Madrid"}
    
    // indice de la respuesta correcta, por ejemplo, si preguntamos
    // "¿Capital de España?"
    // y las opciones son: {"Paris", "Roma", "Madrid", "Londres"}
    // entonces este atributo valdrá 2
    private int correct_answer_index;

    public Question(String text, String[] options, int correct_answer_index) {
        this.text = text;
        this.options = options;
        this.correct_answer_index = correct_answer_index;
    }

    public String getText() {
        return this.text;
    }

    public String[] getOptions() {
        return this.options;
    }

    public boolean answerIsCorrect(int player_answer) {
        return player_answer == this.correct_answer_index;
    }
}
