package carracing.model;

import carracing.dto.CarDto;
import carracing.utils.MoveStrategy;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Car implements Comparable<Car> {

    private final String name;
    private int position;

    public Car(String name) {
        this.name = name;
        this.position = 0;
    }

    public static List<Car> getCars(List<String> carNames) {
        return carNames.stream()
                .map(Car::new)
                .collect(Collectors.toUnmodifiableList());
    }

    public CarDto toCarDto() {
        return new CarDto(this.name, this.position);
    }

    public void move(MoveStrategy moveStrategy) {
        if (moveStrategy.isMovable()) {
            this.position++;
        }
    }

    public boolean isEqualPosition(int position) {
        return this.position == position;
    }

    @Override
    public int compareTo(Car o) {
        return o.position - this.position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Car car = (Car) o;
        return position == car.position && Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }
}
