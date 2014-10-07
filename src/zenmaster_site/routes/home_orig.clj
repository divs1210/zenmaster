(ns zenmaster-site.routes.home
  (:require [compojure.core :refer :all]
            [zenmaster-site.layout :as layout]
            [zenmaster-site.util :as util]))

(defn home-page []
  (layout/render
    "home.html" {:content (util/md->html "/md/docs.md")}))

(defroutes home-routes
  (GET "/" [] (home-page))
  (GET "/about" [] (about-page)))