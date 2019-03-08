(ns clojure-tictactoe.cli-test
  (:require [clojure.test :refer :all]
            [clojure-tictactoe.core :refer :all]
            [clojure-tictactoe.cli :refer :all]))

(deftest core-tests
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
        "Printing full board")

    (is (= (get-board-string
             (make-move 3 \O (make-move 5 \X (gen-board 3))))
           (str
             "+---+ +---+ +---+ \n"
             "|   | |   | |   | \n"
             "+---+ +---+ +---+ \n"
             "+---+ +---+ +---+ \n"
             "| O | |   | | X | \n"
             "+---+ +---+ +---+ \n"
             "+---+ +---+ +---+ \n"
             "|   | |   | |   | \n"
             "+---+ +---+ +---+ \n"))
        "Printing board with moves")))

