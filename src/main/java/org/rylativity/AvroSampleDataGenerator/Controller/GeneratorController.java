package org.rylativity.AvroSampleDataGenerator.Controller;

import org.rylativity.AvroSampleDataGenerator.Service.GeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.apache.avro.Schema;
import org.apache.trevni.avro.RandomData;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@RestController
@RequestMapping()
public class GeneratorController {

    @Autowired
    GeneratorService generator;

    @PostMapping("/generate")
    String generateSampleData(@RequestBody String schema, @RequestParam int numSamples) throws IOException {

        String samples = generator.generate(schema, numSamples);
        return samples;
    }
}
