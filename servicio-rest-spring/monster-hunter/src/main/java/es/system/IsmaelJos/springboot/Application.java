package es.system.IsmaelJos.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import jakarta.annotation.PostConstruct;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;

@SpringBootApplication
public class Application {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@PostConstruct
	private void initDb() {
		System.out.println(String.format("****** Creating table: %s, and Inserting test data ******", "users"));

		// Cambiar "serial" por "auto_increment" para H2
		String sqlStatements[] = {
				"drop table if exists users",
				"drop table if exists monsters",

				"create table users(id int auto_increment, name varchar(255), password varchar(255), primary key (id))",
				"insert into users(name,password) values('Manuel','aaa')",
				"insert into users(name,password) values('Pedro','bbb')",


				"create table monsters(id int auto_increment, name varchar(255), description varchar(255), primary key (id))",
				"insert into monsters(name,description) values('Manuel','aaa')",
				"insert into monsters(name,description) values('Pedro','bbb')"
		};

		Arrays.asList(sqlStatements).stream().forEach(sql -> {
			System.out.println(sql);
			jdbcTemplate.execute(sql);
		});


		System.out.println(String.format("****** Fetching from table: %s ******", "users"));
		jdbcTemplate.query("select id, name from users",
				new RowMapper<Object>() {
					@Override
					public Object mapRow(ResultSet rs, int i) throws SQLException {
						System.out.println(String.format("id:%s, name:%s",
								rs.getString("id"),
								rs.getString("name")));
						return null;
					}
				});
		System.out.println(String.format("****** Fetching from table: %s ******", "monsters"));
		jdbcTemplate.query("select id, name, description from monsters",
				new RowMapper<Object>() {
					@Override
					public Object mapRow(ResultSet rs, int i) throws SQLException {
						System.out.println(String.format("id:%s, name:%s, description:%s",
								rs.getString("id"),
								rs.getString("name"),
								rs.getString("description")));
						return null;
					}
				});
	}
}
