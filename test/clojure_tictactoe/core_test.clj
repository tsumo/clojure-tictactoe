(ns clojure-tictactoe.core-test
  (:require [clojure.test :refer :all]
            [clojure-tictactoe.core :refer :all]))

(deftest board-tests
  (testing "Testing board getters"
    (is (= (get-row 3 4) '(9 10 11 12)))
    (is (= (get-col 4 5) '(4 9 14 19 24)))
    (is (= (map get-row-num '(1 2 3 4 5 6 7 8 9) (repeat 3))
           '(1 1 1 2 2 2 3 3 3)))))

