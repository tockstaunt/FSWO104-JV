package com.keithcollier.music;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MusicLibraryApplication {

	public static void main(String[] args) {
		SpringApplication.run(MusicLibraryApplication.class, args);

		// connection to the database
		Connection con;

		// connecting to the database can potentially result in an error, so a try-catch block is used to catch this
		try {
			// connect to the "Chinook_Sqlite.sqlite" database
			// the last two empty strings in the method are for username and password, which aren't necessary here
			con = DriverManager.getConnection("jdbc:sqlite:./Chinook_Sqlite.sqlite", "", "");

			// prepare a Statement object for SQL queries
			Statement stmt = con.createStatement();

			// get all columns from the table "Album"
			ResultSet rs = stmt.executeQuery("SELECT * FROM Album");

			// variables for each column in the database
			int albumId;
			String albumTitle;
			int albumArtistId;

			// access each row in the table
			while (rs.next()) {
				// get the values from each column of the current row
				albumId = rs.getInt("AlbumId");
				albumTitle = rs.getString("Title");
				albumArtistId = rs.getInt("ArtistId");

				// print the values of the row
				System.out.println("Album ID: '" + albumId + "', Title: '" + albumTitle + "', Artist: '" + albumArtistId + "'.");
			}
		} catch (SQLException e) {
			// print the stack trace of the error
			e.printStackTrace();
		}
	}
}