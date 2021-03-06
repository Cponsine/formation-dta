package fr.pizzeria.ihm.action;

import java.sql.SQLException;

public abstract class Action {

	private String description;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public abstract void do_action() throws SQLException;
	public abstract void describe_action();
}
