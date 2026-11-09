package preguntados.assets;

// Clase donde se mostrará el texto que le permita al usuario elegir la

import java.util.Scanner;

// trivia que quiera hacer
public class Menu {
    // Constantes de texto que nunca cambian
    private static final String GAME_TITLE = "~------~ TRIVIA ~------~";
    private static final String GAME_INTRO = "Elija una categoria!";

    // Metodo para mostrar el menu principal, consiste del nombre del juego,
    // indicaciones de qué hacer y la posibilidad de eligir la clase de preguntas a responder
    // una vez seleccionado todo, se llamará a Game() para iniciar la lógica del bucle de juego
    
    // TODO!!!: solicitar el nombre del jugador e instanciar Player()

    public void showMainMenu() {
               // Creamos el Scanner para leer lo que escribe el usuario...//
        Scanner scanner = new Scanner(System.in);

        // Mostramos el titulo y el mensaje de bienvenida...//
        System.out.println(GAME_TITLE);
        System.out.println(GAME_INTRO);

        // Pedimos el nombre del jugador...//
        System.out.print("Ingresa tu nombre: ");
        String playerName = scanner.nextLine().trim();

        // Comprobamos que el jugador haya escrito un nombre...//
        while (playerName.isEmpty()) {
            System.out.println("El nombre no puede estar vacio.");
            System.out.print("Ingresa tu nombre: ");
            playerName = scanner.nextLine().trim();
        }

        // Creamos el jugador y le pasamos el Scanner...//
        Player player1 = new Player(playerName, scanner);

        // Creamos el cargador y obtenemos las categorias disponibles...//
        QuestionLoader questionLoader = new QuestionLoader();
        Category[] categories = questionLoader.loadCategories();

        // Comprobamos que existan categorias para mostrar...//
        if (categories == null || categories.length == 0) {
            System.out.println("No hay categorias disponibles.");
            return;
        }

        // Mostramos las categorias disponibles...//
        System.out.println("\n¡Elija una categoria!");

        for (int i = 0; i < categories.length; i++) {
            System.out.println((i + 1) + ". " + categories[i].getName());
        }

        // Pedimos al jugador que elija una categoria...//
        player1.setPlayerChoice(categories.length);

        // Guardamos la categoria que eligio el jugador...//
        Category currentCategory = categories[player1.getPlayerChoice()];

        // Obtenemos los temas que pertenecen a esa categoria...//
        Topic[] topics = currentCategory.getTopics();

        // Comprobamos que existan temas disponibles...//
        if (topics == null || topics.length == 0) {
            System.out.println("Esta categoria no tiene temas disponibles.");
            return;
        }

        // Declaramos una variable para guardar el tema elegido...//
        Topic currentTopic;

        // Si hay un solo tema, lo seleccionamos directamente...//
        if (topics.length == 1) {

            currentTopic = topics[0];

            System.out.println("\nTema seleccionado: " + currentTopic.getName());

        } else {

            // Si hay varios temas, los mostramos en pantalla...//
            System.out.println("\n¡Elija un tema!");

            for (int i = 0; i < topics.length; i++) {
                System.out.println((i + 1) + ". " + topics[i].getName());
            }

            // Pedimos al jugador que elija un tema...//
            player1.setPlayerChoice(topics.length);

            // Guardamos el tema que eligio el jugador...//
            currentTopic = topics[player1.getPlayerChoice()];
        }

        // Creamos el juego con la categoria, el tema y el jugador...//
        Game game = new Game(
                currentCategory.getName(),
                currentTopic,
                player1
        );

        // Iniciamos la partida...//
        game.play();
    }
}
