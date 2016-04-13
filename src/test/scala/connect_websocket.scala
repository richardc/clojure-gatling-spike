import io.gatling.core.Predef._
import io.gatling.http.Predef._

class ConnectWebsocketSimulation extends Simulation {

  val conf = http.wsBaseURL("wss://localhost:8142")

  val scn = scenario("ConnectWebsocket")
    .exec(ws("Connect WS").open("/pcp"))
    .exec(ws("Association")
      .sendBytes(pcp.associate_request("pcp://client01.example.com/test01"))
      .check(wsAwait.within(30).until(1)))
    .exec(ws("Close WS").close)

  setUp(scn.inject(atOnceUsers(1))).protocols(conf)
}
