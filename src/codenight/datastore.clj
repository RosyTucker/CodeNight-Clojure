(ns codenight.db)

(def postgres (or (System/getenv "DATABASE_URL") "postgresql://localhost:5432/codenight"))