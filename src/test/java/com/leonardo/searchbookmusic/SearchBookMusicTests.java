package com.leonardo.searchbookmusic;

import java.io.IOException;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.leonardo.dto.BookMusicDTO;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes=SearchBookMusicApplication.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class SearchBookMusicTests {

	 //URL base para onde as requests serão feitas
    final String BASE_PATH = "http://localhost:8081/api/find?input=";
    private RestTemplate restTemplate;
    private ObjectMapper MAPPER = new ObjectMapper();
    
    @Before
    public void setUp() throws Exception {
        restTemplate = new RestTemplate();
    }

    @Test
    public void testSearchBookAndMusic() throws IOException{
    	String response = restTemplate.getForObject(BASE_PATH + "Madonna", String.class);
    	
        //Convertemos a resposta JSON para Objeto usando op Jackson
        List<BookMusicDTO> bookMusic = MAPPER.readValue(response, 
            MAPPER.getTypeFactory().constructCollectionType(List.class, BookMusicDTO.class));
        
        Assert.assertNotNull(bookMusic);
    }

}
