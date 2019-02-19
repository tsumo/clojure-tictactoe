(ns clojure-tictactoe.core
  (:gen-class))

;;; 0 1 2
;;; 3 4 5
;;; 6 7 8

;;;  0  1  2  3
;;;  4  5  6  7
;;;  8  9 10 11
;;; 12 13 14 15

;;;  0  1  2  3  4
;;;  5  6  7  8  9
;;; 10 11 12 13 14
;;; 15 16 17 18 19
;;; 20 21 22 23 24

(defn get-row-num
  "Returns row on which cell is located."
  [cell size]
  (quot cell size))


(defn get-col-num
  "Return col on which cell is located."
  [cell size]
  (let [row-num (get-row-num cell size)]
    (- cell (* size row-num))))


(defn get-row
  "Nth row of the board."
  [row size]
  (let [start (* row size)]
    (range start (+ start size))))


(defn get-col
  "Nth column of the board."
  [col size]
  (let [end (+ col (* size size))]
    (range col end size)))


(defn gen-board
  "Creates a game board with equal number of rows and cols."
  [size]
  (reduce (fn [board pos]
            (into board {pos [(get-row (get-row-num pos size) size)
                              (get-col (get-col-num pos size) size)]}))
          {}
          (range (* size size))))


(defn -main
  [& args]
  (println "Hello from main"))

