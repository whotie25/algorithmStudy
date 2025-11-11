public class Rational implements RationalInterface {
    // FIELDS
    private int numerator;
    private int denominator;

    //CONSTRUCTORS
    public Rational(int _numer, int _denom) {
        if(_denom == 0) throw new NumberFormatException("The denominator cannot be 0.");
        if(_numer == 0) {
            numerator  = 0; denominator = 1;
            return;
        }

        int isReduced = gcd(_numer, _denom);

        if(isReduced != 1 && _numer != 0) {
            _numer /= isReduced;
            _denom /= isReduced;
        }

        if( _denom < 0) {
            _numer *= -1;
            _denom *= -1;
        }

        this.numerator = _numer;
        this.denominator = _denom;
    }
    public Rational(int _numer) {
        this(_numer, 1);
    }
    public Rational() {
        this(0, 1);
    }

    // METHODS
    public Rational add(Rational operand) {
        if(this.denominator == operand.denominator) return new Rational(this.numerator + operand.numerator, this.denominator);
        return new Rational(this.numerator * operand.denominator + this.denominator * operand.numerator, this.denominator * operand.denominator);
    }
    public Rational add(int operand) {
        return new Rational(this.numerator + operand * this.denominator, this.denominator);
    }

    public Rational subtract(Rational operand) {
        Rational rtn = new Rational(operand.numerator, operand.denominator);

        rtn.signChange();
        return add(rtn);
    }
    public Rational subtract(int operand) {
        operand *= -1;
        return add(operand);
    }

    public Rational multiply(Rational operand) {
        return new Rational(this.numerator * operand.numerator, this.denominator * operand.denominator);
    }
    public Rational multiply(int operand) {
        return new Rational(this.numerator * operand, this.denominator);
    }

    public Rational divide(Rational operand) {
        if(operand.numerator == 0) throw new NumberFormatException("Division by 0 is undefined.");

        Rational rtn = new Rational(operand.denominator, operand.numerator);
        rtn.signInverse();

        return multiply(rtn);
    }
    public Rational divide(int operand) {
        if(operand == 0) throw new NumberFormatException("Division by 0 is undefined.");

        return (operand < 0)?(new Rational(-1, operand)):(new Rational(1, operand));
    }

    public double toDouble() {
        return ((double)numerator)/denominator;
    }
    public int toInteger() {
        return numerator/denominator;
    }

    // UTILITIES
    private int gcd(int a, int b) {
        int r = -1;

        while(r != 0) {
            r = a%b;

            a = b;
            b = r;
        }

        return a;
    }

    private void signChange() {
        this.numerator *= -1;
    }

    private void signInverse() {
        if(this.denominator < 0) {
            this.numerator *= -1;
            this.denominator *= -1;
        }
    }

    // TO STRING
    public String toString() {
        if(numerator == 0) return "0";
        
        if(denominator == 1) return numerator + "";

        return numerator + "/" + denominator;
    }
}
