(ns now.core
  (:require [reagent.core :as reagent]
            [re-frame.core :as re-frame]
            [now.handlers]
            [now.subs]
            [now.routes :as routes]
            [now.views :as views]))

(defn mount-root []
  (reagent/render [views/main-panel]
                  (.getElementById js/document "app")))

(defn ^:export init []
  (routes/app-routes)
  (re-frame/dispatch-sync [:initialize-db])
  (mount-root))
