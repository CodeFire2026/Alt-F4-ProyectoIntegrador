package preguntados.assets;

// Clase que almacena e interactúa con la información del jugador: 
// nombre, vidas restantes, puntaje acumulado, decisión (índice) que tomó en el menú, 
// y una referencia al Scanner compartido para leer entradas por teclado.

import java.util.Scanner;

public class Player {
    // Cantidad de vidas con la que arranca cada partida.
    // Es static final porque es un valor fijo que nunca cambia en ejecución.
    public static final int INITIAL_LIVES = 3;

    private String name; // Nombre del jugador
    private int lives; // Vidas restantes
    private int points; // Puntaje (aciertos acumulados)
    private int playerChoice; // Índice elegido (base 0, ya restado 1)
    private Scanner scanner; // Scanner compartido con Menu y Game

    // Constructor
    // Recibe el nombre y el Scanner que crea Menu
    public Player(String name, Scanner scanner) {
        this.name = name;
        this.lives = INITIAL_LIVES;
        this.points = 0;
        this.playerChoice = 0;
        this.scanner = scanner; // Guarda la referencia
    }

    // Getters
    public String getName() {
        return this.name;
    }

    public int getLives() {
        return this.lives;
    }

    public int getPoints() {
        return this.points;
    }

    public int getPlayerChoice() {
        return this.playerChoice;
    }

    public Scanner getScanner() {
        return this.scanner;
    }
    
    // Lectura por teclado
    // Lee un entero mostrando un mensaje.
    // MEJORAR: Que no se rompa el programa cuando el usuario tipea algo que
    // no es un entero ("abc", etc.).
    public int readInt(String prompt) {
        System.out.print(prompt);
        return Integer.parseInt(this.scanner.nextLine());
    }

    // Pide al usuario una opción entre 1 y max, valida el rango, y la guarda como índice (base 0)
    // Se usa para Game. (Podría usarse para elegir categoría en Menú).
    public void setPlayerChoice(int max) {
        int input;
        max = 4;
        do {
            input = readInt("Opción: ");
            if (input < 1 || input > max) {
                System.out.println("Opción inválida. Elegí entre 1 y " + max + ".");
            }
        } while (input < 1 || input > max);
        this.playerChoice = input - 1;
    }
    
    // Vidas y puntaje
    // Suma un punto al jugador (llamado al acertar una pregunta)
    public void addPoint() {
        this.points++;
    }

    // Quita una vida al jugador (llamado al fallar una pregunta)
    public void loseLife() {
        this.lives--;
    }

    // Devuelve true si al jugador le quedan vidas
    public boolean isAlive() {
        return this.lives > 0;
    }

    // Reinicia vidas y puntaje (llamado al empezar una nueva categoría)
    public void reset() {
        this.lives = INITIAL_LIVES;
        this.points = 0;
    }
}
