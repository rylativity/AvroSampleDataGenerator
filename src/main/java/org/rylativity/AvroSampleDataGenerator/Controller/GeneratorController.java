package org.rylativity.AvroSampleDataGenerator.Controller;

import org.rylativity.AvroSampleDataGenerator.Service.GeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping()
public class GeneratorController {

    @Autowired
    GeneratorService generator;

    @PostMapping(path =  "/generate", consumes = "application/json", produces = "application/json")
    String generateSampleData(@RequestBody String schema, @RequestParam int numSamples) {

        String samples = generator.generate(schema, numSamples);
        return samples;
    }
}
