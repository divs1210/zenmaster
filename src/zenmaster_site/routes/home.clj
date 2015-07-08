(ns zenmaster-site.routes.home
  (:require [compojure.core :refer :all]
            [zenmaster-site.layout :as layout]
            [zenmaster-site.util :as util]
            [selmer.parser :refer [render-file]])
  (:use     [zenmaster.core :only (rand-poem)]))

(defn home-page []
  (render-file "templates/home.html"
               {:poems (->> (repeatedly 10 rand-poem)
                            (map #(clojure.string/split % #", ")))}))

(defroutes home-routes
  (GET "/" [] (home-page)))

;; (use 'zenmaster-site.repl)
;; (start-server)
