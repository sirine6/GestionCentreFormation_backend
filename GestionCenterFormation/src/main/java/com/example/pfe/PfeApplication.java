package com.example.pfe;

import com.example.pfe.storage.StorageService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.Resource;

@SpringBootApplication
public class PfeApplication  implements CommandLineRunner {
@Resource
private StorageService storageService;
	public static void main(String[] args) {
		SpringApplication.run(PfeApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//	storageService.deleteAll();
//	storageService.init();
	}
}
