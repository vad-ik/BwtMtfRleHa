public class BWTtranspositionObject implements Comparable<BWTtranspositionObject> {
    int num;
    char character;
    public BWTtranspositionObject(int num, char character) {
        this.num = num;
        this.character = character;
    }
    public int getNum() {
        return num;
    }
    public char getCharacter() {
        return character;
    }
    @Override
    public int compareTo(BWTtranspositionObject bwtObject) {
        return (((int)this.character) - ((int)bwtObject.getCharacter()));
    }
    @Override
    public String toString() {
        return  num +" " + character;
    }
}