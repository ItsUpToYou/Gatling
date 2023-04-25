package videogamedb;

import java.time.Duration;
import java.util.*;

import io.gatling.javaapi.core.*;
import io.gatling.javaapi.http.*;
import io.gatling.javaapi.jdbc.*;

import static io.gatling.javaapi.core.CoreDsl.*;
import static io.gatling.javaapi.http.HttpDsl.*;
import static io.gatling.javaapi.jdbc.JdbcDsl.*;

public class RecordedSimulationProxy extends Simulation {

  private HttpProtocolBuilder httpProtocol = http
    .baseUrl("https://videogamedb.uk")
    .inferHtmlResources(AllowList(), DenyList(".*\\.js", ".*\\.css", ".*\\.gif", ".*\\.jpeg", ".*\\.jpg", ".*\\.ico", ".*\\.woff", ".*\\.woff2", ".*\\.(t|o)tf", ".*\\.png", ".*detectportal\\.firefox\\.com.*"))
    .acceptHeader("*/*")
    .acceptEncodingHeader("gzip, deflate")
    .userAgentHeader("PostmanRuntime/7.32.2");
  
  private Map<CharSequence, String> headers_0 = Map.of("Postman-Token", "3a1d95b8-7a28-44ea-a621-2c06c2ce9799");
  
  private Map<CharSequence, String> headers_1 = Map.of("Postman-Token", "7f1fdbe1-4d68-40a8-9d3c-3fbf0ddc772b");
  
  private Map<CharSequence, String> headers_2 = Map.ofEntries(
    Map.entry("Content-Type", "application/json"),
    Map.entry("Postman-Token", "1cdc3ab7-dfc7-4e8e-bc4d-179ae30e1b29")
  );
  
  private Map<CharSequence, String> headers_3 = Map.ofEntries(
    Map.entry("Content-Type", "application/json"),
    Map.entry("Postman-Token", "fa14507f-de50-4033-a7f3-f4a14198e172")
  );
  
  private Map<CharSequence, String> headers_4 = Map.ofEntries(
    Map.entry("Content-Type", "application/json"),
    Map.entry("Postman-Token", "8dffeb8c-046b-4bcc-9f56-aa9f0c8d580a"),
    Map.entry("authorization", "Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1pbiIsImlhdCI6MTY4MTkwMDg1MSwiZXhwIjoxNjgxOTA0NDUxfQ.a0MxEtgD6_VVWqmRvdCjEWE18PuK1Az_zYzQPArkXa8eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1pbiIsImlhdCI6MTY4MTkwMDg1MSwiZXhwIjoxNjgxOTA0NDUxfQ.a0MxEtgD6_VVWqmRvdCjEWE18PuK1Az_zYzQPArkXa8")
  );
  
  private Map<CharSequence, String> headers_5 = Map.ofEntries(
    Map.entry("Content-Type", "application/json"),
    Map.entry("Postman-Token", "d5882a6b-be41-4a6b-a65a-4785bbbcb575"),
    Map.entry("authorization", "Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1pbiIsImlhdCI6MTY4MTkwMDg1MSwiZXhwIjoxNjgxOTA0NDUxfQ.a0MxEtgD6_VVWqmRvdCjEWE18PuK1Az_zYzQPArkXa8")
  );
  
  private Map<CharSequence, String> headers_6 = Map.ofEntries(
    Map.entry("Content-Type", "application/json"),
    Map.entry("Postman-Token", "9fc86ba7-d01e-484b-b67b-ffb2f4d4e8f0"),
    Map.entry("authorization", "Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1pbiIsImlhdCI6MTY4MTkwMDg1MSwiZXhwIjoxNjgxOTA0NDUxfQ.a0MxEtgD6_VVWqmRvdCjEWE18PuK1Az_zYzQPArkXa8")
  );
  
  private Map<CharSequence, String> headers_7 = Map.of("Postman-Token", "b7d24499-6c4d-43b0-8f3a-84ebb189f717");
  
  private Map<CharSequence, String> headers_8 = Map.of("Postman-Token", "34447af2-dd28-47bf-bf36-656e81a868b8");
  
  private Map<CharSequence, String> headers_9 = Map.ofEntries(
    Map.entry("Postman-Token", "64aa2b3e-5a03-4f34-9707-f7ed5d4dd886"),
    Map.entry("authorization", "Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1pbiIsImlhdCI6MTY4MTkwMDg1MSwiZXhwIjoxNjgxOTA0NDUxfQ.a0MxEtgD6_VVWqmRvdCjEWE18PuK1Az_zYzQPArkXa8")
  );


  private ScenarioBuilder scn = scenario("RecordedSimulationProxy")
    .exec(
      http("request_0")
        .get("/api/videogame")
        .headers(headers_0)
    )
    .pause(929)
    .exec(
      http("request_1")
        .get("/api/videogame/2")
        .headers(headers_1)
    )
    .pause(31)
    .exec(
      http("request_2")
        .post("/api/videogame")
        .headers(headers_2)
        .body(RawFileBody("videogameDB/recordedsimulationproxy/0002_request.json"))
        .check(status().is(403))
    )
    .pause(16)
    .exec(
      http("request_3")
        .post("/api/authenticate")
        .headers(headers_3)
        .body(RawFileBody("videogameDB/recordedsimulationproxy/0003_request.json"))
    )
    .pause(137)
    .exec(
      http("request_4")
        .post("/api/videogame")
        .headers(headers_4)
        .body(RawFileBody("videogameDB/recordedsimulationproxy/0004_request.json"))
        .check(status().is(500))
    )
    .pause(164)
    .exec(
      http("request_5")
        .put("/api/videogame/3")
        .headers(headers_5)
        .body(RawFileBody("videogameDB/recordedsimulationproxy/0005_request.json"))
    )
    .pause(29)
    .exec(
      http("request_6")
        .post("/api/videogame")
        .headers(headers_6)
        .body(RawFileBody("videogameDB/recordedsimulationproxy/0006_request.json"))
    )
    .pause(7)
    .exec(
      http("request_7")
        .get("/api/videogame")
        .headers(headers_7)
    )
    .pause(23)
    .exec(
      http("request_8")
        .get("/api/videogame/0")
        .headers(headers_8)
        .check(status().is(404))
    )
    .pause(23)
    .exec(
      http("request_9")
        .delete("/api/videogame/2")
        .headers(headers_9)
    );

  {
	  setUp(scn.injectOpen(atOnceUsers(1))).protocols(httpProtocol);
  }
}
