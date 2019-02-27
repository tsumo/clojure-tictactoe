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
        "Getting top right to bottom left diagonal of the 4x4 board"))

  (testing "Testing board generation"
    (is (= (gen-board 2)
           '{:size 2
             :cells [{:player \space
                      :paths [(0 1) (0 2) (0 3) nil]}
                     {:player \space
                      :paths [(0 1) (1 3) nil (1 2)]}
                     {:player \space
                      :paths [(2 3) (0 2) nil (1 2)]}
                     {:player \space
                      :paths [(2 3) (1 3) (0 3) nil]}]})
        "Generating 2x2 board")

    (is (= (gen-board 3)
           '{:size 3
             :cells [{:player \space
                      :paths [(0 1 2) (0 3 6) (0 4 8) nil]}
                     {:player \space
                      :paths [(0 1 2) (1 4 7) nil nil]}
                     {:player \space
                      :paths [(0 1 2) (2 5 8) nil (2 4 6)]}
                     {:player \space
                      :paths [(3 4 5) (0 3 6) nil nil]}
                     {:player \space
                      :paths [(3 4 5) (1 4 7) (0 4 8) (2 4 6)]}
                     {:player \space
                      :paths [(3 4 5) (2 5 8) nil nil]}
                     {:player \space
                      :paths [(6 7 8) (0 3 6) nil (2 4 6)]}
                     {:player \space
                      :paths [(6 7 8) (1 4 7) nil nil]}
                     {:player \space
                      :paths [(6 7 8) (2 5 8) (0 4 8) nil]}]})
        "Generating 3x3 board"))

  (testing "Testing board printing"
    (is (= (with-out-str (print-row [\X \space \O]))
           "+---+ +---+ +---+ \n| X | |   | | O | \n+---+ +---+ +---+ \n")
        "Printing single row")

    (is (= (with-out-str (print-board [\X \O \space \X \O \X \space \O \X]))
           (with-out-str
             (str
               "+---+ +---+ +---+ \n| X | | O | |   | \n+---+ +---+ +---+ \n"
               "+---+ +---+ +---+ \n| X | | O | | X | \n+---+ +---+ +---+ \n"
               "+---+ +---+ +---+ \n|   | | O | | X | \n+---+ +---+ +---+ \n")))
        "Printing full board")))

