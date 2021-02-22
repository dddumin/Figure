package program;

import factory.FigureFactory;
import factory.RectangleFactory;
import factory.TriangleFactory;
import model.*;
import repository.Repository;

import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Program {
    public static void main(String[] args) {
        /*Figure r = new Rectangle(5, 5);
        Figure t = new Triangle(3, 4, 5);

        Calculator calculator = new Calculator(r);
        Calculator calculator1 = new Calculator(t);

        System.out.println(calculator.calculate(Functor.PERIMETER));
        System.out.println(calculator.calculate(Functor.SQUARE));
        System.out.println(calculator1.calculate(Functor.PERIMETER));
        System.out.println(calculator1.calculate(Functor.SQUARE));
        System.out.println(r.getName());
        System.out.println(t.getName());

        Calculator calculator2 = new Calculator(new Figure() {
            private double rad = 0;

            {
                setRadius();
            }

            private void setRadius() {
                Scanner scanner = new Scanner(System.in);
                while (!Validator.validateLength(this.rad)) {
                    try {
                        System.out.println("Please enter radius");
                        this.rad = scanner.nextDouble();
                        if (!Validator.validateLength(this.rad))
                            throw new NumberFormatException();
                    } catch (NumberFormatException | InputMismatchException e) {
                        System.out.println("Please enter the positive number");
                        scanner.nextLine();
                    }
                }
            }

            @Override
            public double perimeter() {
                return 2 * rad * Math.PI;
            }

            @Override
            public double square() {
                return rad * rad * Math.PI;
            }

            @Override
            public String getName() {
                return "Circle";
            }

            @Override
            public String getParam() {
                return null;
            }
        });
        System.out.println(calculator2.calculate(Functor.PERIMETER));
        System.out.println(calculator2.calculate(Functor.SQUARE));
        Repository repository = null;
        try {
            System.out.println(new Repository("data.csv"));
            Repository.changeFigure("data.csv", new Triangle(1, 1, 1), new Triangle(3, 3, 3));
            System.out.println(new Repository("data.csv"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }*/
        Scanner scanner = new Scanner(System.in);
        HashMap<String, FigureFactory> map = new HashMap<>();
        map.put("Triangle", new TriangleFactory());
        map.put("Rectangle", new RectangleFactory());
        Repository repository = new Repository(map);
        while (true) {
            System.out.println("Please choose figure from the List: \r\n 1. Triangle \r\n 2. Rectangle \r\n 3. Quit");
            try {
                FigureType figureType = FigureType.valueOf(scanner.next());
                Figure figure = null;
                if (figureType == FigureType.TRIANGLE) {
                    double a = 0;
                    double b = 0;
                    double c = 0;
                    while (!Validator.validateLength(a)) {
                        System.out.println("Please enter the length of the first side");
                        a = scanner.nextDouble();
                        if (!Validator.validateLength(a))
                            System.out.println("Length must be positive number!!!");
                    }
                    while (!Validator.validateLength(b)) {
                        System.out.println("Please enter the length of the second side");
                        b = scanner.nextDouble();
                        if (!Validator.validateLength(b))
                            System.out.println("Length must be positive number!!!");
                    }
                    while (!Validator.validateLength(c)){
                        System.out.println("Please enter the length of the third side");
                        c = scanner.nextDouble();
                        if (!Validator.validateLength(c))
                            System.out.println("Length must be positive number!!!");
                    }
                    figure = new Triangle(a, b, c);
                } else if (figureType == FigureType.RECTANGLE) {
                    double a = 0;
                    double b = 0;
                    while (!Validator.validateLength(a)){
                        System.out.println("Please enter the length of the first side");
                        a = scanner.nextDouble();
                        if (!Validator.validateLength(a))
                            System.out.println("Length must be positive number!!!");
                    }
                    while (!Validator.validateLength(b)){
                        System.out.println("Please enter the length of the second side");
                        b = scanner.nextDouble();
                        if (!Validator.validateLength(b))
                            System.out.println("Length must be positive number!!!");
                    }
                    figure = new Rectangle(a, b);
                }
                repository.addFigure(figure);
                System.out.println("Figure added");
            } catch (Exception e) {
                System.out.println("Please enter the number!!!");
                scanner.next();
            }
        }
    }
}
