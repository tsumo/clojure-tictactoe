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

(defn gen-board
  "Creates a game board with equal number of rows and cols."
  [size]
  (vec (repeat (* size size) nil)))


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


(defn indexes-to-cells
  "Returns actual values of cells by their indexes"
  [idx cells]
  (map #(nth cells %)
       idx))


(defn get-board-paths
  "All rows, columns and diagonals of the board"
  [board]
  (let [size (count board)
        width (int (Math/sqrt size))]
    ; TODO
    [(indexes-to-cells )])
  )


(defn no-more-moves?
  "Is every cell on the board occupied?"
  [board]
  (every? identity board))


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
              (partition (int (Math/sqrt (count board)))
                         board))))


(defn next-player
  "Returns the next player char"
  [player]
  (if (= player \X) \O \X))


; (defn replace-nth
;   "Replaces nth element of the lazy seq"
;   [coll n new-value]
;   (concat (take n coll)
;           (list new-value)
;           (nthnext coll (inc n))))


(defn make-move
  "Marks player move on the nth cell"
  [n player board]
  (assoc board n player))


(defn same-player?
  "Is this path completely filled by one player?"
  [path]
  (if (some nil? path)
    false
    (let [player (first path)]
      (if (every? #(= player %) path)
        player
        false))))


; (defn win?
;   "Does this board have a winning path?"
;   [board]
;   (some win-cell? (:paths board)))


(defn -main
  [size]
  (println "Welcome to tic-tac-toe!")
  (loop [n nil
         player \X
         board (gen-board size)]
    (let [new-board (if n
                      (make-move n player board)
                      board)]
      (print (get-board-string new-board))
      (when-not (no-more-moves? new-board)
        (print (str "Player " (next-player player) ". Select a cell: "))
        (flush)
        (recur (read-string (read-line))
               (next-player player)
               new-board)))))

