package franxxcode.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class JavaBeanTest {

    @Test
    void objectToJson() throws JsonProcessingException {

        Person person = new Person();
        person.setId("1");
        person.setName("Mee");
        person.setHobbies(List.of("eat", "sleep"));
        person.setAddress(new Address("Tjr", "BGR", "ID"));

        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(person);

        assertNotNull(json);
        System.out.println(json);
    }

    @Test
    void readObjectFromJson() throws JsonProcessingException {

        String json = """
                {
                  "id": "1",
                  "name": "Mee",
                  "hobbies": [
                    "eat",
                    "sleep"
                  ],
                  "address": {
                    "street": "Tjr",
                    "city": "BGR",
                    "country": "ID"
                  }
                }
                                """;

        ObjectMapper mapper = new ObjectMapper();

        Person person = mapper.readValue(json, Person.class);

        assertEquals("Mee", person.getName());
        assertEquals("1", person.getId());
        assertEquals("ID", person.getAddress().getCountry());
        assertEquals(List.of("eat", "sleep"), person.getHobbies());
    }
}
