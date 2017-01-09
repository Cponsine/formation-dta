package fr.pizzeria.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

public class PizzaMapper implements RowMapper<Pizza>{

	@Override
	public Pizza mapRow(ResultSet rs, int row) throws SQLException {
		Pizza p = new Pizza();
		p.setId(rs.getInt("pizzaID"));
		p.setNom(rs.getString("libelle"));
		p.setCode(rs.getString("code"));
		p.setPrix(rs.getDouble("prix"));
		p.setCat(CategoriePizza.valueOf(rs.getString("categorie")));
		return p;
	}

}
