package model;

import java.util.Objects;

public class Rectangle implements Figure {
    private double a;
    private double b;
    private double c;
    private double d;

    public Rectangle(double a, double b) {
        this.a = a;
        this.b = a;
        this.c = b;
        this.d = b;
    }


    public double perimeter() {
        return this.a + this.b + this.c + this.d;
    }

    public double square() {
        return this.a*this.c;
    }

    public String getName() {
        return "Rectangle";
    }

    @Override
    public String getParam() {
        return this.a + ";" + this.c + ";";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rectangle rectangle = (Rectangle) o;
        return Double.compare(rectangle.a, a) == 0 &&
                Double.compare(rectangle.b, b) == 0 &&
                Double.compare(rectangle.c, c) == 0 &&
                Double.compare(rectangle.d, d) == 0;


    }

    @Override
    public int hashCode() {
        return Objects.hash(a, b, c, d);
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "a=" + a +
                ", b=" + b +
                ", c=" + c +
                ", d=" + d +
                '}';
    }


}
