// bugfixed example from frontpage of gatling.io
import io.gatling.core.Predef._
import io.gatling.http.Predef._
import scala.concurrent.duration._

class MySimulation extends Simulation {

  val conf = http.baseURL("http://localhost")

  val scn = scenario("Gatling")
      .exec(http("index").get("/"))
      .during(5 seconds) {
    exec(
      http("json").get("/json")
        .check(jsonPath("$.id")
        .saveAs("id"))
    )
  }

  setUp(scn.inject(atOnceUsers(5)))
        .protocols(conf)
}
