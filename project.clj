(defproject codenight "0.1.0-SNAPSHOT"
  :description "Source for CodeNight"
  :url "http://github.com/RosyTucker/CodeNight"
  :min-lein-version "2.0.0"
  :dependencies [[org.clojure/clojure "1.7.0"]
                 [compojure "1.4.0"]
                 [org.clojure/java.jdbc "0.4.1"]
                 [org.postgresql/postgresql "9.4-1201-jdbc41"]
                 [stuarth/clj-oauth2 "0.3.2"]
                 [clj-http "3.0.1"]
                 [ring/ring-defaults "0.1.5"]
                 [ring/ring-jetty-adapter "1.4.0"]]
  :plugins [[lein-ring "0.9.7"]]
  :ring {:handler codenight.handler/app}
  :main codenight.core
  :profiles
  {:dev {:dependencies [[javax.servlet/servlet-api "2.5"]
                        [ring/ring-mock "0.3.0"]]}
                        :uberjar {:aot :all}})
