package kz.onggar.collector.util;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

public class TestHelper {

    public static <T> T transformResponseToObject(ResultActions resultAction, Class<T> clazz) throws Exception {
        return new ObjectMapper().readValue(
                resultAction.andReturn().getResponse().getContentAsString(), clazz
        );
    }

    public static <T> List<T> transformResponseToList(ResultActions resultAction, Class<T> clazz) throws Exception {
        var mapper = new ObjectMapper();
        JavaType type = mapper.getTypeFactory().constructCollectionType(List.class, clazz);

        return mapper.readValue(
                resultAction.andReturn().getResponse().getContentAsString(), type
        );
    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static ResultActions makePostRequest(MockMvc mvc, String uriTemplate, Object content, ResultMatcher status) throws Exception {
        return mvc.perform(MockMvcRequestBuilders
                .post(uriTemplate)
                .content(asJsonString(content))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status);
    }

    public static ResultActions makeGetRequest(MockMvc mvc, String uriTemplate, Object content, ResultMatcher status) throws Exception {
        return mvc.perform(MockMvcRequestBuilders
                .get(uriTemplate)
                .content(asJsonString(content))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status);
    }

    public static ResultActions makeGetRequest(MockMvc mvc, String uriTemplate) throws Exception {
        return mvc.perform(MockMvcRequestBuilders
                .get(uriTemplate)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON));
    }
}
