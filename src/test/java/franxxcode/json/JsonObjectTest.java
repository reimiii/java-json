package franxxcode.json;

import com.fasterxml.jackson.core.JsonProcessingException;
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

        System.out.println(json);
    }
}
