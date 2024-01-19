package data;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ReadData
{
    @DataProvider
    public Iterator<Object[]> getDataFromJson() throws IOException {
        List<Map<String, String>> data = getJsonDataToMap(System.getProperty("user.dir") + "//src//test//java//data//LoginCredentials.json");

        if (data.isEmpty()) {
            throw new RuntimeException("No data found in the JSON file");
        }

        List<Object[]> dataArray = data.stream()
                .map(item -> new Object[]{item})
                .collect(Collectors.toList());

        return dataArray.iterator();
    }

    private List<Map<String, String>> getJsonDataToMap(String filePath) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(new File(filePath), new TypeReference<List<Map<String, String>>>(){});
    }
}
