(ns codenight.core
  (:use [ring.adapter.jetty]
        [codenight.handler :only[app]]))

(def ^:const default-port 3000)

(defn -main [& [port]]
    (let [port (Integer. (or port default-port))]
      (run-jetty app {:port port})))
