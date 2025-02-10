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
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}

/*
@SpringBootApplication
@ImportResource("classpath:cxf-service.xml")
public class Application {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@PostConstruct
	private void initDb() {
		System.out.println(String.format("****** Creating table: %s, and Inserting test data ******",
				"users, monsters, elements, weapons, armors, rolls, characters"));

		// Cambiar "serial" por "auto_increment" para H2
		String sqlStatements[] = {
				"SET foreign_key_checks = 0;",

				"drop table if exists users",
				"drop table if exists monsters",
				"drop table if exists character_weapon",
				"drop table if exists character_armor",
				"drop table if exists characters",
				"drop table if exists weapons",
				"drop table if exists armors",
				"drop table if exists elements",
				"drop table if exists rolls",


				"create table rolls(id int auto_increment, name varchar(255), primary key (id))",
				"insert into rolls(name) values('Admin')",
				"insert into rolls(name) values('User')",

				"create table users(id int auto_increment, name varchar(255), password varchar(255), roll_id int, primary key (id), FOREIGN KEY (roll_id) REFERENCES rolls(id))",
				"insert into users(name,password,roll_id) values('Manuel','$2a$10$xsibtqBItb3gPtgchRGxR./uK486vLo0ZvS56SGyeQBS33Itav4De',1)",//contra aaa
				"insert into users(name,password,roll_id) values('Pedro','$2a$10$ME9PLC6favE1i/CRSsWoOex8ixwqQSnzPxnbcPAIX9nHH/TBAIGiO',2)",//contra bbb

				"create table monsters(id int, name varchar(255), description varchar(255), primary key (id))",
				"insert into monsters(id,name,description) values(1,'Rathalos','El mayor depredador del Bosque Primigenio, también conocido como rey de los cielos.')",
				"insert into monsters(id,name,description) values(2,'Rathian','Sus poderosas patas traseras y su cola venenosa le facilitan la caza a nivel de suelo, lo que le ha ganado el apodo de reina de la tierra')",

				"create table elements(id int, name varchar(255), primary key (id))",
				"insert into elements(id,name) values(1,'Agua')",
				"insert into elements(id,name) values(2,'Fuego')",

				"create table weapons(id int, name varchar(255), power int, element int, primary key (id), FOREIGN KEY (element) REFERENCES elements(id))",
				"insert into weapons(id,name,power,element) values(1,'Espada',23,1)",
				"insert into weapons(id,name,power,element) values(2,'Mandoble',46,2)",

				"create table armors(id int, name varchar(255), defense int, primary key (id))",
				"insert into armors(id,name,defense) values(1,'Gafas',35)",
				"insert into armors(id,name,defense) values(2,'Collar',85)",

				"create table characters(id int, name varchar(255), primary key (id))",
				"insert into characters(id,name) values(1,'Aleot')",
				"insert into characters(id,name) values(2,'Gamelon')",

				"create table character_weapon (character_id int, weapon_id int, foreign key (character_id) references characters(id), foreign key (weapon_id) references weapons(id))",
				"insert into character_weapon(character_id, weapon_id) select c.id, w.id from characters c, weapons w where c.name = 'Aleot' and w.name = 'Espada'",
				"insert into character_weapon(character_id, weapon_id) select c.id, w.id from characters c, weapons w where c.name = 'Aleot' and w.name = 'Mandoble'",
				"insert into character_weapon(character_id, weapon_id) select c.id, w.id from characters c, weapons w where c.name = 'Gamelon' and w.name = 'Mandoble'",

				"create table character_armor (character_id int, armor_id int, foreign key (character_id) references characters(id), foreign key (armor_id) references armors(id))",
				"insert into character_armor(character_id, armor_id) select c.id, a.id from characters c, armors a where c.name = 'Aleot' and a.name = 'Gafas'",
				"insert into character_armor(character_id, armor_id) select c.id, a.id from characters c, armors a where c.name = 'Aleot' and a.name = 'Collar'",
				"insert into character_armor(character_id, armor_id) select c.id, a.id from characters c, armors a where c.name = 'Gamelon' and a.name = 'Gafas'",

				"SET foreign_key_checks = 1;"

		};

		Arrays.asList(sqlStatements).stream().forEach(sql -> {
			System.out.println(sql);
			jdbcTemplate.execute(sql);
		});

		System.out.println(String.format("****** Fetching from table: %s ******", "rolls"));
		jdbcTemplate.query("select id, name from rolls",
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
		jdbcTemplate.query("select id, name, roll_id from users",
				new RowMapper<Object>() {
					@Override
					public Object mapRow(ResultSet rs, int i) throws SQLException {
						System.out.println(String.format("id:%s, name:%s, roll_id:%s",
								rs.getString("id"),
								rs.getString("name"),
								rs.getString("roll_id")));
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
*/