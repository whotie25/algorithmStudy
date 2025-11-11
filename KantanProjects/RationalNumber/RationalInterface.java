public interface RationalInterface {
    public Rational add(Rational operand);
    public Rational add(int operand);

    public Rational subtract(Rational operand);
    public Rational subtract(int operad);

    public Rational multiply(Rational operand);
    public Rational multiply(int operand);

    public Rational divide(Rational operand);
    public Rational divide(int operand);

    public double toDouble();
    public int toInteger();

    public String toString();
}
