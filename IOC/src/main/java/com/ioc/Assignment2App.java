package com.ioc;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;


import com.ioc.config.Assignment2Config;
import com.ioc.models.Country;
import com.ioc.models.Player;


@ComponentScan("com.ioc.config")
public class Assignment2App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context = new AnnotationConfigApplicationContext(Assignment2Config.class);
		
		//create two country
		Country india= context.getBean("country", Country.class);
		india.setCountryId("1");
		india.setCountryName("INDIA");
		
		Country europe= context.getBean("country", Country.class);
		europe.setCountryId("2");
		europe.setCountryName("EUROPE");
		
		Player player1 = context.getBean("player", Player.class);
		Player player2 = context.getBean("player", Player.class);
		Player player3 = context.getBean("player", Player.class);
		Player player4 = context.getBean("player", Player.class);
		Player player5 = context.getBean("player", Player.class);
		
		player1.setCountry(europe);
		player1.setPlayerId("1");
		player1.setPlayerName("Virat");
		player2.setCountry(europe);
		player2.setPlayerId("2");
		player2.setPlayerName("Rohit");
		
		player3.setCountry(india);
		player3.setPlayerId("3");
		player3.setPlayerName("Sachin");
		player4.setCountry(india);
		player4.setPlayerId("4");
		player4.setPlayerName("Shewag");
		player5.setCountry(india);
		player5.setPlayerId("5");
		player5.setPlayerName("Ghambir");
		List<Player> playersList = new ArrayList<Player>();
		playersList.add(player1);
		playersList.add(player2);
		playersList.add(player3);
		playersList.add(player4);
		playersList.add(player5);
		
		
		System.out.println("Player Id | Player Name | Country Id | Country Name ");
		for(Player player : playersList) {
			System.out.println(player.getPlayerId()+" | "+player.getPlayerName()+" | "+ player.getCountry().getCountryId()+" | "
					+player.getCountry().getCountryName());

		}
		String option = null ;
		Scanner scanner = new Scanner(System.in);
		do  {
			System.out.println("Enter country name: ");
			String countryName = scanner.next();
			
			 if(!countryName.equalsIgnoreCase("India") && !countryName.equalsIgnoreCase("europe") ) {
				 System.err.println("Not Valid Country.");
				 System.out.println("Do you want to continue (y/n) ?");
				 option = scanner.next();
				 continue;
			 }
			 for(Player player : playersList) {
				 if(countryName.equalsIgnoreCase(player.getCountry().getCountryName())) {
					 System.out.println(player.getPlayerId()+" | "+player.getPlayerName()+" | "+ player.getCountry().getCountryId()+" | "
								+player.getCountry().getCountryName());
				 }
				 option = "";
			 }
			 
		}while(option.equalsIgnoreCase("y") || option.equalsIgnoreCase("yes"));
		 
		 
		
	}
	
	

}
