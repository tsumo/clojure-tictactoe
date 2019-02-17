(ns clojure-tictactoe.core
  (:gen-class))

;;; {1 [[1 2 3] [1 4 7]]
;;;  2 [[1 2 3] [2 5 8]]
;;;  3 [[1 2 3] [3 6 9]]
;;;  4 [[4 5 6] [1 4 7]]
;;;  5 [[4 5 6] [2 5 8]]
;;;  6 [[4 5 6] [3 6 9]]
;;;  7 [[7 8 9] [1 4 7]]
;;;  8 [[7 8 9] [2 5 8]]
;;;  9 [[7 8 9] [3 6 9]]}

;;; 1 2 3
;;; 4 5 6
;;; 7 8 9

;;;  1  2  3  4
;;;  5  6  7  8
;;;  9 10 11 12
;;; 13 14 15 16

;;;  1  2  3  4  5
;;;  6  7  8  9 10
;;; 11 12 13 14 15
;;; 16 17 18 19 20
;;; 21 22 23 24 25

(defn get-row-num
  "Returns row on which cell is located."
  [cell size]
  ; TODO
  )


(defn get-col-num
  "Return col on which cell is located."
  [col size]
  ; TODO
  )


(defn get-row
  "Nth row of the board."
  [row size]
  (let [start (inc (* (dec row) size))]
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

