package io.mosscloud.cdq.performance.simulation;

import static io.gatling.javaapi.core.CoreDsl.*;
import static io.gatling.javaapi.http.HttpDsl.*;

import io.gatling.javaapi.core.*;
import io.gatling.javaapi.http.*;

public class HelloWordSimulation extends Simulation {

    ChainBuilder helloWord = exec(
            http("HelloWord")
                    .get("/helloworld")
                    .check(status().is(200))
    );

    HttpProtocolBuilder httpProtocol =
            http.baseUrl("http://localhost:9999")
                    .userAgentHeader(
                            "Mozilla/5.0 (Macintosh; Intel Mac OS X 10.8; rv:16.0) Gecko/20100101 Firefox/16.0"
                    );

    ScenarioBuilder helloWordSn = scenario("Hello word test").exec(helloWord);

    {
        setUp(
                helloWordSn.injectClosed(
                        constantConcurrentUsers(10).during(10)
                )
        ).protocols(httpProtocol);
    }
}