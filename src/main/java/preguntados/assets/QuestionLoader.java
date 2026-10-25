package preguntados.assets;

// Clase destinada a cargar las preguntas y asociarlas a un topico, que
// a su vez está asociado a una categoria. Esta asociación será en
// forma de arreglos anidados, que luego serán utilizados por otras clases (como Menu.java o Game.java)
public class QuestionLoader {

    // CONSTANTES de categorias. Escribí acá el nombre de tu categoria a crear
    private static final String CAT_PROGRAMMING_NAME = "Programación";


    // CONSTANTES de preguntas. Guardá acá tus preguntas, seguido del index correcto,
    // seguido de las opciones posibles, de forma que las opciones posibles
    // queden DESPUÉS del index 1
    // Plantilla:
    // private static final String NOMBRE_TOPICO = "Python";
    // private static final String[][] NOMBRE_PREG = {
    //      {"texto", "index",
    //          "resp1", "resp2", "resp3", "resp4"
    //      }
    // };
    private static final String TOPIC_PYTHON_NAME = "Python";
    private static final String[][] PYTHON = {
        {"Sample question text", "2",
            "wrong answer1", "right answer2", "wrong answer3", "wrong answer4"
        }
    };
// TEMA DE JAVASCRIPT
// Descripción: Almacena las preguntas, el índice de la respuesta correcta 
// y las opciones múltiples utilizando una matriz de cadenas (String[][]).
// Se integra de forma dinámica al cargador de categorías del juego.

    private static final String TOPIC_JAVASCRIPT_NAME = "JavaScript";
    private static final String[][] JAVASCRIPT = {
        {"¿Qué función muestra un mensaje en consola?", "1", "console.log()", "consol.log()", "console.lgo()"},
        {"¿Cómo se declara una variable moderna en JavaScript?", "2", "variable nombre;", "let nombre;", "vart nombre;"},
        {"¿Qué palabra clave se utiliza para declarar constantes?", "3", "constant", "constt", "const"},
        {"¿Qué símbolo se usa para comentarios de una línea?", "1", "// comentario", "\\ comentario", "## comentario"},
        {"¿Qué método muestra una ventana emergente?", "2", "prompt()", "alert()", "alret()"},
        {"¿Qué función solicita datos al usuario?", "1", "prompt()", "imput()", "promt()"},
        {"¿Cómo se escribe correctamente una condición?", "3", "if x > 5", "if x => 5", "if (x > 5)"},
        {"¿Qué operador compara valor y tipo?", "2", "==", "===", "="},
        {"¿Qué estructura repite instrucciones varias veces?", "1", "for", "fro", "iff"},
        {"¿Cómo se convierte un texto a número entero?", "3", "parseint()", "ParseInt()", "parseInt()"}
    };
    // -----------------------------------------------------------------------
    
    // Esta función será llamada por la clase dedicada a 
    // mostrar las categorias en el menú (que por ahora es Menu.java)
    // El retorno de esta función (arreglo de categorias) se guarda en una variable para poder
    // mostrar los nombres de los tópicos disponibles y sus preguntas asociadas

    public Category[] loadCategories() {
        return new Category[] {
            // new Category(CAT_NAME, new Topic[] { // otra categoria de ejemplo
            //     buildTopic(TOPIC_NAME, GENERAL)
            // }),
            new Category(CAT_PROGRAMMING_NAME, new Topic[] {
                buildTopic(TOPIC_PYTHON_NAME, PYTHON),
                // buildTopic("Java", JAVA), // otro topico de ejemplo
            }),
        };
    }
    
    // -----------------------------------------------------------------------

    // Lógica que toma la matriz de preguntas y respuestas y la transforma en un tópico con preguntas (objeto con objetos)
    private Topic buildTopic(String topic_name, String[][] topic_data) {
        Question[] questions = new Question[topic_data.length];
        for (int i = 0; i < topic_data.length; i++) {
            String[] row = topic_data[i];
            int correct = Integer.parseInt(row[1]);

            // debido a que las respuestas comienzan despues del segundo indice,
            // se juega un poco con sumas y restas para obtener los elementos que se quieren
            String[] options = new String[row.length - 2];
            for (int j = 2; j < row.length; j++) {
                options[j - 2] = row[j];
            }
            // instanciamos una pregunta
            questions[i] = new Question(row[0], options, correct);
        }
        return new Topic(topic_name, questions);
    }
}
