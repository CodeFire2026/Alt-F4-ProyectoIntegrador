package preguntados.assets;

// Clase dedicada a la lógica del gameplay loop: muestra las preguntas y opciones
// del tema elegido, procesa la respuesta actualizando las vidas/puntaje del 
// jugador y al final muestra el resultado.
// Usa las clases Topic para las preguntas, Player para el estado del jugador,
// y Question (indirectamente, a través de Topic) también para las preguntas.
public class Game {
    private String categoryName; // nombre de la categoría, para mostrarlo al final
    private Topic topic; // tema elegido (contiene las preguntas)
    private Player player; // jugador que está jugando esta partida

    // Constructor: recibe la categoría (solo nombre), el tema y el jugador.
    public Game(String categoryName, Topic topic, Player player) {
        this.categoryName = categoryName;
        this.topic = topic;
        this.player = player;
    }

    // Bucle principal del juego: recorre todas las preguntas del tema mientras
    // mientras el jugador tenga vidas.
    public void play() {
        Question[] questions = this.topic.getQuestions(); // Arreglo de preguntas
        int total = questions.length; // Total de preguntas

        // Mostramos categoría, tema y estado inicial del jugador.
        System.out.println("\n=== Categoría: " + this.categoryName
                + " | Tema: " + this.topic.getName() + " ===");
        System.out.println("Jugador: " + this.player.getName()
                + " | Vidas: " + this.player.getLives());

        // i es el índice de la pregunta actual. El bucle termina si:
        // - se acabaron las preguntas (i == total), o
        // - el jugador se quedó sin vidas.
        int i = 0;
        while (i < total && this.player.isAlive()) {
            Question q = questions[i]; // Obtenemos la pregunta actual.

            // Mostramos info de progreso y estado del jugador.
            System.out.println("\n--- Pregunta " + (i + 1) + "/" + total + " ---");
            System.out.println("Vidas: " + this.player.getLives()
                    + " | Puntos: " + this.player.getPoints());
            
            System.out.println(q.getText()); // Texto de la pregunta.

            // Mostramos las opciones numeradas (1..N para el usuario).
            String[] options = q.getOptions();
            for (int j = 0; j < options.length; j++) {
                System.out.println((j + 1) + ". " + options[j]);
            }

            // Leemos la respuesta validando que esté en rango (1..options.length).
            // Restamos 1 para convertir a índice de base 0 y comparar con correct_answer_index.
            int answerIndex; // Respuesta usuario
            // El ciclo se repite mientras la respuesta esté fuera de rango.
            do {
                answerIndex = this.player.readInt("Respuesta: ") - 1; // Validación número con readInt.
                if (answerIndex < 0 || answerIndex >= options.length) {
                    System.out.println("Elegí una opción entre 1 y " + options.length + ".");
                }
            } while (answerIndex < 0 || answerIndex >= options.length);

            // Evaluamos la respuesta comparando el índice elegido con el índice correcto.
            if (q.answerIsCorrect(answerIndex)) { // Si acierta
                System.out.println("¡Correcto! +1 punto");
                this.player.addPoint();
            } else { // Si falla
                // A diferencia de answerIsCorrect, getCorrectAnswer devuelve
                // cuál era la respuesta correcta.
                System.out.println("Incorrecto. La respuesta era: " + q.getCorrectAnswer());
                this.player.loseLife();
                System.out.println("Perdiste una vida. Vidas restantes: "
                        + this.player.getLives());
            }
            i++; // Avanza a la siguiente pregunta.
            // Si el jugador perdió su última vida, la próxima evaluación del while
            // ya no se cumplirá y saldremos del bucle.
        }

        // Al salir del bucle mostramos el resultado final.
        showFinalResult(total);
    }

    // Muestra el resultado final de la partida: si terminó por completar 
    // el tema o por quedarse sin vidas, cuántas acertó, y un mensaje 
    // personalizado según el puntaje obtenido.
    private void showFinalResult(int total) {
        int score = this.player.getPoints(); // Puntos acumulados en la partida.

        System.out.println("\n=== FIN DEL JUEGO ===");

        // Distinguimos cómo terminó la partida.
        if (this.player.isAlive()) { // Si sigue vivo (completó la categoría).
            System.out.println("¡Completaste la categoría \"" + this.categoryName
                    + "\" con el tema \"" + this.topic.getName() + "\"!");
        } else { // Si se quedó sin vidas.
            System.out.println("¡Te quedaste sin vidas en \"" + this.topic.getName() + "\"!");
        }

        // Mostramos el conteo de aciertos sobre el total de preguntas del tema.
        System.out.println("Acertaste " + score + "/" + total);

        // Mensaje personalizado según puntaje.
        if (score <= 4) {
            System.out.println("Mensaje: Necesitás repasar un poco más. ¡No te rindas!");
        } else if (score <= 8) {
            System.out.println("Mensaje: ¡Buen trabajo! Vas por buen camino.");
        } else {
            System.out.println("Mensaje: ¡Excelente! Dominás el tema.");
        }
    }
}