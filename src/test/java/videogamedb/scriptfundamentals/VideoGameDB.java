package videogamedb.scriptfundamentals;


import io.gatling.javaapi.core.*;
import io.gatling.javaapi.http.*;
import net.sf.saxon.om.Chain;


import java.time.Duration;
import java.util.List;

import static io.gatling.javaapi.core.CoreDsl.*;
import static io.gatling.javaapi.core.OpenInjectionStep.atOnceUsers;
import static io.gatling.javaapi.http.HttpDsl.*;


public class VideoGameDB extends Simulation {
    private HttpProtocolBuilder httpProtocolBuilder = http
            .baseUrl("https://videogamedb.uk/api")
            .acceptHeader("application/json");

    private static ChainBuilder getAllVideoGames =
            repeat(3).on(
                    exec(http("Variables - Get All video games")
                    .get("/videogame")
                    .check(status().not(404), status().not(500))));


    private static ChainBuilder getSpecificVideoGame =
            repeat(5, "myCounter").on(
                    exec(http("Variables - Get specific video game with id: #{myCounter}")
                    .get("/videogame/#{myCounter}")
                    .check(status().is(200))
            ));


    private ScenarioBuilder scn = scenario("Video Game DB - Section 5 code")

/*
            .exec(http("Get All Video games - 1st call")
                    .get("/videogame")
            .check(status().is(200))
                    //.check(jsonPath("$[?(@.id==1)].name").is("Resident Evil 4")))
                    .check(jmesPath("[? id == `1`].name").ofList().is(List.of("Resident Evil 4"))))
            .pause(5)
*/

            .exec(http("Get Specific Game")
                    .get("/videogame/1")
                    .check(status().in(200, 201, 202))
                    .check(jmesPath("name").is("Resident Evil 4")))
            .pause(1, 10)

//            .exec(http("get all video games - 2nd call")
            .exec(http("Get all video games")
                    .get("/videogame")
                    .check(status().not(404), status().not(500))
                    .check(jmesPath("[1].id").saveAs("gameId")))
            .pause(Duration.ofMillis(4000))
/*
            .exec(
                    session -> {
                        System.out.println(session);
                        System.out.println("GameId set to: " + session.getString("gameId"));
                        return session;
                    })
*/
            .exec(http("Get specific game with Id: - #{gameId}")
                    .get("/videogame/#{gameId}")
                    .check(jmesPath("name").is("Gran Turismo 3"))
                    .check(bodyString().saveAs("responseBody")));


    /*            .exec(
                        session -> {
                            System.out.println("Response body: " + session.getString("responseBody"));
                            return session;
                        }
                );*/
    private ScenarioBuilder scnWithVariables = scenario("=====Video Game DB - Section with Variables=====")
            .exec(getAllVideoGames)
            .pause(5)
            .exec(getSpecificVideoGame)
            .pause(5)
            .repeat(2).on(exec(getAllVideoGames)
            );


    {
        setUp(
               // scn.injectOpen(atOnceUsers(1)),
                scnWithVariables.injectOpen(atOnceUsers(1))
        ).protocols(httpProtocolBuilder);


    }

}
