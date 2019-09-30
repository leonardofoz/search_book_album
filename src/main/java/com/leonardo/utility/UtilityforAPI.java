package com.leonardo.utility;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

import com.leonardo.dto.BookMusicDTO;
import com.leonardo.model.Book;
import com.leonardo.model.Items;
import com.leonardo.model.Music;
import com.leonardo.model.Results;

/**
 * Class responsible for fetching data from different APIs, 
 * organizing it, sorting it, and returning 
 * to the application API.
 * @author lemoraes
 * @since 29/09/2019
 */
public class UtilityforAPI {
	
	private HttpHeaders headers;
	private HttpEntity<String> entity;
	private List<BookMusicDTO> listDTO;
	private RestTemplate restTemplate; 
	
	private static final Logger logger = LoggerFactory.getLogger(UtilityforAPI.class);

	public UtilityforAPI() {
		this.listDTO = new ArrayList<BookMusicDTO>();
		this.restTemplate = new RestTemplate();
	}

	/**
	 * Method responsible of initialize headers and
	 * converter for receive all kind of media type
	 * @return 
	 */
	private void initializerHeaderConverter() {
		
        headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(org.springframework.http.MediaType.APPLICATION_JSON));
        entity = new HttpEntity<String>(headers);
        
        //Converter of diferents API
		List<HttpMessageConverter<?>> messageConverters = new ArrayList<HttpMessageConverter<?>>();
		MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
		converter.setSupportedMediaTypes(Collections.singletonList(MediaType.ALL));
		messageConverters.add(converter);
		restTemplate.setMessageConverters(messageConverters);
		
	}
	
	/**
	 * Method responsible of search books from Google Books API
	 * and musics from iTunes API, sort them by title
	 * and return a DTO with the result of these two searches.
	 * @param filtro - String filtro
	 * @return List
	 */
	public List<BookMusicDTO> searchBookMusic(String filtro) {
		
		this.initializerHeaderConverter();
		
        Map<String,String> parameters = new HashMap<String,String>();
        parameters.put("filtro",filtro);
        parameters.put("max","5");
        parameters.put("media","music");
        
		this.getBooks(parameters);
		this.getMusics(parameters);
		
		if(listDTO != null) {
			Collections.sort(listDTO, new Comparator<BookMusicDTO>() {
				public int compare(BookMusicDTO o1, BookMusicDTO o2) {
					return o1.getTitle().compareTo(o2.getTitle());
				}
			});
		}
		
        return listDTO;
	}
	
	
	/**
	 * Method responsible for searching the Google Books API 
	 * and returning five of them.
	 * @param Map<String, String>
	 */
	private void getBooks(Map<String, String> parameters) {
		
		try {
			ResponseEntity<Book> responseEntityBook = restTemplate.exchange(
					"https://www.googleapis.com/books/v1/volumes?q={filtro}&maxResults={max}", HttpMethod.GET, entity,
					Book.class, parameters);
			
			 if(responseEntityBook.getStatusCode().value() == 200){
				 for (Items it : responseEntityBook.getBody().getItems()) {
					 BookMusicDTO dto = new BookMusicDTO();
					 
					if (it.getVolumeInfo().getAuthors() != null) {
						if (it.getVolumeInfo().getAuthors().length > 1)
							dto.setAuthor_artist(String.join(",", it.getVolumeInfo().getAuthors()));
						else
							dto.setAuthor_artist(it.getVolumeInfo().getAuthors()[0]);
					} else {
						dto.setAuthor_artist("");
					}
					dto.setTitle(it.getVolumeInfo().getTitle());
					dto.setType("book");
					 listDTO.add(dto);
				 }				 
			 }
			
		} catch (HttpStatusCodeException he) {
			logger.warn(he.getMessage());
		}
		catch (Exception e) {
			logger.error(e.getMessage());
		}
	}
	
	/**
	 * Method responsible for searching iTunes API albums 
	 * and returning five of them.
	 * @param Map<String, String>
	 */
	private void getMusics(Map<String, String> parameters) {
		
		try {
			ResponseEntity<Music> responseEntityMusic = restTemplate.exchange(
				"https://itunes.apple.com/search?term={filtro}&media={media}&limit={max}", HttpMethod.GET, entity,
				Music.class, parameters);
			if (responseEntityMusic.getStatusCode().value() == 200) {
				for (Results res : responseEntityMusic.getBody().getResults()) {
					BookMusicDTO dto = new BookMusicDTO();
					dto.setAuthor_artist(res.getArtistName());
					dto.setTitle(res.getCollectionName());
					dto.setType("album");
					listDTO.add(dto);
				}
			}
		} catch (HttpStatusCodeException he) {
			logger.warn(he.getMessage());
		}
		catch (Exception e) {
			logger.error(e.getMessage());
		}

	}
	
}
