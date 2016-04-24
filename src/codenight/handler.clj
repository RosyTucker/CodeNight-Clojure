(ns codenight.handler
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [codenight.github :as github]
            [ring.util.response :as response]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]))

(defn login-handler [request] (response/redirect (github/login request)))

(defn oauthcallback-handler [request] (str (:body (github/get-user request))))

(defroutes app-routes
  (GET "/" [] "Hello World")
  (GET "/login" [:as request] (login-handler request))
  (GET "/oauthcallback" [:as request] (oauthcallback-handler request))
  (route/not-found "Not Found"))

(def app (wrap-defaults app-routes site-defaults))
