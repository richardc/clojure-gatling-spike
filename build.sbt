seq(clojure.settings :_*)

libraryDependencies += "org.clojure" % "clojure" % "1.6.0"
libraryDependencies += "puppetlabs" % "pcp-client" % "0.3.0"

enablePlugins(GatlingPlugin)
libraryDependencies += "io.gatling.highcharts" % "gatling-charts-highcharts" % "2.1.5" % "test"
libraryDependencies += "io.gatling"            % "gatling-test-framework"    % "2.1.5" % "test"

resolvers += "clojars" at "https://clojars.org/repo"
