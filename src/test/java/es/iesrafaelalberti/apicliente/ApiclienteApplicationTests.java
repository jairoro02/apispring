package es.iesrafaelalberti.apicliente;

import es.iesrafaelalberti.apicliente.repositories.*;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.http.MediaType;



import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.httpBasic;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ApiclienteApplicationTests {

    @Autowired
    MockMvc mvc;
    @Autowired
    PersonRepository personRepository;
    @Autowired
    FavoritosRepository favoritosRepository;
    @Autowired
    HeroesRepository heroesRepository;
    @Autowired
    VillanosRepository villanosRepository;
    @Autowired
    UniverseRepository universeRepository;

    @Test
    void rootWhenUnauthenticatedThen401() throws Exception {
        this.mvc.perform(get("/"))
                .andExpect(status().isUnauthorized());
    }

    @Order(1)
    @Test
    void contextLoads() {
        assert personRepository.count() == 1;
        assert heroesRepository.count() == 5;
        assert favoritosRepository.count() == 5;
        assert universeRepository.count() == 2;
        assert villanosRepository.count() == 7;

    }

    @Order(2)
    @Test
    void listTest() throws Exception {
        MvcResult result = this.mvc.perform(post("/token")
                        .with(httpBasic("jairoro","paco1234")))
                .andExpect(status().isOk())
                .andReturn();
        String token = result.getResponse().getContentAsString();



        mvc.perform(get("/heroes/")
                        .header("Authorization","Bearer " + token)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
    }


    @Order(3)
    @Test
    void creationTest() throws Exception {
        MvcResult result = this.mvc.perform(post("/token")
                        .with(httpBasic("jairoro","paco1234")))
                .andExpect(status().isOk())
                .andReturn();
        String token = result.getResponse().getContentAsString();


        long heroesCount = heroesRepository.count();

        //1962-05-23T00:04:25.615+00:00

        String testHeroe = "{\"fecha_creacion\": \"1962-05-23T00:04:25.615+00:00\", \"name\": \"Cochinato\"," +
                "\"descripcion\": \"el mas guapo\",\"edad\": 56,\"sexo\": \"Hombre\",\"image\": \"url_image\"}";
        mvc.perform(post("/heroes/create/")
                        .header("Authorization","Bearer " + token)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(testHeroe))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.fecha_creacion").value("1962-05-23T00:04:25.615+00:00"))
                .andExpect(jsonPath("$.name").value("Cochinato"))
                .andExpect(jsonPath("$.descripcion").value("el mas guapo"))
                .andExpect(jsonPath("$.edad").value(56))
                .andExpect(jsonPath("$.sexo").value("Hombre"))
                .andExpect(jsonPath("$.image").value("url_image"));
        assert heroesRepository.count() == heroesCount + 1;
    }

    @Order(4)
    @Test
    void getOneHero() throws Exception{
        MvcResult result = this.mvc.perform(post("/token")
                        .with(httpBasic("jairoro","paco1234")))
                .andExpect(status().isOk())
                .andReturn();
        String token = result.getResponse().getContentAsString();

        mvc.perform(get("/heroes/1/")
                        .header("Authorization","Bearer " + token)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
    }

    @Order(5)
    @Test
    void updateOneHero() throws Exception{
        MvcResult result = this.mvc.perform(post("/token")
                        .with(httpBasic("jairoro","paco1234")))
                .andExpect(status().isOk())
                .andReturn();
        String token = result.getResponse().getContentAsString();

        String testHeroe = "{\"fecha_creacion\": \"1962-05-23T00:04:25.615+00:00\", \"name\": \"Mariote\"," +
                "\"descripcion\": \"el mas guapo\",\"edad\": 57,\"sexo\": \"Hombre\",\"image\": \"url_image\"}";

        mvc.perform(put("/heroes/1/")
                        .header("Authorization","Bearer " + token)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(testHeroe))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.fecha_creacion").value("1962-05-23T00:04:25.615+00:00"))
                .andExpect(jsonPath("$.name").value("Mariote"))
                .andExpect(jsonPath("$.descripcion").value("el mas guapo"))
                .andExpect(jsonPath("$.edad").value(57))
                .andExpect(jsonPath("$.sexo").value("Hombre"))
                .andExpect(jsonPath("$.image").value("url_image"));
    }

    @Order(6)
    @Test
    void deleteOneHero() throws Exception{
        MvcResult result = this.mvc.perform(post("/token")
                        .with(httpBasic("jairoro","paco1234")))
                .andExpect(status().isOk())
                .andReturn();
        String token = result.getResponse().getContentAsString();

        long heroCount = heroesRepository.count();
        mvc.perform(delete("/heroes/1/")
                        .header("Authorization","Bearer " + token)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string("true"));
        assert heroesRepository.count() == heroCount -1;
    }
}
