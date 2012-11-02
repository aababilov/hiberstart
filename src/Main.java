import java.util.Date;
import java.util.List;

import org.hibernate.Session;

import players.Player;

public class Main {
	private static Session session = null;

	private static void load() {
		List<Player> allPlayers = (List<Player>) session.createQuery(
				"from players.Player").list();
		for (Player player : allPlayers) {
			System.out.println(player);
		}
	}

	private static void generate() {
		Player pl = new Player();

		pl.setFirstName("firstName");
		pl.setLastName("lastName - generated at " + new Date().toString());
		pl.setAge(10);
		pl.setExp(2000);
		pl.setLevel(52);
		pl.setNumber(11);
		pl.setPosition('G');
		pl.setStatus("free");
		pl.setId(1);
		session.save(pl);
	}

	public static void main(String[] args) {
		session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();

		// generate();

		load();

		session.getTransaction().commit();
		session.close();
	}

}
