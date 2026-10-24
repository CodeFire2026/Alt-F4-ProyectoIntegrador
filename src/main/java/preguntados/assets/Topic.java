package preguntados.assets;

// Clase que se relaciona directamente con las preguntas que le corresponda
// Por ej. para el tema de Python, le corresponde las preguntas de Python
public class Topic {
    private String name; // Nombre del tema, por ej. "Python", "Teoremas", "Capitales"
    private Question[] questions;

    public Topic(String name, Question[] questions) {
        this.name = name;
        this.questions = questions;
    }

    public String getName() { // con este getter es que podemos mostrar el nombre del tema en el menú
        return this.name;
    }

    public Question[] getQuestions() { // con este getter podremos mostrar las preguntas y respuestas en el bucle de juego
        return this.questions;
    }
}
