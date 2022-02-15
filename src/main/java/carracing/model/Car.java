package carracing.model;

import carracing.utils.RandomUtil;

import static carracing.view.messages.ExceptionMessage.*;

public class Car {
	private static final int MIN_NAME_LENGTH = 1;
	private static final int MAX_NAME_LENGTH = 5;

	private final String name;
	private int position;

	public Car(String name) {
		if (name.length() < MIN_NAME_LENGTH || name.length() > MAX_NAME_LENGTH) {
			throw new IllegalArgumentException(CAR_NAME_LENGTH_EXCEPTION.getMessage());
		}
		this.name = name;
		this.position = 0;
	}

	public String getName() {
		return this.name;
	}

	public void move(RandomUtil randomUtil) {
		if (randomUtil.isMovable()) {
			this.position++;
		}
	}

	public int getPosition() {
		return this.position;
	}

	public boolean isEqualTo(int position) {
		return this.position == position;
	}
}
