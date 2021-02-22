package factory;

import model.Figure;
import model.Triangle;

public class TriangleFactory implements FigureFactory {
    @Override
    public Figure newInstance(String[] data) {
        return new Triangle(Double.parseDouble(data[0]), Double.parseDouble(data[1]), Double.parseDouble(data[2]));
    }
}
