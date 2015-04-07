(ns re-frame-inputs.subs
  (:require [re-frame.core :refer [register-sub path]])
  (:require-macros [reagent.ratom :refer [reaction]]))


(register-sub :app-db 
              (fn [db _]
                (reaction @db)))

(register-sub :input-text
              (fn [db _]
                (reaction (:input-text @db))))

(register-sub :cursor-position
              (fn [db _]
                (reaction (:cursor-position @db))))


(register-sub :example2
              (fn [db _]
                (reaction (:example2 @db))))
