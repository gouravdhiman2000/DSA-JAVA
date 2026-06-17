public class interfaces {
    public static void main(String[] args) {
        Queen q = new Queen();
        q.moves();

        Bear b = new Bear();
        b.eatMeat();
        b.eatPlants();
    }
}

interface ChessPlayer{
    void moves(); //n0 - implementation just idea
}

class Queen implements ChessPlayer{
    public void moves(){
        System.out.println("up, down, left, right, diagonal in all 4 directions");
    }
}

class Rook implements ChessPlayer{
    public void moves(){
        System.out.println("up, down, left, right");
    }
}

class King implements ChessPlayer{
    public void moves(){
        System.out.println("up, down, left, right, diagonal in all 4 directions by 1 step");
    }
}

//Multiple Inheritance
interface Herbivore{
    void eatPlants();
}

interface Carnivore{
    void eatMeat();
}

class Bear implements Herbivore, Carnivore{
    public void eatPlants(){
        System.out.println("Bear eats plants");
    }

    public void eatMeat(){
        System.out.println("Bear eats Meat");
    }
}
