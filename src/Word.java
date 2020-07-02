public class Word {
    // placeholder method
    public void summary() {
        System.out.println("in Word class object summary method");
        Letter letter = new Letter('Q');
        letter.summary();
        Letter letter2 = new Letter(' ');
        letter2.summary();
    }
}