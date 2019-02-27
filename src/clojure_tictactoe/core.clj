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


(defn get-lr-diag
  "Diagonal from top left to bottom right."
  [size]
  (range 0 (* size size) (inc size)))


(defn get-rl-diag
  "Diagonal from top right to bottom left"
  [size]
  (range (dec size) (dec (* size size)) (dec size)))


(defn gen-board
  "Creates a game board with equal number of rows and cols."
  [size]
  (let [lr-diag (get-lr-diag size)
        rl-diag (get-rl-diag size)]
    {:size size
     :cells (map (fn [cell]
                   (let [row-num (get-row-num cell size)
                         col-num (get-col-num cell size)]
                     {:player \space
                      :paths [(get-row row-num size)
                              (get-col col-num size)
                              (when (= row-num col-num)
                                lr-diag)
                              (when (= (+ row-num col-num) (dec size))
                                rl-diag)]}))
                 (range (* size size)))}))


(defn print-row
  [row]
  (let [size (count row)]
    (dorun (map print (repeat size "+---+ ")))
    (println)
    (dorun (map (fn [ch]
           (print (str "| " ch " | ")))
         row))
    (println)
    (dorun (map print (repeat size "+---+ ")))
    (println)))


(defn print-board
  [board]
  (map print-row
       (partition (:size board)
                  (map (fn [cell]
                         (:player cell))
                       (:cells board)))))


(defn -main
  [& args]
  (println "Hello from main"))

