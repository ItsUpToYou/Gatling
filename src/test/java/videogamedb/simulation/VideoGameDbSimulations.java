package videogamedb.simulation;

import io.gatling.javaapi.core.*;
import io.gatling.javaapi.http.*;
import net.sf.saxon.om.Chain;

import static io.gatling.javaapi.core.CoreDsl.*;
import static io.gatling.javaapi.http.HttpDsl.*;

public class VideoGameDbSimulations extends Simulation {
    private HttpProtocolBuilder httpProtocolBuilder = http
            .baseUrl("https://videogamedb.uk/api")
            .acceptHeader("application/json");

    private static final int USER_COUNT = Integer.parseInt(System.getProperty("USERS", "5"));
    private static final int RAMP_DURATION = Integer.parseInt(System.getProperty("RAMP_DURATION", "10"));
    private static final int TEST_DURATION = Integer.parseInt(System.getProperty("TEST_DURATION", "20"));
    @Override
    public void before(){
        System.out.printf("Running test with %d users%n", USER_COUNT);
        System.out.printf("Ramping users over %d seconds%n", RAMP_DURATION);
        System.out.printf("Total test duration %d seconds%n", TEST_DURATION);
    }

    private static ChainBuilder getAllVideoGames =
            exec(http("Get All Video Games")
                    .get("/videogame"));

    private static ChainBuilder getSpecificGame =
            exec(http("Get Specific Game")
                    .get("/videogame/2"));

    private ScenarioBuilder scn = scenario("Video Game DB - Section 7 Code")
            .forever().on(
                    exec(getAllVideoGames)
                            .pause(5)
                            .exec(getSpecificGame)
                            .pause(5)
                            .exec(getAllVideoGames)
            );


/*    {
        setUp(
                scn.injectOpen(
                        nothingFor(5),
                        atOnceUsers(10),
                        rampUsers(20).during(30)
//                        constantUsersPerSec(5).during(10),
//                        constantUsersPerSec(5).during(10).randomized()
//                        rampUsersPerSec(1).to(5).during(25)
//                        rampUsersPerSec(1).to(5).during(25).randomized()

                ).protocols(httpProtocolBuilder)
        ).maxDuration(60);

    }*/


    {
        setUp(
                scn.injectOpen(
                        nothingFor(5),
                        rampUsers(USER_COUNT).during(RAMP_DURATION)


                ).protocols(httpProtocolBuilder)
        ).maxDuration(TEST_DURATION);

    }


}
