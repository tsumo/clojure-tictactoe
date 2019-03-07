(ns clojure-tictactoe.core-test
  (:require [clojure.test :refer :all]
            [clojure-tictactoe.core :refer :all]))

(deftest board-tests
  (testing "Testing board getters"
    (is (= (map get-row (range 3) (repeat 3))
           '((0 1 2) (3 4 5) (6 7 8)))
        "Getting every row of the 3x3 board")

    (is (= (map get-col (range 3) (repeat 3))
           '((0 3 6) (1 4 7) (2 5 8)))
        "Getting every col of the 3x3 board")

    (is (= (map get-row-num (range 9) (repeat 3))
           '(0 0 0 1 1 1 2 2 2))
        "Getting row number for every cell of the 3x3 board")

    (is (= (map get-row-num (range 16) (repeat 4))
           '(0 0 0 0 1 1 1 1 2 2 2 2 3 3 3 3))
        "Getting row number for every cell of the 4x4 board")

    (is (= (map get-col-num (range 9) (repeat 3))
           '(0 1 2 0 1 2 0 1 2))
        "Getting col number for every cell of the 3x3 board")

    (is (= (map get-col-num (range 16) (repeat 4))
           '(0 1 2 3 0 1 2 3 0 1 2 3 0 1 2 3))
        "Getting col number for every cell of the 4x4 board")

    (is (= (get-lr-diag 3)
           '(0 4 8))
        "Getting top left to bottom right diagonal of the 3x3 board")

    (is (= (get-lr-diag 4)
           '(0 5 10 15))
        "Getting top left to bottom right diagonal of the 4x4 board")

    (is (= (get-rl-diag 3)
           '(2 4 6))
        "Getting top right to bottom left diagonal of the 3x3 board")

    (is (= (get-rl-diag 4)
           '(3 6 9 12))
        "Getting top right to bottom left diagonal of the 4x4 board")

    (is (= (indexes-to-cells [0 3 1 2] [\X \O \X \O])
           [\X \O \O \X])
        "Retrieving cell values")

    ; (is (= (get-board-paths [\X \O \X \O])
    ;        '[(0 1) (2 3) (0 2) (1 3) (0 3) (1 2)]))
    )


  (testing "Testing board generation"
    (is (= (gen-board 2)
           [nil nil nil nil])
        "Generating 2x2 board")

    (is (= (gen-board 3)
           [nil nil nil nil nil nil nil nil nil])
        "Generating 3x3 board"))


  (testing "Testing game manipulations"
    (is (= (next-player \X)
           \O))

    (is (= (next-player \O)
           \X))

    (is (= (no-more-moves? (gen-board 3))
           false)
        "New boards always have moves")

    (is (= (no-more-moves? [\X \O \X \O \X \O \X \O \X])
           true)
        "Fully occupied board have no moves")

    (is (= (make-move 3 \O (make-move 5 \X (gen-board 3)))
           [nil nil nil \O nil \X nil nil nil])
        "Two moves on the empty board")

    (is (= (same-player? [nil nil nil])
           false)
        "nil is not a player")

    (is (= (same-player? [nil nil \O])
           false)
        "Path is not fully filled")

    (is (= (same-player? [\O \X \O])
           false)
        "Not the same player")

    (is (= (same-player? [\X \X \X])
           \X)
        "Fuly filled path returns a player"))


  (testing "Testing board printing"
    (is (= (get-row-string [\X nil \O])
           (str
             "+---+ +---+ +---+ \n"
             "| X | |   | | O | \n"
             "+---+ +---+ +---+ \n"))
        "Printing single row")

    (is (= (get-board-string (gen-board 3))
           (str
             "+---+ +---+ +---+ \n"
             "|   | |   | |   | \n"
             "+---+ +---+ +---+ \n"
             "+---+ +---+ +---+ \n"
             "|   | |   | |   | \n"
             "+---+ +---+ +---+ \n"
             "+---+ +---+ +---+ \n"
             "|   | |   | |   | \n"
             "+---+ +---+ +---+ \n"))
        "Printing full board")))

