(ns codenight.auth
  (:use [clj-oauth2.client :as oauth2]))

(def github-api "https://api.github.com/")

(def github-oauth2-params
     {:client-id (System/getenv "GITHUB_CLIENT_ID")
      :client-secret (System/getenv "GITHUB_CLIENT_SECRET")
      :authorization-uri  "https://github.com/login/oauth/authorize"
      :redirect-uri (str (System/getenv "APP_HOST") "/oauthcallback")
      :access-token-uri "https://github.com/login/oauth/access_token"
      :grant-type "authorization_code"
      :scope ["user"]}) 

(defn access-token [request]
     ((oauth2/make-auth-request github-oauth2-params) :uri))