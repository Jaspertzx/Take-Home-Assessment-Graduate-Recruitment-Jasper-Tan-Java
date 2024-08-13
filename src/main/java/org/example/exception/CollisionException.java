package org.example.exception;

import org.example.model.Car;

/**
 * Exceptions thrown when a collision occurs between two cars.
 */
public class CollisionException extends RuntimeException {

    private final Car firstCar;
    private final Car secondCar;

    /**
     * Constructs a new CollisionException with the specified detail message and the two cars involved in the collision.
     *
     * @param message   the detail message.
     * @param firstCar  the first car involved in the collision.
     * @param secondCar the second car involved in the collision.
     */
    public CollisionException(String message, Car firstCar, Car secondCar) {
        super(message);
        this.firstCar = firstCar;
        this.secondCar = secondCar;
    }

    /**
     * Generates a report of the collision, including the names of the cars and their position at the time of the
     * collision.
     *
     * @return a string report detailing the collision.
     */
    public String getCollisionReport() {
        StringBuilder reportBuilder = new StringBuilder();
        reportBuilder.append(firstCar.getName())
                .append(" ")
                .append(secondCar.getName())
                .append("\n")
                .append(secondCar.getPosition());
        return reportBuilder.toString();
    }

    /**
     * Gets the first car involved in the collision.
     *
     * @return the first car.
     */
    public Car getFirstCar() {
        return firstCar;
    }

    /**
     * Gets the second car involved in the collision.
     *
     * @return the second car.
     */
    public Car getSecondCar() {
        return secondCar;
    }
}
