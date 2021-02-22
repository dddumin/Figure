package factory;

import model.Figure;

public interface FigureFactory {
    Figure newInstance(String[] data);
}
