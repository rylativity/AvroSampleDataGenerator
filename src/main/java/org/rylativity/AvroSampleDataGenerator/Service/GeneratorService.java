package org.rylativity.AvroSampleDataGenerator.Service;

import com.google.gson.Gson;
import org.apache.avro.Schema;
import org.apache.trevni.avro.RandomData;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@Service
public class GeneratorService {

    Gson gson = new Gson();

    public String generate(String schema, int numSamples) {

        List<Object> samples = new ArrayList<>();
        Schema parsedSchema = new Schema.Parser().parse(schema);

        Iterator<Object> it = new RandomData(parsedSchema, numSamples).iterator();
        for (int i=0; i<numSamples; i++) {
            samples.add(it.next());
        }

        return gson.toJson(samples);
    }
}
