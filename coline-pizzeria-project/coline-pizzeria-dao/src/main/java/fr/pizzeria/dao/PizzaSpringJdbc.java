package fr.pizzeria.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import fr.pizzeria.Exception.DeletePizzaException;
import fr.pizzeria.Exception.SavePizzaException;
import fr.pizzeria.Exception.UpdatePizzaException;
import fr.pizzeria.model.Pizza;

@Repository
public class PizzaSpringJdbc implements PizzaDao {

	private JdbcTemplate template;
	
	@Autowired
	private DataSource dataSource;

//	public void setTemplate(JdbcTemplate template) {
//		this.template = template;
//	}
	@PostConstruct
	public void init(){
		this.template = new JdbcTemplate(dataSource);
	}
	
//	@Autowired
//	public PizzaSpringJdbc(DataSource data){
//		this.setTemplate(new JdbcTemplate(data));
//	}
	
	public PizzaSpringJdbc() {
		// TODO Auto-generated constructor stub
	}

	public List<Pizza> findAllPizzas() throws SQLException {
		String q = "select * from Pizza";
		return this.template.query(q,new PizzaMapper());
	}

	@Override
	public boolean saveNewPizza(Pizza pizza) throws SavePizzaException {
		String q = "insert into Pizza ( code,libelle,prix,categorie) values (?,?,?,?)";
		this.template.update(q,pizza.getCode(),pizza.getNom(),pizza.getPrix(),pizza.getCat().name());
		try {
			findAllPizzas().forEach(p -> System.out.println(p.getId()));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean updatePizza(String codePizza, Pizza pizza) throws UpdatePizzaException, SQLException {
		//String q = "update Pizza set libelle=? where code=?";
		String q = "update Pizza set code=?, libelle=?, prix =? ,categorie=? where code=?";
		template.update(q,pizza.getCode(),pizza.getNom(),pizza.getPrix(),pizza.getCat().name(),codePizza);
		//template.update(q,pizza.getNom(),codePizza);
		return false;
	}

	@Override
	public boolean deletePizza(String codePizza) throws DeletePizzaException, SQLException {
		String q= "delete from pizza where code=?";
		template.update(q,codePizza);
		return true;
	}
	
	public Optional<Pizza> findPizzaByCode(String codePizza) throws SQLException {
		//String q = "select * from pizza where code=?";
		//template.update(q,codePizza);
		return null;
	}
	
	public Pizza findPizzaByCode(String codePizza,int n) throws SQLException {
		String q = "select * from pizza where code=?";
		template.update(q,codePizza);
		return this.template.queryForObject(q,new PizzaMapper(),codePizza);
	}

	@Override
	public boolean isCodeExist(String codePizza) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}
}
