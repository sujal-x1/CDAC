package day10;

// Interface
interface Game {
    void play();
}

// Cricket class
class Cricket implements Game {

    public void play() {
        System.out.println("Playing Cricket");
    }
}

// Chess class
class Chess implements Game {

    public void play() {
        System.out.println("Playing Chess");
    }
}

// Football class
class Football implements Game {

    public void play() {
        System.out.println("Playing Football");
    }
}

// Generic class
class GamePlayer<T extends Game> {

    T game;

    GamePlayer(T game) {
        this.game = game;
    }

    void startGame() {
        game.play();
    }
}

// Main class
public class Assign10 {

    public static void main(String[] args) {

        GamePlayer<Cricket> cricket =
                new GamePlayer<>(new Cricket());

        GamePlayer<Chess> chess =
                new GamePlayer<>(new Chess());

        GamePlayer<Football> football =
                new GamePlayer<>(new Football());

        cricket.startGame();
        chess.startGame();
        football.startGame();
    }
}
