package com.gmp.dungeonsanddragons.controller;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.gmp.dungeonsanddragons.model.CharacterInfo;
import com.gmp.dungeonsanddragons.service.CharacterService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/characters")
public class CharacterController {

	private CharacterService characterService;
	
	public CharacterController(CharacterService characterService) {
		this.characterService = characterService;
	}
	
	@ResponseStatus(value = HttpStatus.OK)
	@PostMapping(value = "/", produces = "application/json")
	@ApiOperation(value = "Create a character", notes = "Create a character", response = CharacterInfo.class)
	public CharacterInfo createCharacter(@RequestBody CharacterInfo character) {
		return characterService.save(character);
	}
	
	
	@ResponseStatus(value = HttpStatus.OK)
	@GetMapping("/getUserCharacter/{email}")
	@ApiOperation(value = "Get the user defined characters by user email", notes = "Get the user defined characters by user email", response = Page.class)
	public Page<CharacterInfo> getUserCharacter(@PathVariable(required = false) String email, @PageableDefault(size = 20) Pageable pageable) {
		return characterService.getUserCharacter(email, pageable);
	}
	
}
