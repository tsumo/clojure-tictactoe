(ns clojure-tictactoe.cli
  (:require [clojure-tictactoe.core :refer :all]))


(defn get-row-string
  "Printable representation of a single row of the board"
  [row]
  (let [size (count row)
        print-row (map #(if (= % nil) \space %) row)]
    (apply str
           (concat
             (repeat size "+---+ ") [\newline]
             (map #(str "| " % " | ") print-row) [\newline]
             (repeat size "+---+ ") [\newline]))))


(defn get-board-string
  "Printable representation of the full board"
  [board]
  (apply str
         (map get-row-string
              (partition (get-board-size board)
                         board))))


(defn cli-loop
  "Console game loop"
  [player board]
  (print (str \newline (get-board-string board)))
  (cond
    (win? board) (println (str "Player " (win? board) " have won!"))
    (no-more-moves? board) (println "It's a draw!")
    true (do
           (print (str "Player " player ". Select a cell: "))
           (flush)
           (let [move (read-string (read-line))
                 new-board (make-move move player board)]
             (if (occupied? move board)
               (do (println "This cell is taken. Try again!")
                   (recur player board))
               (recur (next-player player) new-board))))))


(defn tic-tac-toe-cli
  "Console game entry point"
  ([]
   (cli-loop \X (gen-board 3)))
  ([size]
   (cli-loop \X (gen-board size))))

