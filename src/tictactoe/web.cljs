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
     :board (m/gen-board 3)
     :board-size 3}))


(rf/reg-event-db
  :make-move
  (fn [{:keys [player board] :as db} [_ index]]
    (if (and (not (m/win? board))
             (not (m/occupied? index board)))
      (assoc db
             :board (m/make-move index player board)
             :player (m/next-player player))
      db)))


;; -- Domino 4 - Query


(rf/reg-sub
  :player
  (fn [db _]
    (:player db)))


(rf/reg-sub
  :board
  (fn [db _]
    (:board db)))


(rf/reg-sub
  :board-size
  (fn [db _]
    (:board-size db)))


;; -- Domino 5 - View Functions


(defn status
  []
  (let [board @(rf/subscribe [:board])
        player @(rf/subscribe [:player])
        winner (m/win? board)
        no-moves (m/no-more-moves? board)]
    (cond winner [:h3 (str "Winner is " winner "!")]
          no-moves [:h3 "It's a draw!"]
          :else [:h3 (str "Current player: " player)])))


(defn board-row
  [row index]
  (into [:div.board-row]
        (map (fn [[index cell]]
               [:button.btn.cell-txt
                {:on-click #(rf/dispatch [:make-move index])}
                cell])
             row)))


(defn board
  []
  (fn []
    (let [board @(rf/subscribe [:board])
          indexed-board (map-indexed vector board)
          board-size @(rf/subscribe [:board-size])]
      [:div.board-wrapper
       (into [:div.board]
             (map board-row
                  (partition board-size indexed-board)))])))


(defn reset
  []
  [:button.btn.reset-txt {:on-click #(rf/dispatch [:initialize])} "Reset"])


(defn ui
  []
  [:div.app-wrapper
   [:h1.app-title "Tic-Tac-Toe"]
   [status]
   [board]
   [reset]])


;; -- Entry Point


(defn ^:export run
  []
  (rf/dispatch-sync [:initialize])
  (reagent/render [ui] (js/document.getElementById "app")))

