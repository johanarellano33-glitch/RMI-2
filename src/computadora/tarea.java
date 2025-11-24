package computadora;

import java.io.Serializable;

public interface tarea<T> extends Serializable {
    T execute();
}