package cn.fxbworld;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
public class AdminApplication {

	private static Logger log = LoggerFactory.getLogger(AdminApplication.class);

	public static void main(String[] args) {
		Environment env = SpringApplication.run(AdminApplication.class, args).getEnvironment();
		log.info(
				"\n----------------------------------------------------------\n\t"
						+ "Application '{}' is running! Access URLs:\n\t"
						+ "Local: \t\thttp://localhost:{}\n----------------------------------------------------------",
				env.getProperty("spring.application.name"), env.getProperty("server.port"));
	}
}
