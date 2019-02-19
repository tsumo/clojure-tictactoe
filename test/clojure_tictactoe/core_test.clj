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
        "Getting col number for every cell of the 4x4 board"))

  (testing "Testing board generation"
    (is (= (gen-board 2)
           '{0 [(0 1) (0 2)]
             1 [(0 1) (1 3)]
             2 [(2 3) (0 2)]
             3 [(2 3) (1 3)]})
        "Generating 2x2 board")

    (is (= (gen-board 3)
           '{0 [(0 1 2) (0 3 6)]
             1 [(0 1 2) (1 4 7)]
             2 [(0 1 2) (2 5 8)]
             3 [(3 4 5) (0 3 6)]
             4 [(3 4 5) (1 4 7)]
             5 [(3 4 5) (2 5 8)]
             6 [(6 7 8) (0 3 6)]
             7 [(6 7 8) (1 4 7)]
             8 [(6 7 8) (2 5 8)]})
        "Generating 3x3 board")))

