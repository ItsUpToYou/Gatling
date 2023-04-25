package videogamedb.scriptfundamentals;


import io.gatling.javaapi.core.ChainBuilder;
import io.gatling.javaapi.core.CoreDsl;
import io.gatling.javaapi.core.ScenarioBuilder;
import io.gatling.javaapi.core.Simulation;
import io.gatling.javaapi.http.HttpProtocolBuilder;

import java.time.Duration;

import static io.gatling.javaapi.core.CoreDsl.*;
import static io.gatling.javaapi.core.OpenInjectionStep.atOnceUsers;
import static io.gatling.javaapi.http.HttpDsl.http;
import static io.gatling.javaapi.http.HttpDsl.status;


public class VideoGameDB2 extends Simulation {
    private HttpProtocolBuilder httpProtocolBuilder = http
            .baseUrl("https://videogamedb.uk/api")
            .acceptHeader("application/json")
            .contentTypeHeader("application/json");

    private static ChainBuilder authenticate =
            exec(http("Authenticate")
                    .post("/authenticate")
                    .body(StringBody("{\n" +
                            "  \"password\": \"admin\",\n" +
                            "  \"username\": \"admin\"\n" +
                            "}"))
                    .check(jmesPath("token").saveAs("jwtToken")));


    private static ChainBuilder createNewGame =
            exec(http("Create New Game")
                    .post("/videogame")
                    .header("Authorization", "Bearer #{jwtToken}")
                    .body(StringBody(
                            "{\n" +
                                    "  \"category\": \"Platform\",\n" +
                                    "  \"name\": \"Mario\",\n" +
                                    "  \"rating\": \"Mature\",\n" +
                                    "  \"releaseDate\": \"2012-05-04\",\n" +
                                    "  \"reviewScore\": 85\n" +
                                    "}"
                    )));


    private ScenarioBuilder scn = scenario("************* Video Game DB2 - Section 5 code *************")
            .exec(authenticate)
            .exec(createNewGame);


    {
        setUp(
                scn.injectOpen(atOnceUsers(1))
        ).protocols(httpProtocolBuilder);


    }

}
