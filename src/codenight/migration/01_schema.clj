(ns codenight.migration.01_schema
    (:require [clojure.java.jdbc :as sql]
              [codenight.datastore :as datastore]))

(defn has-migrated? []
  (pos? (:count (first (sql/query datastore/postgres "select count(*) from information_schema.tables where table_name='users'")))))

(defn migrate []
    (when (not (has-migrated?))
          (println "Creating database")
          (sql/db-do-commands datastore/postgres
             (sql/create-table-ddl
               :users
               [:id :serial "PRIMARY KEY"]
               [:name :varchar "NOT NULL"]
               [:email_address :varchar "NOT NULL"]
               [:password :varchar "NOT NULL"]
               [:description :varchar]
               [:created_at :timestamp "NOT NULL" "DEFAULT CURRENT_TIMESTAMP"]))
          (println " done")))
