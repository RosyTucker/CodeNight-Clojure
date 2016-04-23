(ns codenight.core
  (:use [ring.adapter.jetty]
        [codenight.handler :only [app]]
        [codenight.migration.01_schema :as schema]))

(def ^:const default-port 3000)

(defn -main [& [port]]
   (schema/migrate)
    (let [port (Integer. (or port default-port))]
      (run-jetty app {:port port})))
