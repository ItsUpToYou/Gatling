package videogamedb.feeders;

import io.gatling.javaapi.core.*;
import io.gatling.javaapi.http.*;
import net.sf.saxon.om.Chain;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Stream;

import static io.gatling.javaapi.core.CoreDsl.*;
import static io.gatling.javaapi.core.OpenInjectionStep.atOnceUsers;
import static io.gatling.javaapi.http.HttpDsl.*;
import static videogamedb.feedersB.VideoGameDbFeeders.randomDate;

public class VideoGameDbFeeders extends Simulation {

    private HttpProtocolBuilder httpProtocolBuilder = http
            .baseUrl("https://videogamedb.uk/api")
            .acceptHeader("application/json")
            .contentTypeHeader("application/json");

   /* private static FeederBuilder.FileBased<String> csvFeeder = csv("data/gameCsvFile.csv").circular();

    private static ChainBuilder getSpecificGame =
            feed(csvFeeder)
                    .exec(http("GET VIDEO GAME with name - #{gameName}")
                            .get("/videogame/#{gameId}")
                            .check(jmesPath("name").isEL("#{gameName}")));
*/

    /*private static FeederBuilder.FileBased<Object> jsonFeeder = jsonFile("data/gameJsonFile.json").random();*/

/*    private static Iterator<Map<String, Object>> customFeeder=
            Stream.generate((Supplier<Map<String,Object>>) ()->{
        Random rnd = new Random();
        int gameId = rnd.nextInt(10-1+1) +1;
        return Collections.singletonMap("gameId", gameId);
            }
            ).iterator();*/

    private static Iterator<Map<String, Object>> customFeeder2 =
            Stream.generate((Supplier<Map<String,Object>>) ()->{
                        Random rnd = new Random();
                        int gameId = rnd.nextInt(10-1+1) +1;

                String gameName = RandomStringUtils.randomAlphanumeric(5) + "-gameName";
                String releaseDate = randomDate().toString();
                int reviewScore = rnd.nextInt(100);
                String category = RandomStringUtils.randomAlphanumeric(5) + "category";
                String rating = RandomStringUtils.randomAlphanumeric(4) + "-rating";

                HashMap<String, Object> hmap = new HashMap<>();
                hmap.put("gameId", gameId);
                hmap.put("gameName", gameName);
                hmap.put("releaseDate", releaseDate);
                hmap.put("reviewScore", reviewScore);
                hmap.put("category", category);
                hmap.put("rating", rating);

                return hmap;

                    }
            ).iterator();
/*
    private static ChainBuilder getSpecificGame =
            feed(customFeeder2)
                    .exec(http("GET VIDEO GAME FROM JSON - #{gameId}")
                            .get("/videogame/#{gameId}"));
//                            .check(jmesPath("name").isEL("#{name}")));
*/

    private static ChainBuilder authenticate =
            exec(http("Authenticate")
                    .post("/authenticate")
                    .body(StringBody("{\n" +
                            "  \"password\": \"admin\",\n" +
                            "  \"username\": \"admin\"\n" +
                            "}"))
                    .check(jmesPath("token").saveAs("jwtToken")));
    private static ChainBuilder createNewGame =
            feed(customFeeder2)
                    .exec(http("Create New Game - #{gameName}")
                            .post("/videogame")
                            .header("authorization", "Bearer #{jwtToken}")
                            .body(ElFileBody("bodies/newGameTemplate.json")).asJson()
                            .check(bodyString().saveAs("responseBody")))
                    .exec(session -> {
                        System.out.println(session.getString("responseBody"));
                        return session;
                    });


    private ScenarioBuilder scn = scenario("***************** VIDEO GAME DB - SECTION 6 code - Feeder ***************")
            .exec(authenticate)
            .repeat(10).on(
                    exec(createNewGame)
                            .pause(1)
            );



    {
        setUp(
                scn.injectOpen(atOnceUsers(1))
        ).protocols(httpProtocolBuilder);
    }

}
