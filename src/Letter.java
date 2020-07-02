public class Letter {
    Character letter;
    Boolean isKnown;

    public Letter(char letter) {
        this.letter = letter;
        this.isKnown = (letter == ' ') ? true : false;
    }

    // placeholder method
    public void summary() {
        System.out.println("in Letter class object summary method");
        System.out.println("Letter is: " + letter + " is known is: " + isKnown);
    }
}
