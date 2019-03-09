(ns clojure-tictactoe.model-test
  (:require [clojure.test :refer :all]
            [clojure-tictactoe.model :refer :all]))

(deftest core-tests
  (testing "Testing board generation"
    (is (= (gen-board 2)
           [nil nil nil nil])
        "Generating 2x2 board")

    (is (= (gen-board 3)
           [nil nil nil nil nil nil nil nil nil])
        "Generating 3x3 board"))


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

    (is (= (get-board-size (gen-board 3))
           3)
        "Extracting board size from the board")

    (is (= (indexes-to-cells [0 3 1 2] [\X \O \X \O])
           [\X \O \O \X])
        "Retrieving cell values")

    (is (= (get-board-paths [\X \O \X \O])
           '[(\X \O) (\X \O) (\X \X) (\O \O) (\X \O) (\O \X)])
        "Getting every win path of the 2x2 board"))


  (testing "Testing game manipulations"
    (is (= (no-more-moves? (gen-board 3))
           false)
        "New boards always have moves")

    (is (= (no-more-moves? [\X \O \X \O \X \O \X \O \X])
           true)
        "Fully occupied board have no moves")

    (is (= (next-player \X)
           \O))

    (is (= (next-player \O)
           \X))

    (is (= (occupied? 3 (gen-board 3))
           nil)
        "New boards don't have taken cells")

    (is (= (occupied? 2 [\X nil \O nil])
           \O)
        "Cell is taken by player")

    (is (= (make-move 3 \O (make-move 5 \X (gen-board 3)))
           [nil nil nil \O nil \X nil nil nil])
        "Two moves on the empty board")

    (is (= (same-player? [nil nil nil])
           false)
        "nil is not a player")

    (is (= (same-player? [nil \X \O])
           false)
        "Path is not fully filled")

    (is (= (same-player? [\O \X \O])
           false)
        "Not the same player")

    (is (= (same-player? [\X \X \X])
           \X)
        "Fuly filled path returns a player")

    (is (= (win? (gen-board 3))
           nil)
        "New boards cannot be completed")

    (is (= (win? [\O \X \O
                  \X \X \X
                  \O \O \X])
           \X)
        "Player has taken second row")

    (is (= (win? [\O \X nil
                  \O \O \X
                  \O \O \X])
           \O)
        "Player has taken first col")

    (is (= (win? [\X \O \X
                  \O \X \O
                  \O \O \X])
           \X)
        "Player has taken diagonal")))

