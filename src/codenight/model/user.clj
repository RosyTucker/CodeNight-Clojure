 (ns codenight.model.user
  (:require [clojure.java.jdbc :as sql]))

(defn all []
    (into [] (sql/query spec ["select * from users order by id desc"])))

(defn create [name description email password]
    (sql/insert! spec :users
       {:name name :description description :email_address email :password password}))
