package com.example.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.entities.Produit;

@RestController // For use Rest_Service
public class ProduitRestService {

	@Autowired
	private ProduitsRepository produitsRepository;
	
	@RequestMapping(value="/produits",method=RequestMethod.GET)
	public List<Produit> listProduit() {
		return produitsRepository.findAll();
	}
	
	@RequestMapping(value="/produits/{id}",method=RequestMethod.GET)
	public Produit listProduitOne(@PathVariable Long id) {
		return produitsRepository.findOne(id);
	}
	
	@RequestMapping(value="/produits",method=RequestMethod.POST)
	public Produit save(@RequestBody Produit p) {
		// on envoi les donnees en format JSON POSTMAN
		return produitsRepository.save(p);
	}
	
	@RequestMapping(value="/produits/{id}",method=RequestMethod.PUT)
	public Produit update(@RequestBody Produit p,@PathVariable Long id) {
		// on envoi les donnees en format JSON POSTMAN
		p.setId(id);
		return produitsRepository.saveAndFlush(p);
	}
	
	@RequestMapping(value="/produits/{id}",method=RequestMethod.DELETE)
	public void delete(@PathVariable Long id) {
		// on envoi les donnees en format JSON POSTMAN
		produitsRepository.delete(id);
	}
}
