package by.kolbun.belhard.j18.battle.repository;

import by.kolbun.belhard.j18.battle.model.Weapon;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class WeaponRepository {

	private static final String GET_ALL_WEAPONS = "select * from weapons";

	public List<Weapon> getAllWeapons() {

		List<Weapon> weaponsList = new ArrayList<>();

		try {
			Connection connection = ConnectionManager.getConnection();
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(GET_ALL_WEAPONS);

			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String title = resultSet.getString("title");
				int minDmg = resultSet.getInt("min_dmg");
				int maxDmg = resultSet.getInt("max_dmg");
				int cooldown = resultSet.getInt("cooldown");

				weaponsList.add(Weapon.builder().id(id).title(title).minDmg(minDmg).maxDmg(maxDmg).cooldown(cooldown).build());
			}
		} catch (SQLException e) {
			System.err.println("Error while loading weapons list");
			e.printStackTrace();
		}

		return weaponsList;
	}

}
