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


(register-handler :update-example-2
                  (fn [db [_ value]] 
                    (-> db
                        (assoc :example2 value))))

(register-handler :update-cursor-position
                  (fn [db [_ pos]]
                    (-> db 
                        (assoc :cursor-position pos))))
