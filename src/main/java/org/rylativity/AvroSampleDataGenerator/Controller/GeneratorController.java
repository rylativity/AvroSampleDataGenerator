package org.rylativity.AvroSampleDataGenerator.Controller;

import org.rylativity.AvroSampleDataGenerator.Service.GeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import org.apache.avro.Schema;
import org.apache.trevni.avro.RandomData;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@RestController
public class GeneratorController {

    @Autowired
    GeneratorService generator;

    @PostMapping("/generate")
    List<String> generateSampleData(@RequestBody String schema, @RequestParam int numSamples) {

        List<String> samples = generator.generate(schema, numSamples);
        return samples;
    }
}
