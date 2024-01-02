package franxxcode.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class JsonArrayTest {


    @Test
    void create() throws JsonProcessingException {
        List<String> hobbies = List.of("eat", "sleep", "coding", "read manga");

        ObjectMapper mapper = new ObjectMapper();

        String json = mapper.writeValueAsString(hobbies);

        assertNotNull(json);

        System.out.println(json);
    }

    @Test
    void read() throws JsonProcessingException {
        String json = """
                ["eat","sleep","coding","read manga"]
                                """;
        ObjectMapper mapper = new ObjectMapper();

        List<String> hobbies = mapper.readValue(json, new TypeReference<List<String>>() {
        });

        assertEquals(List.of("eat", "sleep", "coding", "read manga"), hobbies);
    }
}
