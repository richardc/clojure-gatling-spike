A thunking of the sbt-gatling and clojure-sbt suites

# Usage

Assuming a relative checkout of pcp-broker in ../pcp-broker

    $ ./ext/make-keystores.sh
    $ sbt
    > test

Write gatling test scenarios and put them in src/test/scala/scenario.scala,
then they will be used as a basis for testing by sbt-gatling.

# TODO:

- [x] sbt scaffolding for sbt-gatling and clojure-sbt
- [x] Make websockets connection from gatling
- [x] With client certs
- [x] Call into clojure to use message codec
- [ ] Verify message bodies we get back


That last seems to be impossible with current gatling.  On running our tests we
see:

    13:20:32.512 [GatlingSystem-akka.actor.default-dispatcher-3] DEBUG io.gatling.http.action.ws.WsActor - Received byte message on websocket 'gatling.http.webSocket':[B@51028494. Beware, byte message checks are currently not supported

And since the next thing to do with that byte message would be to check it in
some way, we might be at an impasse until gatling adds some mechanism there.

## Gotchas

`clojure-sbt` will compile `src/*/clojure/*`, so be careful of editor temporary
files getting written there.

