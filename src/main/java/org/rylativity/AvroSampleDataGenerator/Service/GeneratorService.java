package org.rylativity.AvroSampleDataGenerator.Service;

import org.apache.avro.Schema;
import org.apache.trevni.avro.RandomData;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class GeneratorService {

    public List<String> generate(String schema, int numSamples){

        List<String> samples = new ArrayList<>();
        Schema parsedSchema = new Schema.Parser().parse(schema);

        Iterator<Object> it = new RandomData(parsedSchema, numSamples).iterator();
            for (int i=0; i<numSamples; i++) {
            samples.add(it.next().toString().replace("\"", "'"));
        }
            return samples;
    }
}
