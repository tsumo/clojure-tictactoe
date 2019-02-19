(ns clojure-tictactoe.core
  (:gen-class))

;;; {0 [[0 1 2] [0 3 6] [0 4 8]
;;;  1 [[0 1 2] [1 4 7]]
;;;  2 [[0 1 2] [2 5 8] [2 4 6]
;;;  3 [[3 4 5] [0 3 6]]
;;;  4 [[3 4 5] [1 4 7] [0 4 8] [2 4 6]
;;;  5 [[3 4 5] [2 5 8]]
;;;  6 [[6 7 8] [0 3 6] [2 4 6]
;;;  7 [[6 7 8] [1 4 7]]
;;;  8 [[6 7 8] [2 5 8] [0 4 8]}

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
            ;; incorrect
            (into board {pos [(get-row pos size) (get-col pos size)]}))
          {}
          (range 1 (inc (* size 2)))))


(defn -main
  [& args]
  (println "Hello from main"))

