package franxxcode.json;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class DateTimeTest {

    @Test
    void dateTime() throws JsonProcessingException {


        ObjectMapper mapper = new ObjectMapper()
                .setSerializationInclusion(JsonInclude.Include.NON_NULL);

        Person person = new Person();
        person.setId("1");
        person.setName("ZeroTwo");
        person.setCreatedAt(new Date());
        person.setUpdatedAt(new Date());

        String json = mapper.writeValueAsString(person);

        assertNotNull(json);
        System.out.println(json);
    }


    @Test
    void dateTimeFormat() throws JsonProcessingException {

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        ObjectMapper mapper = new ObjectMapper()
                .setSerializationInclusion(JsonInclude.Include.NON_NULL)
                .configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false)
                .setDateFormat(dateFormat);

        Person person = new Person();
        person.setId("1");
        person.setName("ZeroTwo");
        person.setCreatedAt(new Date());
        person.setUpdatedAt(new Date());

        String json = mapper.writeValueAsString(person);

        System.out.println(json);
    }
}
