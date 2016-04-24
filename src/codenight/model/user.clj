 (ns codenight.model.user
  (:require [clojure.java.jdbc :as sql]
  			[codenight.datastore :as datastore]))

(defn all []
    (into [] (sql/query datastore ["select * from users order by id desc"])))

(defn create [name description email password]
    (sql/insert! datastore :users
       {:name name :description description :email_address email :password password}))
