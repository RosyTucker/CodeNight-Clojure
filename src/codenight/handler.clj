  (ns codenight.handler
    (:require [compojure.core :refer :all]
      [compojure.route :as route]
      [codenight.github :as github]
      [ring.util.response :as response]
      [ring.middleware
      [session :refer [wrap-session]]
      [anti-forgery :refer [wrap-anti-forgery]]]
      [ring.middleware.defaults :refer [wrap-defaults api-defaults]]))

  (defn login-handler [request] (response/redirect (github/login request)))

  (defn oauthcallback-handler [request] 
    (let [access-token (github/access-token request)]
     {:status 200
      :headers {"Content-Type" "text/plain"}
      :session access-token
      :body "Yay"}))

    (defroutes app-routes
      (GET "/" [] "Hello World")
      (GET "/login" [:as request] (login-handler request))
      (GET "/oauthcallback" [:as request] (oauthcallback-handler request))
      (route/not-found "Not Found"))

    (def app (-> app-routes
      (wrap-session {:secure true :http-only true})
      (wrap-defaults api-defaults)))