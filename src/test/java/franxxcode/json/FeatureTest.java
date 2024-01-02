package franxxcode.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

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
}
