package videogamedb.scriptfundamentals;

import io.gatling.javaapi.core.*;
import io.gatling.javaapi.http.*;

import static io.gatling.javaapi.core.CoreDsl.scenario;
import static io.gatling.javaapi.core.OpenInjectionStep.atOnceUsers;
import static io.gatling.javaapi.http.HttpDsl.*;

public class MyFirstTest extends Simulation {

    //    1.Http configuration
    private HttpProtocolBuilder httpProtocolBuilder = http
            .baseUrl("https://videogamedb.uk/api")
            .acceptHeader("application/json");

    //    2.Scenario defenition
    private ScenarioBuilder scn = scenario("my First Test")
            .exec(http("Get all games")
                    .get("/videogame"));


    //    3.Load simulation
    {
        setUp(
                scn.injectOpen(atOnceUsers(1))
        ).protocols(httpProtocolBuilder);
    }
}
