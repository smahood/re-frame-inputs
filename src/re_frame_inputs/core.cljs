(ns ^:figwheel-always re-frame-inputs.core
    (:require [re-frame-inputs.db :as db]
              [re-frame.core :as re-frame]
              [reagent.core :as reagent]
              [re-frame-inputs.views :as views]
              [re-frame-inputs.handlers]
              [re-frame-inputs.subs]
              ))

(enable-console-print!)

(defn ^:export main []
  (re-frame/dispatch [:initialize-db])
  (reagent/render views/main-app
                  (js/document.getElementById "app"))
)

(main)
