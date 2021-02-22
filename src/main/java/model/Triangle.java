package model;

import java.util.Objects;

public class Triangle implements Figure {
    private double a;
    private double b;
    private double c;

    public Triangle(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double perimeter() {
        return this.a + this.b + this.c;
    }

    public double square() {
        double halfPer = this.perimeter()/2;
        return Math.sqrt(halfPer*(halfPer - this.a)*(halfPer - this.b)*(halfPer - this.c));
    }

    public String getName() {
        return "Triangle";
    }

    @Override
    public String getParam() {
        return this.a + ";" + this.b + ";" + this.c;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Triangle triangle = (Triangle) o;
        return Double.compare(triangle.a, a) == 0 &&
                Double.compare(triangle.b, b) == 0 &&
                Double.compare(triangle.c, c) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(a, b, c);
    }

    @Override
    public String toString() {
        return "Triangle{"  +
                "a=" + a +
                ", b=" + b +
                ", c=" + c +
                '}';
    }


}
