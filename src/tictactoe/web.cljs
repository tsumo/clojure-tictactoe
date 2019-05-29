(ns tictactoe.web
  (:require [tictactoe.model :as m]
            [reagent.core :as reagent]
            [re-frame.db :as db]
            [re-frame.core :as rf]
            [clojure.string :as str]))


(enable-console-print!)


;; -- Domino 1 - Event Dispatch


;; -- Domino 2 - Event Handlers


(rf/reg-event-db
  :initialize
  (fn [_ _]
    {:player \X
     :board (m/make-move
              8 \O (m/make-move
                     7 \X (m/make-move
                            6 \O (m/make-move
                                   5 \X (m/make-move
                                          3 \X (m/make-move
                                                 2 \O (m/make-move
                                                        1 \X (m/make-move
                                                               0 \O (m/gen-board 3)))))))))
     :board-size 3}))


(rf/reg-event-db
  :make-move
  (fn [db [_ index]]
    (assoc db
           :board (m/make-move index (:player db) (:board db))
           :player (m/next-player (:player db)))))


;; -- Domino 4 - Query


(rf/reg-sub
  :player
  (fn [db _]
    (:player db)))


(rf/reg-sub
  :board
  (fn [db _]
    (:board db)))


;; -- Domino 5 - View Functions


(defn player
  []
  [:h3 (str "Current player: " @(rf/subscribe [:player]))])


(defn board-row
  [row index]
  (into [:div.board-row]
        (map (fn [[index cell]]
               [:button.board-cell
                {:on-click #(rf/dispatch [:make-move index])}
                cell])
             row)))


(defn board
  []
  (fn []
    (let [board @(rf/subscribe [:board])
          indexed-board (map-indexed vector board)]
      [:div.board-wrapper
       (into [:div.board]
             (map board-row
                  (partition 3 indexed-board)))])))


(defn ui
  []
  [:div.app-wrapper
   [:h1.app-title "Tic-Tac-Toe"]
   [player]
   [board]])


;; -- Entry Point


(defn ^:export run
  []
  (rf/dispatch-sync [:initialize])
  (reagent/render [ui] (js/document.getElementById "app")))

