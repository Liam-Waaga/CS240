public class Token {
    private Tokens tok;
    private double value;

    public Token(Tokens tok, double value) {
        this.tok = tok;
        this.value = value;
    }

    public Tokens getTok() {
        return tok;
    }

    public void setTok(Tokens tok) {
        this.tok = tok;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
    
}