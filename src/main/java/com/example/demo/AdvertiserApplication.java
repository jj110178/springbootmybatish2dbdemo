package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AdvertiserApplication /*implements  CommandLineRunner */{

//	private Logger logger = LoggerFactory.getLogger(this.getClass());
//
//	@Autowired
//	AdvertiserMapper myMapper;

	public static void main(String[] args) {
		SpringApplication.run(AdvertiserApplication.class, args);
	}

	/*@Override
	public void run(String... args) throws Exception {

		logger.info("Advertiser id 10001 -> {}", myMapper.findById(10001));

		logger.info("Inserting -> {}", myMapper.insert(new Advertiser(10010, "Inmobi", "Will Smith", 10000)));

		logger.info("Update 10003 -> {}", myMapper.update(new Advertiser(10001, "Pinsight", "John Johnson", 30000)));

		myMapper.deleteById(10002);

		logger.info("All Advertisers -> {}", myMapper.findAll());
	}*/
}
