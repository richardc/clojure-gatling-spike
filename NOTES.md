A thunking of the sbt-gatling and clojure-sbt suites

    $ sbt
    > test

Write gatling test scenarios and put them in src/test/scala/scenario.scala

TODO:

- [x] sbt scaffolding
- [x] Make websockets call
- [x] With client certs
- [x] Call into clojure to use message codec
- [ ] Verify message bodies we get back


That last may be problematic.  On running this we get:

    13:20:32.512 [GatlingSystem-akka.actor.default-dispatcher-3] DEBUG io.gatling.http.action.ws.WsActor - Received byte message on websocket 'gatling.http.webSocket':[B@51028494. Beware, byte message checks are currently not supported

And since the next thing to do with that byte message would be to check it in
some way, we might be at an impasse until gatling adds some mechanism there.

