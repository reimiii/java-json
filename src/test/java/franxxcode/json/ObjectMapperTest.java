package franxxcode.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ObjectMapperTest {

    @Test
    void create() {
        ObjectMapper mapper = new ObjectMapper();

        assertNotNull(mapper);
    }


}
