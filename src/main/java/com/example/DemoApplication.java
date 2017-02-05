package com.example;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.example.dao.ProduitsRepository;
import com.example.entities.Produit;

@SpringBootApplication
public class DemoApplication  implements CommandLineRunner{

	@Autowired
	ProduitsRepository produitsRepository;
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		
	}

	@Override
	public void run(String... arg0) throws Exception {
		//execute after end application run
		produitsRepository.save(new Produit("iphone 6s",900,21));
		produitsRepository.save(new Produit("iphone 7",1000,21));
		produitsRepository.save(new Produit("iphone 7 plus",1200,21));
		
		List<Produit> prods = produitsRepository.findAll();
		prods.forEach(p->System.out.println(p.getDesignation()));
		
	}
}
