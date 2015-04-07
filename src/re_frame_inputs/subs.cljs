(ns re-frame-inputs.subs
  (:require [re-frame.core :refer [register-sub path]])
  (:require-macros [reagent.ratom :refer [reaction]]))


(register-sub :app-db 
              (fn [db _]
                (reaction @db)))


(register-sub :example1
              (fn [db _]
                (reaction (:example1 @db))))

(register-sub :example2
              (fn [db _]
                (reaction (:example2 @db))))


(register-sub :example3
              (fn [db _]
                (reaction (:example3 @db))))


(register-sub :cursor-position-ex3
              (fn [db _]
                (reaction (:cursor-position-ex3 @db))))


(register-sub :example4
              (fn [db _]
                (reaction (:example4 @db))))


(register-sub :cursor-position-ex4
              (fn [db _]
                (reaction (:cursor-position-ex4 @db))))

