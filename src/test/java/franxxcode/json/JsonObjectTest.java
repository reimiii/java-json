package franxxcode.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class JsonObjectTest {
    @Test
    void create() throws JsonProcessingException {

        Map<String, Object> person = Map.of(
                "id", "002",
                "username", "franxx",
                "age", 20,
                "address", Map.of(
                        "street", "Milky way",
                        "city", "Atlantic",
                        "country", "Internet"
                ),
                "hobbies", List.of("Eat Honey", "Call darling", "Drawing Darling")
        );

        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(person);

        assertNotNull(json);

        System.out.println(json);
    }

    @Test
    void read() throws JsonProcessingException {
        String json = """
                {
                  "id": "002",
                  "address": {
                    "country": "Internet",
                    "city": "Atlantic",
                    "street": "Milky way"
                  },
                  "username": "franxx",
                  "age": 20,
                  "hobbies": [
                    "Eat Honey",
                    "Call darling",
                    "Drawing Darling"
                  ]
                }
                  """;

        ObjectMapper mapper = new ObjectMapper();

        Map<String, Object > person = mapper.readValue(json, new TypeReference<Map<String, Object>>() {
        });

        assertEquals("franxx", person.get("username"));
        assertEquals(20, person.get("age"));
        assertEquals(List.of("Eat Honey", "Call darling", "Drawing Darling"), person.get("hobbies"));
    }
}
