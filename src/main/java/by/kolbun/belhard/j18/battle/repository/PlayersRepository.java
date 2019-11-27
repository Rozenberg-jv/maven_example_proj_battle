package by.kolbun.belhard.j18.battle.repository;

import by.kolbun.belhard.j18.battle.model.Player;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PlayersRepository {

	private static final String GET_ALL_PLAYERS = "select * from players";

	public List<Player> getAllPlayers() {

		List<Player> playersList = new ArrayList<>();

		try {
			Connection connection = ConnectionManager.getConnection();
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(GET_ALL_PLAYERS);

			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String name = resultSet.getString("name");
				int maxHp = resultSet.getInt("max_hp");

				playersList.add(Player.builder().id(id).name(name).maxHp(maxHp).build());
			}
		} catch (SQLException e) {
			System.err.println("Error while loading players list");
			e.printStackTrace();
		}

		return playersList;
	}

}
