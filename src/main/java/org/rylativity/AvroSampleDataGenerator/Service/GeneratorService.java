package org.rylativity.AvroSampleDataGenerator.Service;

import org.apache.avro.Schema;
import org.apache.trevni.avro.RandomData;

import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class GeneratorService {

    public String generate(String schema, int numSamples) {

        List<Object> samples = new ArrayList<>();
        Schema parsedSchema = new Schema.Parser().parse(schema);

        for (Object datum : new RandomData(parsedSchema, numSamples)) {

            Map<String, Object> swapMap = new HashMap<>();

            samples.add(datum);
        }

        return samples.toString().replace("\\","");
    }
}
