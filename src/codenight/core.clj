(ns codenight.core
  (:use [ring.adapter.jetty]
        [codenight.handler :only[app]]))

(run-jetty app {:port 3000})
