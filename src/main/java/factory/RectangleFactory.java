package factory;

import model.Figure;
import model.Rectangle;

public class RectangleFactory implements FigureFactory {
    @Override
    public Figure newInstance(String[] data) {
        return new Rectangle(Double.parseDouble(data[0]), Double.parseDouble(data[1]));
    }
}
