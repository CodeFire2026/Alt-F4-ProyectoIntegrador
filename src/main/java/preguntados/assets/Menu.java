package preguntados.assets;

// Clase donde se mostrará el texto que le permita al usuario elegir la
// trivia que quiera hacer
public class Menu {
    // Constantes de texto que nunca cambian
    private static final String GAME_TITLE = "~------~ TRIVIA ~------~";
    private static final String GAME_INTRO = "Elija una categoria!";

    // Metodo para mostrar el menu principal, consiste del nombre del juego,
    // indicaciones de qué hacer y la posibilidad de eligir la clase de preguntas a responder
    // una vez seleccionado todo, se llamará a Game() para iniciar la lógica del bucle de juego
    
    // TODO!!!: solicitar el nombre del jugador e instanciarlo

    public void showMainMenu() {
        QuestionLoader QLoader = new QuestionLoader();
        Category[] categories = QLoader.loadCategories();
        
        System.out.println(GAME_TITLE);
        System.out.println(GAME_INTRO);
        for (int i = 0; i < categories.length; i++) {
            System.out.println((i+1) + ". " + categories[i].getName());
        }

        // TODO: Continuar el algoritmo del menu para permitir empezar el juego, es decir, Game()
    /*  player1.setPlayerChoice()  <- esto deberia ser un metodo en Player que pregunte al usuario "Opción: " y almacene el indice que ingresó como atributo (no olvidar restarle 1)
        Category current_category = categories[player1.getPlayerChoice()];  <- con esto podremos extraer la categoria que el jugador eligió
        Topic[] topics = current_category.getTopics();  <- y después habría que conseguir los temas de la categoria
        y mostrarlos con una pequeña comprobación para mostrar directamente las preguntas si solo hay 1 tema disponible
        
        Topic current_topic;  <- declaramos current_topic asi como hariamos con current_category
        if (topics.length == 1) {
            current_topic = topics[0];  <- acá se saltearía mostrar el unico tema que hay, se elige directamente (esto se podría cambiar a que siempre muestre, habria que hablarlo)
        } else {
             System.out.println("Elija un tema!")
             for (int i = 0; i < topics.length; i++) {
                 System.out.println((i+1) + ". " + topics[i].getName());
             }
        
            player1.setPlayerChoice()
            current_topic = topics[player1.getPlayerChoice()];
        } 
        
        new Game(current_topic, player1).play();
    */
    }
}
