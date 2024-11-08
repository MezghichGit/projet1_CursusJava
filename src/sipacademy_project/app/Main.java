package sipacademy_project.app;

import java.sql.*;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws SQLException {
		// System.out.println("Hello JDBC from Java");

		Connection con = null;
		// try {
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projetjdbc", "root", "");
		// } catch (SQLException e) {
		// TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		// System.out.println("Connexion réussi : " +con);

		// Lecture des paramètres à partir du clavier
		
		//Scanner sc = new Scanner(System.in); // System.in : lecture du clavier
		
		//System.out.println("Donner un nom");
		//String name = sc.nextLine();
		
		//System.out.println("Donner la classe");
		//String classe = sc.nextLine();
		
		Statement stmt = con.createStatement();
		//int result = stmt.executeUpdate("insert into etudiant(nom,classe) values('Mahfoudh', '3 ieme')");
		//int result = stmt.executeUpdate("insert into etudiant(nom,classe) values('"+nom+"', '"+classe+"')");
		//System.out.println(result);
		
		
		// STEP 2 : Exemple de Update
		
		//stmt.executeUpdate("update etudiant set nom='"+name+"' where id='1'");
		
		// STEP 5 : Delete
		
		stmt.executeUpdate("delete from etudiant where id='2'");
		
		// STEP 3: Création objet ResultSET(table en mémoire) dont le rôle est de stocker le résultat d'une requete select
		ResultSet rs = stmt.executeQuery("select id, nom, classe from etudiant");
		// STEP 4: On fait le parcours du ResultSet et on affiche son contenu
		while(rs.next()) {
		int id = rs.getInt("id");
		String nom = rs.getString("nom");
		String classe = rs.getString("classe");
		System.out.println(id+ " "+nom +" "+classe);
		}

	}

}
