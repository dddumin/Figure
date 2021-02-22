package model;

public class Calculator {
    private Figure figure;

    public Calculator(Figure figure) {
        this.figure = figure;
    }

    public double calculate(Functor functor){
        if (functor == Functor.PERIMETER)
            return this.figure.perimeter();
        else
            return this.figure.square();
    }
}
