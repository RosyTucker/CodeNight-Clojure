(ns codenight.handler
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [codenight.auth :as auth]
            [ring.util.response :as response]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]))


(defn login-handler [request]
	 (response/redirect (auth/access-token request)))

(defn oauthcallback-handler [request]
	 (str request))

(defroutes app-routes
  (GET "/" [] "Hello World")
  (GET "/login" [:as request] (login-handler request))
  (GET "/oauthcallback" [:as request] (oauthcallback-handler request))
  (route/not-found "Not Found"))

(def app
  (wrap-defaults app-routes site-defaults))
