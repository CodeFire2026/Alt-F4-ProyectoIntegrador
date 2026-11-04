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
        {"¿Qué función se utiliza para mostrar texto por pantalla en Python?", "1",
            "display()", "print()", "output()", "show()"
        },
        {"¿Cuál de las siguientes sintaxis crea una lista?", "2",
            "<1, 2, 3>", "(1, 2, 3)", "[1, 2, 3]", "{1, 2, 3}"
        },
        {"¿Qué símbolo se utiliza para escribir comentarios de una sola línea?", "0",
            "#", "//", "--", "%"
        },
        {"¿Qué método agrega un elemento al final de una lista?", "3",
            "add()", "insert()", "extend()", "append()"
        },
        {"¿Qué estructura se utiliza para manejar excepciones?", "0",
            "try / except", "if / else", "switch / case", "for / while"
        },
        {"¿Qué imprime el siguiente código?\n    x = [1, 2, 3]\n    print(x[-1])", "2",
            "1", "2", "3", "error"
        },
        {"¿Cuál es el resultado de la siguiente expresión?\n    [lambda: i for i in range(3)][0]()", "2",
            "0", "1", "2", "error"
        },
        {"¿Qué imprime el siguiente código?\n    print(type(type(5)))", "1",
            "<class 'object'>", "<class 'type'>", "<class 'class'>", "<class 'int'>"
        },
        {"¿Cuál es la principal ventaja de un generador (yield) frente a una lista?", "1",
            "Puede modificar variables globales automáticamente", "Consume menos memoria al generar valores bajo demanda", "Permite almacenar más tipos de datos", "Siempre es más rápido"
        },
    };
// TEMA DE JAVASCRIPT
// Descripción: Almacena las preguntas, el índice de la respuesta correcta 
// y las opciones múltiples utilizando una matriz de cadenas (String[][]).
// Se integra de forma dinámica al cargador de categorías del juego.

    private static final String TOPIC_JAVASCRIPT_NAME = "JavaScript";
    private static final String[][] JAVASCRIPT = {
        {"¿Qué función muestra un mensaje en consola?", "0", "console.log()", "consol.log()", "console.lgo()"},
        {"¿Cómo se declara una variable moderna en JavaScript?", "1", "variable nombre;", "let nombre;", "vart nombre;"},
        {"¿Qué palabra clave se utiliza para declarar constantes?", "2", "constant", "constt", "const"},
        {"¿Qué símbolo se usa para comentarios de una línea?", "0", "// comentario", "\\\\ comentario", "## comentario"},
        {"¿Qué método muestra una ventana emergente?", "1", "prompt()", "alert()", "alret()"},
        {"¿Qué función solicita datos al usuario?", "0", "prompt()", "imput()", "promt()"},
        {"¿Cómo se escribe correctamente una condición?", "2", "if x > 5", "if x => 5", "if (x > 5)"},
        {"¿Qué operador compara valor y tipo?", "1", "==", "===", "="},
        {"¿Qué estructura repite instrucciones varias veces?", "0", "for", "fro", "iff"},
        {"¿Cómo se convierte un texto a número entero?", "2", "parseint()", "ParseInt()", "parseInt()"}
    };
    
    // TEMA DE JAVA
    private static final String TOPIC_JAVA_NAME = "Java";
    private static final String[][] JAVA = {
        {"¿Cuál es el punto de entrada de un programa Java?", "1",
            "start()", "public static void main(String[] args)", "run()", "init()"
        },
        {"¿Qué palabra clave se usa para heredar de una clase?", "2",
            "implements", "inherits", "extends", "super"
        },
        {"¿Qué tipo primitivo ocupa 8 bits?", "0",
            "byte", "short", "int", "long"
        },
        {"¿Cuál es la diferencia entre == y .equals() en objetos?", "3",
            "Son exactamente iguales", "== compara contenido y .equals() referencia", ".equals() solo funciona con String", "== compara referencia y .equals() contenido"
        },
        {"¿Qué método de String devuelve la cantidad de caracteres?", "0",
            "length()", "size()", "count()", "getLength()"
        },
        {"¿Qué palabra clave evita que una clase sea heredada?", "2",
            "static", "private", "final", "sealed"
        },
        {"¿Qué imprime el siguiente código?\n    String a = \"hola\";\n    String b = \"hola\";\n    System.out.println(a == b);", "0",
            "true", "false", "error de compilación", "null"
        },
        {"¿Cuál es el resultado de la siguiente expresión?\n    int x = 5 / 2;", "1",
            "2.5", "2", "3", "error"
        },
        {"¿Qué característica define a un constructor en Java?", "1",
            "Debe declararse con tipo de retorno void", "Tiene el mismo nombre que la clase y no tiene tipo de retorno", "Solo puede ser private", "Se invoca con la palabra clave new desde dentro de la clase"
        },
        {"¿Qué excepción se lanza al acceder a un índice inválido de un array?", "0",
            "ArrayIndexOutOfBoundsException", "NullPointerException", "IndexException", "ArrayException"
        },
    };
    
    // TEMA: DESARROLLO WEB - HTML  CSS ...//
    private static final String TOPIC_DESARROLLO_WEB = "WEB";
    private static final String [][] WEB = {
        {"¿Que elementos y programas necesitamos como minimo para comenzar a crear una pagina WEB?", "0",
           "Una computadora, un editor de codigo como Visual Studio Code y un navegador como Google Chrome.", "Una computadora, un programa para editar videos y una impresora.", 
           "Solamente una conexión a Internet y una cuenta de correo electrónico.", "Un servidor de base de datos y un programa de diseño 3D."
       },
        {"¿Cuando comenzamos a crear una página web con HTML, qué declaración debemos escribir al principio del documento?", "1",
            "<html5>", "<!DOCTYPE html>", "<head>", "<body>"
        },
        {"¿Que etiqueta HTML contiene el contenido principal que vemos cuando ingresamos a una pagina WEB?", "3",
            "<head>", "<title>", "<html>", "<body>"
        },
        {"¿Para que utilizamos CSS cuando estamos desarrollando una pagina web?", "1",
            "Para guardar informacion de los usuarios.", "Para modificar la apariencia de la pagina, como colores, tamaños y distribución.", "Para crear archivos HTML automáticamente.", 
            "Para conectar la pagina con Internet."
        },
        {"¿Que etiqueta utilizamos para vincular un archivo CSS externo con nuestro documento HTML?", "2",
            "<style>", "<script>", "<link>", "<css>"
        },
        {"¿Que propiedad CSS utilizamos cuando queremos cambiar el color de un texto?", "0",
            "color", "background-color", "font-size", "text-align"
        },
        {"¿Que etiqueta HTML utilizamos para insertar una imagen en nuestra pagina WEB?", "1",
            "<image>", "<img>", "<picture-img>", "<src>"
        },
        {"¿Para que utilizamos una carpeta llamada ASSETS dentro de un proyecto WEB?", "3",
            "Para guardar solamente archivos HTML.", "Para almacenar las hojas de estilos CSS.", "Para guardar los programas utilizados en el proyecto.", 
            "Para organizar imágenes, iconos y otros recursos que utiliza la página."
        },
        {"Si nuestra pagina WEB se ve bien en una computadora, pero se desordena al abrirla desde un celular, ¿que herramienta de CSS podemos utilizar para adaptar su presentación?", "2",
            "Los comentarios HTML.", "Las etiquetas de título.", "Las Media Queries.", "Los atributos alt."
        },
        {"¿Para que utilizamos display: flex en CSS cuando queremos organizar los elementos de una pagina?", "1",
            "Para cambiar el color de fondo de los elementos.", "Para distribuir y organizar los elementos dentro de un contenedor.", 
            "Para insertar imagenes automaticamente.", "Para modificar el tamaño de los archivos HTML."
        }, 
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
                buildTopic(TOPIC_JAVASCRIPT_NAME, JAVASCRIPT),
                buildTopic(TOPIC_JAVA_NAME, JAVA), // otro topico de ejemplo
                buildTopic(TOPIC_DESARROLLO_WEB, WEB),
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
