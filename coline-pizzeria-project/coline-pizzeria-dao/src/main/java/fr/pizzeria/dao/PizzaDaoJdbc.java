package fr.pizzeria.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import java.sql.PreparedStatement;

import fr.pizzeria.Exception.DeletePizzaException;
import fr.pizzeria.Exception.SavePizzaException;
import fr.pizzeria.Exception.UpdatePizzaException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

public class PizzaDaoJdbc implements PizzaDao {
	Statement st;
	Connection con;
	
	public void pizzaDaoConnect() throws SQLException {
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pizzeria","root","");
		st = con.createStatement();
	}
	
	public void pizzaDaoDisconnect() throws SQLException{
		con.close();
	}
	@Override
	public List<Pizza> findAllPizzas() throws SQLException {
		List<Pizza> pizz= new ArrayList<Pizza>();
		ResultSet rs;
		try {
			pizzaDaoConnect();
			rs = st.executeQuery("select * from pizza");
			while(rs.next()){
				int id = rs.getInt("pizzaID");
				String codepizza = rs.getString("code");
				String nom = rs.getString("libelle");
				double price = rs.getDouble("prix");//System.out.println("j'ai recu^le prix");
				String cat = rs.getString("categorie");//System.out.println("j'ai recu^la categ " + CategoriePizza.valueOf(cat.toUpperCase()));
				
				//System.out.println(CategoriePizza.valueOf(cat.toUpperCase()));
				pizz.add(new Pizza(id,codepizza,nom,price,CategoriePizza.valueOf(cat.toUpperCase())));				
		}
			rs.close();
		} catch (SQLException e1) {
			// 
			e1.printStackTrace();
		}
		
		pizzaDaoDisconnect();
		return pizz;
	}
	@Override
	public boolean saveNewPizza(Pizza pizza) throws SavePizzaException {
		try{
			pizzaDaoConnect();
			PreparedStatement ps=con.prepareStatement("insert into pizza (code,libelle,prix,categorie)"
					+ "values(?,?,?,?)");
			ps.setString(1, pizza.getCode());
			ps.setString(2,pizza.getNom());
			ps.setDouble(3, pizza.getPrix());
			String s=pizza.getCat().getValue();
			ps.setString(4, s);//System.out.println(ps.toString());
			ps.executeUpdate();
			//ps.close();
			pizzaDaoDisconnect();
		}
		catch (SQLException e1) {
			 
			e1.printStackTrace();
		}
		
		return false;
	}

	@Override
	public boolean updatePizza(String codePizza, Pizza pizza) throws UpdatePizzaException {
		
		try {
			pizzaDaoConnect();System.out.println("id= "+pizza.getId());
			PreparedStatement ps=con.prepareStatement("update pizza set code=?, libelle =?, prix =?, categorie =? where pizzaID=?");
			ps.setString(1,pizza.getCode());
			ps.setString(2,pizza.getNom());
			ps.setDouble(3, pizza.getPrix());
			ps.setString(4, pizza.getCat().getValue());
			ps.setInt(5, pizza.getId());//System.out.println(ps.toString());
			ps.executeUpdate();
			pizzaDaoDisconnect();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return false;
	}
	@Override
	public boolean deletePizza(String codePizza) throws DeletePizzaException {
		
		try {	
			pizzaDaoConnect();
            PreparedStatement ps = con.prepareStatement("DELETE FROM pizza WHERE code=?");
            ps.setString(1,codePizza);
            //System.out.println(ps);
            ps.execute();
            pizzaDaoDisconnect();        
        } catch (SQLException e) {
            
            e.printStackTrace();
        }

            
            return true;
	}
	@Override
	public Optional<Pizza> findPizzaByCode(String codePizza) throws SQLException {
		Optional<Pizza> optPizza = findAllPizzas().stream()
	            .filter(p -> p.getCode().equals(codePizza))
	            .findAny();
	        return optPizza;
	}
	@Override
	public boolean isCodeExist(String codePizza) throws SQLException {
		return findPizzaByCode(codePizza).isPresent();
	}
}
