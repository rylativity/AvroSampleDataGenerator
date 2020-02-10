# AvroSampleDataGenerator
RESTful API To Generate Sample JSON Data From Avro Schema

This repository packages simple sample-data-generation functionality from the trevni-avro dependency 
into a Spring-Boot REST API.
*Requires Maven Installation

To easily run the application, clone the repository to your computer, change into the project's root directory 
(containing the pom.xml), and run `mvn clean spring-boot:run`.  You can also configure your IDE to run the same Maven command.

Once the application is running, the data generator will be available on localhost:8080.  The endpoint takes a `POST` request
and expects the RequestBody to contain a valid AVRO schema string, and a RequestParam, numSamples, indicating the number 
of sample data objects desired.

## Example Usage (once application is running locally)
curl -X POST localhost:8080/generate?numSamples=10 -d "{\"type\": \"record\",\"namespace\": \"com.example\",\"name\": \"FullName\",\"fields\": [{ \"name\": \"first\", \"type\": \"string\" },{ \"name\": \"last\", \"type\": \"string\" }]}" -H "Content-Type: application/json"
