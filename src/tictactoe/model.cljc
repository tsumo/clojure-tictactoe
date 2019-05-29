(ns tictactoe.model)

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


(defn get-row
  "Indexes of the nth row of the board."
  [row size]
  (let [start (* row size)]
    (range start (+ start size))))


(defn get-col
  "Indexes of the nth column of the board."
  [col size]
  (let [end (+ col (* size size))]
    (range col end size)))


(defn get-row-num
  "Returns row on which cell is located."
  [cell size]
  (quot cell size))


(defn get-col-num
  "Return col on which cell is located."
  [cell size]
  (let [row-num (get-row-num cell size)]
    (- cell (* size row-num))))


(defn get-lr-diag
  "Indexes of the diagonal from top left to bottom right."
  [size]
  (range 0 (* size size) (inc size)))


(defn get-rl-diag
  "Indexes of the diagonal from top right to bottom left"
  [size]
  (range (dec size) (dec (* size size)) (dec size)))


(defn get-board-size
  "Get board size (width) from board"
  [board]
  (int (Math/sqrt (count board))))


(defn indexes-to-cells
  "Returns actual values of cells by their indexes"
  [idx board]
  (map #(nth board %)
       idx))


(defn get-board-paths
  "All rows, columns and diagonals of the board"
  [board]
  (let [size (get-board-size board)]
    (map #(indexes-to-cells % board)
         (concat
           (map #(get-row % size) (range size))
           (map #(get-col % size) (range size))
           (list (get-lr-diag size))
           (list (get-rl-diag size))))))


(defn no-more-moves?
  "Is every cell on the board occupied?"
  [board]
  (every? identity board))


(defn next-player
  "Returns the next player char"
  [player]
  (if (= player \X) \O \X))


(defn occupied?
  "Is this cell already belongs to some player?"
  [n board]
  (nth board n))


(defn make-move
  "Marks player move on the nth cell"
  [n player board]
  (assoc board n player))


(defn same-player?
  "Is this path completely filled by one player?
  Returns nil or player"
  [path]
  (if (some nil? path)
    false
    (let [player (first path)]
      (if (every? #(= player %) path)
        player
        false))))


(defn win?
  "Does this board have a winning path?
  Returns nil or player"
  [board]
  (some same-player? (get-board-paths board)))

