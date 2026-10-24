package preguntados.assets;

// Clase que se relaciona directamente con un tema
// Por ej. la categoria "Programación" contendrá los temas "Python", "Java", etc.
public class Category {
    private String name; // nombre de la categoria por ej. "Programación", "Geografía", "Matemática"
    private Topic[] topics;

    public Category(String name, Topic[] topics) {
        this.name = name;
        this.topics = topics;
    }

    public String getName() { // con esto podremos mostrar el nombre de la categoria en el menu
        return this.name;
    }

    public Topic[] getTopics() { // con esto podremos acceder al nombre y preguntas de un tema dado
        return this.topics;
    }
}
