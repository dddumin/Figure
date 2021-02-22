package repository;

import factory.FigureFactory;
import model.*;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Repository {
    private ArrayList<Figure> figures = new ArrayList<>();
    private final Scanner scanner = new Scanner(System.in);
    private HashMap<String, FigureFactory> map;

    public Repository(HashMap<String, FigureFactory> map) {
        this.map = map;
    }

    public Repository(String fileName) throws IOException {
        this.loadFromCSV(fileName);
    }

    public void addFigure(Figure figure){
        this.figures.add(figure);
    }


    private void loadFromCSV(String fileName) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            reader.readLine();
            while (reader.ready()) {
                try {
                    String[] data = reader.readLine().split(";");
                    String typeFigure = data[0];
                    Figure figure = map.get(typeFigure).newInstance(data);
                    this.figures.add(figure);
                } catch (IOException | NumberFormatException | ArrayIndexOutOfBoundsException ignored) {
                }
            }
        }
    }

    private Figure get(int index) {
        return this.figures.get(index);
    }

    private int length() {
        return this.figures.size();
    }

    private double maxValue(Functor functor) {
        double maxValue = 0;
        if (functor == Functor.PERIMETER)
            for (int i = 0; i < this.figures.size(); i++) {
                if (this.figures.get(i).perimeter() > maxValue)
                    maxValue = this.figures.get(i).perimeter();
            }
        return maxValue;
    }

    private double minValue(Functor functor) {
        double minValue = Double.MAX_VALUE;
        if (functor == Functor.PERIMETER)
            for (int i = 0; i < this.figures.size(); i++) {
                if (this.figures.get(i).perimeter() < minValue)
                    minValue = this.figures.get(i).perimeter();
            }
        return minValue;
    }


    public Figure[] maxDifference(Functor functor) {
        double minValue = this.minValue(functor);
        Figure[] figures = new Figure[2];
        figures[1] = Repository.maxValue(this, functor).get(0);
        if (functor == Functor.PERIMETER) {
            for (Figure figure : this.figures) {
                if (figure.perimeter() == minValue)
                    figures[0] = figure;
            }
        }
        return figures;
    }

    private Figure replace(Figure figure, Figure newFigure){
        try {
            return this.figures.set(this.figures.indexOf(figure), newFigure);
        } catch (IndexOutOfBoundsException e) {
            return null;
        }
    }

    @Override
    public String toString() {
        return "Repository{" +
                "figures=" + figures +
                ", scanner=" + scanner +
                '}';
    }

    public static ArrayList<Figure> maxValue(Repository figures, Functor functor) {
        ArrayList<Figure> figureWithMaxValue = new ArrayList<>();
        double maxValue = figures.maxValue(functor);
        for (int i = 0; i < figures.length(); i++) {
            if (functor == Functor.PERIMETER && figures.get(i).perimeter() == maxValue
                    || functor == Functor.SQUARE && figures.get(i).square() == maxValue) {
                    figureWithMaxValue.add(figures.get(i));
            }
        }
        return figureWithMaxValue;
    }

    public static void toCSV(Repository figures, String fileName) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write("Название фигуры;Сторона А;Сторона В;Сторона С;Периметр;Площадь \r\n");
            for (int i = 0; i < figures.length(); i++) {
                writer.write(figures.get(i).getName() + ";" + figures.get(i).getParam() + ";"
                        + figures.get(i).perimeter() + ";" + figures.get(i).square() + "\r\n");
            }
        }
    }

    public static void changeFigure(String fileName, Figure figure, Figure newFigure) throws IOException {
        Repository repository = new Repository(fileName);
        if (repository.replace(figure, newFigure) != null){
            Repository.toCSV(repository, fileName);
        } else
            System.out.println("Figure not found!");
    }
}
