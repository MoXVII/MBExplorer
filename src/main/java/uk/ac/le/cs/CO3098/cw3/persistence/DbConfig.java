package uk.ac.le.cs.CO3098.cw3.persistence;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class DbConfig {
    @Bean
    public DriverManagerDataSource dataSource() {       
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/MBExplorer");
		ds.setUsername("root");
		ds.setPassword("miewuefi");
    	return ds;
    }
}


/* Terminal Tunneling code
 * 
 * ssh -fNg -L 3307:mysql.mcscw3.le.ac.uk:3306 mm698@xanthus.mcscw3.le.ac.uk
 */
