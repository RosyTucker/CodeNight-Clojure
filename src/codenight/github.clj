(ns codenight.github
  (:refer-clojure :exclude [get])
  (:require [clj-http.client :as http])
  (:use [clj-oauth2.client :only [make-auth-request get-access-token]]))

(def github-oauth2-params
     {:client-id (System/getenv "GITHUB_CLIENT_ID")
      :client-secret (System/getenv "GITHUB_CLIENT_SECRET")
      :authorization-uri  "https://github.com/login/oauth/authorize"
      :redirect-uri (str (System/getenv "APP_HOST") "/oauthcallback")
      :access-token-uri "https://github.com/login/oauth/access_token"
      :grant-type "authorization_code"
      :scope ["user"]}) 

; Endpoints
(def github-api "https://api.github.com")
(def github-user-endpoint (str github-api "user"))

;Helpers
(defn login [request] ((make-auth-request github-oauth2-params) :uri))

(defn- access-token-params [auth-req] (get-access-token github-oauth2-params (:params auth-req) login))

(defn- auth-header [request] (str "token " (:access-token (access-token-params request))))

;Methods
(defn get-user [request]
     (let [authorization-header (auth-header request)]
        (http/get "https://api.github.com/user" {:headers {:Authorization authorization-header}})))

(defn get-emails [request]
     (let [authorization-header (auth-header request)]
        (http/get "https://api.github.com/user/emails" {:headers {:Authorization authorization-header}})))


