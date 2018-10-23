package com.hambre.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hambre.model.Combo;
import com.hambre.service.ComboService;

@Controller
@RequestMapping(path="/", produces=MediaType.APPLICATION_JSON_VALUE)
public class ComboController {
	@Autowired
	@Qualifier("comboService")
	ComboService comboService;
	
	@GetMapping("combo")
	public ResponseEntity<List<Combo>> getAllCombo(){
			return new ResponseEntity<>(comboService.getAllCombo(),  HttpStatus.OK);
		}
	
	@GetMapping("combo/{comId}")
	public ResponseEntity<Combo> getByIdCombo(@PathVariable Integer comId){
			return new ResponseEntity<>(comboService.getByIdCombo(comId), HttpStatus.FOUND);
		}
	
	@PutMapping("combo/{comId}")
	public ResponseEntity<Combo> updateCombo(@PathVariable Integer comId, @RequestBody Combo combo) {
		return new ResponseEntity<>(comboService.updateCombo(comId, combo), HttpStatus.OK);
	}
	
	@PostMapping("combo")
	public ResponseEntity<Combo> createCombo(@RequestBody Combo combo) {
		return new ResponseEntity<>(comboService.createCombo(combo), HttpStatus.CREATED);
	}
	
	@DeleteMapping("combo/{comId}")
	public ResponseEntity<?> deleteCombo (@PathVariable Integer comId) {
		return new ResponseEntity<>(comboService.removeByIdCombo(comId), HttpStatus.OK);
	}
}