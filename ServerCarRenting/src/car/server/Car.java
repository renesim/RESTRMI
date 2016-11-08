package car.server;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Car implements Serializable {

	private static final long serialVersionUID = 1L;
	private String licensePlate;
	private String brand;
	private String model;
	private Date firstCirculationDate;
	private double price;

	private List<Comment> comments;
	private boolean isAvailable;
	private boolean hasBeenRented;

	public Car(String licensePlate, String brand, String model, Date firstCirculationDate, double price) {
		this.licensePlate = Objects.requireNonNull(licensePlate);
		this.brand = Objects.requireNonNull(brand);
		this.model = Objects.requireNonNull(model);
		this.firstCirculationDate = Objects.requireNonNull(firstCirculationDate);
		this.price = Objects.requireNonNull(price);
		comments = new ArrayList<>();
		isAvailable = true;
		hasBeenRented = false;
	}

	public String getLicensePlate() {
		return licensePlate;
	}

	public String getBrand() {
		return brand;
	}

	public String getModel() {
		return model;
	}

	public Date getFirstCirculationDate() {
		return firstCirculationDate;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public boolean addComment(int mark, String comment) {
		if ((mark < 0 && mark > 20) || comment == null) {
			return false;
		}
		comments.add(new Comment(mark, comment));
		return true;
	}

	public boolean isAvailable() {
		return isAvailable;
	}

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	public boolean hasBeenRented() {
		return hasBeenRented;
	}

	public void setHasBeenRented() {
		this.hasBeenRented = true;
	}

	@Override
	public int hashCode() {
		return licensePlate.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Car)) {
			return false;
		}
		Car car = (Car) obj;
		return licensePlate.equals(car.licensePlate);
	}

	@Override
	public String toString() {
		return brand + " " + model + " : " + licensePlate + " - " + price;
	}

}
