package franxxcode.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class FeatureTest {

    @Test
    void mappedFeature() throws JsonProcessingException {

        ObjectMapper mapper = new ObjectMapper()
                .configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);

        String json = """
                {"ID" : "1", "NAMe" : "Mee"}
                """;

        Person person = mapper.readValue(json, Person.class);

        assertEquals("1", person.getId());
        assertEquals("Mee", person.getName());

    }

    @Test
    void deserializationFeature() throws JsonProcessingException {


        ObjectMapper mapper = new ObjectMapper()
                .configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true)
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
                .configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);

        String json = """
                {"id" : "1", "name" : "Mee", "age" : 30, "hobbies":"coding"}
                """;

        Person person = mapper.readValue(json, Person.class);

        assertEquals("1", person.getId());
        assertEquals("Mee", person.getName());
        assertEquals(List.of("coding"), person.getHobbies());
    }

    @Test
    void serializationFeature() throws JsonProcessingException {


        Person person = new Person();
        person.setId("1");
        person.setName("Mee");
        person.setHobbies(List.of("eat", "sleep"));
        person.setAddress(new Address("Tjr", "BGR", "ID"));

        ObjectMapper mapper = new ObjectMapper()
                .configure(SerializationFeature.INDENT_OUTPUT, true);

        String json = mapper.writeValueAsString(person);

        assertNotNull(json);
        System.out.println(json);
    }
}
