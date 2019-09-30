package com.leonardo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.leonardo.dto.BookMusicDTO;
import com.leonardo.utility.UtilityforAPI;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(value = "MidiaSearchController")
@RestController
@RequestMapping("/api")

public class MidiaSearchController {

	@ApiOperation(value = "Search of Books and Albums", notes = "Search for Books and Albums, returning a list", response = BookMusicDTO.class)
	@ApiResponses(value = {
	    @ApiResponse(code = 200, message = "Successful Search for Books and Albums", response = BookMusicDTO.class),
	    @ApiResponse(code = 404, message = "Books and/or Albums not found!"),
	    @ApiResponse(code = 500, message = "Internal server error")}
	)
	@RequestMapping(value="/find", method = RequestMethod.GET)
	public List<BookMusicDTO> findBookAlbum(@RequestParam("input") String input) {
		UtilityforAPI utility = new UtilityforAPI();
		return utility.searchBookMusic(input);
	}
}
