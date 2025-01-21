package es.system.ismaeljos.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import jakarta.annotation.PostConstruct;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;

@SpringBootApplication
@ImportResource("classpath:cxf-service.xml")
public class Application {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@PostConstruct
	private void initDb() {
		System.out.println(String.format("****** Creating table: %s, and Inserting test data ******",
				"users, monsters, elements, weapons, armors, rols"));

		// Cambiar "serial" por "auto_increment" para H2
		String sqlStatements[] = {
				"drop table if exists users",
				"drop table if exists monsters",
				"drop table if exists elements",
				"drop table if exists weapons",
				"drop table if exists armors",
				"drop table if exists rols",

				"create table rols(id int auto_increment, name varchar(255), primary key (id))",
				"insert into rols(name) values('Admin')",
				"insert into rols(name) values('User')",

				"create table users(id int auto_increment, name varchar(255), password varchar(255), rol int, primary key (id), FOREIGN KEY (rol) REFERENCES rols(id))",
				"insert into users(name,password,rol) values('Manuel','aaa',1)",
				"insert into users(name,password,rol) values('Pedro','bbb',2)",

				"create table monsters(id int, name varchar(255), description varchar(255), primary key (id))",
				"insert into monsters(id,name,description) values(1,'Rathalos','El mayor depredador del Bosque Primigenio, también conocido como rey de los cielos.')",
				"insert into monsters(id,name,description) values(2,'Rathian','Sus poderosas patas traseras y su cola venenosa le facilitan la caza a nivel de suelo, lo que le ha ganado el apodo de reina de la tierra')",

				"create table elements(id int, name varchar(255), primary key (id))",
				"insert into elements(id,name) values(1,'Agua')",
				"insert into elements(id,name) values(2,'Fuego')",

				"create table weapons(id int, name varchar(255), power int, primary key (id))",
				"insert into weapons(id,name,power) values(1,'Espada',23)",
				"insert into weapons(id,name,power) values(2,'Mandoble',46)",

				"create table armors(id int, name varchar(255), defense int, primary key (id))",
				"insert into armors(id,name,defense) values(1,'Gafas',35)",
				"insert into armors(id,name,defense) values(2,'Collar',85)"

		};

		Arrays.asList(sqlStatements).stream().forEach(sql -> {
			System.out.println(sql);
			jdbcTemplate.execute(sql);
		});

		System.out.println(String.format("****** Fetching from table: %s ******", "rols"));
		jdbcTemplate.query("select id, name from rols",
				new RowMapper<Object>() {
					@Override
					public Object mapRow(ResultSet rs, int i) throws SQLException {
						System.out.println(String.format("id:%s, name:%s",
								rs.getString("id"),
								rs.getString("name")));
						return null;
					}
				});
		System.out.println(String.format("****** Fetching from table: %s ******", "users"));
		jdbcTemplate.query("select id, name, rol from users",
				new RowMapper<Object>() {
					@Override
					public Object mapRow(ResultSet rs, int i) throws SQLException {
						System.out.println(String.format("id:%s, name:%s, rol:%s",
								rs.getString("id"),
								rs.getString("name"),
								rs.getString("rol")));
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
		System.out.println(String.format("****** Fetching from table: %s ******", "elements"));
		jdbcTemplate.query("select id, name from elements",
				new RowMapper<Object>() {
					@Override
					public Object mapRow(ResultSet rs, int i) throws SQLException {
						System.out.println(String.format("id:%s, name:%s",
								rs.getString("id"),
								rs.getString("name")));
						return null;
					}
				});
		System.out.println(String.format("****** Fetching from table: %s ******", "weapons"));
		jdbcTemplate.query("select id, name, power from weapons",
				new RowMapper<Object>() {
					@Override
					public Object mapRow(ResultSet rs, int i) throws SQLException {
						System.out.println(String.format("id:%s, name:%s, power:%s",
								rs.getString("id"),
								rs.getString("name"),
								rs.getString("power")));
						return null;
					}
				});
		System.out.println(String.format("****** Fetching from table: %s ******", "armors"));
		jdbcTemplate.query("select id, name, defense from armors",
				new RowMapper<Object>() {
					@Override
					public Object mapRow(ResultSet rs, int i) throws SQLException {
						System.out.println(String.format("id:%s, name:%s, defense:%s",
								rs.getString("id"),
								rs.getString("name"),
								rs.getString("defense")));
						return null;
					}
				});
	}
}
