(ns re-frame-inputs.handlers
  (:require [re-frame.core :refer [register-handler path dispatch]]
            [re-frame-inputs.db :as db]
            ))

(register-handler :initialize-db 
                  (fn [db _]
                    (merge db db/default-value)))

(register-handler :update-input-text 
                  (fn [db [_ value]] 
                    (-> db
                        (assoc :input-text value))))


(register-handler :update-example-1
                  (fn [db [_ value]] 
                    (-> db
                        (assoc :example1 value))))


(register-handler :update-example-2
                  (fn [db [_ value]] 
                    (-> db
                        (assoc :example2 value))))


(register-handler :update-example-3
                  (fn [db [_ value]] 
                    (-> db
                        (assoc :example3 value))))


(register-handler :update-cursor-position-ex3
                  (fn [db [_ pos]]
                    (-> db 
                        (assoc :cursor-position-ex3 pos))))



(register-handler :update-example-4
                  (fn [db [_ value]] 
                    (-> db
                        (assoc :example4 value))))


(register-handler :update-cursor-position-ex4
                  (fn [db [_ pos]]
                    (-> db 
                        (assoc :cursor-position-ex4 pos))))
