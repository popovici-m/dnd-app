package com.gmp.dungeonsanddragons.controller;


import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.gmp.dungeonsanddragons.external.ApiReference;
import com.gmp.dungeonsanddragons.external.DndClient;

@RestController
@RequestMapping("/external")
public class DnDExternalController {

	private DndClient clientAPI;
	
	public DnDExternalController(DndClient clientAPI) {
		this.clientAPI = clientAPI;
	}
	
	@ResponseStatus(value = HttpStatus.OK)
	@GetMapping("/races")
	public List<ApiReference> getPossibleRaces() {
		return clientAPI.getRace();
	}
	
	@ResponseStatus(value = HttpStatus.OK)
	@GetMapping("/classes")
	public List<ApiReference> getPossibleClasses() {
		return clientAPI.getCharacterClass();
	}
	
}
