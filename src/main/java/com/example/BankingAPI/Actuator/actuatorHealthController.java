package com.example.BankingAPI.Actuator;


import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Controller;


@Controller
public class actuatorHealthController implements HealthIndicator
{
		
		private static final String DataBase_Service = "Data";

		public boolean isHealthGood()
		{
			return true;
		}

		@Override
		public Health health() 
		{
			
			if(isHealthGood())
			{
				return Health.up().withDetail(DataBase_Service, "DataBase Service is running").build();	
			}
			else
			{

			return Health.down().withDetail(DataBase_Service, "DataBase Service is running down").build();
		      }
		}

}



