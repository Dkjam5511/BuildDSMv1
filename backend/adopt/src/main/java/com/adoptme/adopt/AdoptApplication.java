package com.adoptme.adopt;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AdoptApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdoptApplication.class, args);
		DogBreedParser.getDogBreedData();
	}

	public static class DogBreedParser {
		public static void getDogBreedData() {
			String csvFile = "src/main/resources/akc-data-latest.csv";
			String line;

			try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
				Connection conn = DriverManager.getConnection("jdbc:h2:~/adoptme", "adoptme", "password");

				// Read the first line to get the column names
				line = br.readLine();
				String[] columnNames = line.split(",(?!\\s)");
				//print column names
				for (String columnName : columnNames) {
					System.out.println(columnName);
				}

				conn.createStatement().execute("DROP TABLE IF EXISTS dog_breeds");

				// Create the table dynamically based on the column names
				createTable(conn, columnNames);

				// Prepare the insert statement
				String insertQuery = generateInsertQuery(columnNames);
				PreparedStatement pstmt = conn.prepareStatement(insertQuery);

				// Process the remaining lines
				while ((line = br.readLine()) != null) {
					String[] data = line.split(",(?!\\s)");
					setParameters(pstmt, data);
					pstmt.executeUpdate();
				}

				pstmt.close();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		private static void createTable(Connection conn, String[] columnNames) throws SQLException {
			StringBuilder createTableQuery = new StringBuilder("CREATE TABLE dog_breeds (");
			for (String columnName : columnNames) {
				createTableQuery.append(columnName).append(" VARCHAR(255), ");
			}
			createTableQuery.setLength(createTableQuery.length() - 2); // Remove the last comma and space
			createTableQuery.append(")");
			conn.createStatement().execute(createTableQuery.toString());
		}

		private static String generateInsertQuery(String[] columnNames) {
			StringBuilder insertQuery = new StringBuilder("INSERT INTO dog_breeds (");
			for (String columnName : columnNames) {
				insertQuery.append(columnName).append(", ");
			}
			insertQuery.setLength(insertQuery.length() - 2); // Remove the last comma and space
			insertQuery.append(") VALUES (");
			for (int i = 0; i < columnNames.length; i++) {
				insertQuery.append("?, ");
			}
			insertQuery.setLength(insertQuery.length() - 2); // Remove the last comma and space
			insertQuery.append(")");
			return insertQuery.toString();
		}

		private static void setParameters(PreparedStatement pstmt, String[] data) throws SQLException {
			for (int i = 0; i < data.length; i++) {
				try {
					pstmt.setString(i + 1, data[i]);
				} catch (SQLException e) {
					//print data length and data[0
					System.out.println(data[0]);
					System.out.println(data.length);
				}
			}
		}
	}
}
