(ns re-frame-inputs.views
  (:require [re-frame.core :refer [subscribe dispatch]]
            [reagent.core :as reagent]
))

(defn intro []
   
    [:p "Intro"])

(defn app-db-display []
  (let [db (subscribe [:app-db])]
     [:div {:class "pure-u-1-3"}
      
      [:div 
       [:h2 "Current value of app-db"]
      [:p (str @db)]]]))


(defn example1 []
  (let [text (subscribe [:example1])]
    [:div {:class "pure-u-1-1"}
     [:h3 "Set default-value, update on-blur with ^key."]
     [:div {:class "pure-form pure-form-aligned"}
      [:div {:class "pure-control-group"}
       ^{:key (str "example1" @text)}[:input {:type "text"
                :id "example1"
                :default-value @text
                :on-blur #(dispatch [:update-example-1 (-> % .-target .-value)])}]
       [:p "Appears to work properly."]
     ]]]))


(defn example2 []
  (let [text (subscribe [:example2])]
    [:div {:class "pure-u-1-1"}
     [:h3 "Set value, update on-change"]
     [:div {:class "pure-form pure-form-aligned"}
      [:div {:class "pure-control-group"}
       [:input {:type "text"
                :id "example2"
                :value @text
                :on-change #(dispatch [:update-example-2 (-> % .-target .-value)])}]
       [:p "Almost works. Issues with this method - if text is entered anywhere but at the end of the input, it resets the cursor position to the end."]
     ]]]))

(defn controlled-input-component-ex3 []
  (let [text (subscribe [:example3])
        pos (subscribe [:cursor-position-ex3])]
    (reagent/create-class 
     {:component-will-update
      #(println "component-will-update " @pos)
      :component-did-update
      #(.setSelectionRange 
        (js/document.getElementById "ex3")
        @pos 
        @pos)
      :display-name "controlled-input-component"
      :reagent/render 
      (fn [id]
        [:input {:type "text"
                 :id "ex3"
                 :value @text
                 :on-change
                 #(do
                    (dispatch [:update-example-3 
                               (-> % .-target .-value)])
                    (dispatch [:update-cursor-position-ex3 
                               (-> % .-target .-selectionStart)])
                    )}])})))
      

(defn example3 []
   [:div {:class "pure-u-1-1"}
     [:h3 "Controlled form-3 input, char by char"]
     [:div {:class "pure-form pure-form-aligned"}
      [:div {:class "pure-control-group"}
       [controlled-input-component-ex3]
         [:p "Almost works. Only problem is input lag, but it can be pretty significant."]]]])


;; (defn example2 []
;;   (let [text (subscribe [:input-text])]
;;     [:div {:class "pure-u-1-1"}
;;      [:h3 "Doesn't work. Set default-value, update on-blur"]
;;      [:div {:class "pure-form pure-form-aligned"}
;;       [:div {:class "pure-control-group"}
;;        [:input {:type "text"
;;                 :id "example2"
;;                 :default-value @text
;;                 :on-blur #(dispatch [:update-input-text (-> % .-target .-value)])}]
;;        [:p "Issues with this method - doesn't update properly on initial load or when changes are made elsewhere. Will update when figwheel files are saved, but not consistently"]
;;      ]]]))



;; (defn example4 []
;;   (let [text (subscribe [:input-text])]
;;     [:div {:class "pure-u-1-1"}
;;      [:h3 "Doesn't work. Set default-value, update on-change with ^key"]
;;      [:div {:class "pure-form pure-form-aligned"}
;;       [:div {:class "pure-control-group"}
;;        ^{:key (str "example4" @text)}
;;        [:input {:type "text"
;;                 :id "example4"
;;                 :default-value @text
;;                 :on-change #(dispatch [:update-input-text (-> % .-target .-value)])}]
;;        [:p "Loses focus when typing - input field is replaced on each change of text."]
;;      ]]]))

(defn example4[]
  (let [text (subscribe [:example4])
        pos (subscribe [:cursor-position-ex4])
        ]
    (reagent/create-class 
     {:component-will-mount 
      #(println "component-will-mount " @pos)
      :component-did-mount 
      #(println "component-did-mount " @pos)
      :component-will-receive-props
      #(println "component-will-receive-props")
      :should-component-update
      #(println "should-component-update")
      :component-will-update
      #(println "component-will-update " @pos)
      :component-did-update
      ; #(println "component-did-update " @pos)
      #(.setSelectionRange 
        (js/document.getElementById "example4")
        @pos 
        @pos)
      :component-will-unmount
      #(println "component-will-unmount")
      :display-name "my-component"
      :reagent/render 
      (fn [id]
        [:div {:class "pure-u-1-1"}
         [:h3 "Form-3 component. Uglier code than above but feels faster for some reason."]
         [:div {:class "pure-form pure-form-aligned"}
          [:div {:class "pure-control-group"}
           ;^{:key (str "example4" @text)}
             [:input {:type "text"
                      :id "example4"
                    :value @text
                    :on-change
                      #(do
                         (dispatch [:update-example-4
                                    (-> % .-target .-value)])
                         (dispatch [:update-cursor-position-ex4
                                    (-> % .-target .-selectionStart)])
                         )
                   }]]]])})))




(defn main-app []
  
  [:div {:class "pure-g"}
   [:div {:class "pure-u-2-3"}
    [:h2 "Controlled Input Methods Using Re-Frame"]
    [example1]
    [:hr]
    [example2]
    [:hr]
    [example3]
    [:hr]
    [example4]
    ]
   [app-db-display]
  ]
   )
