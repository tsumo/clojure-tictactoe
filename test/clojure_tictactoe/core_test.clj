(ns clojure-tictactoe.core-test
  (:require [clojure.test :refer :all]
            [clojure-tictactoe.core :refer :all]))

(deftest board-tests
  (testing "Testing board getters"
    (is (= (get-row 3 4) '(9 10 11 12)))
    (is (= (get-col 4 5) '(4 9 14 19 24)))
    (is (= (map get-row-num (range 1 10) (repeat 3))
           '(1 1 1 2 2 2 3 3 3)))
    (is (= (map get-row-num (range 1 17) (repeat 4))
           '(1 1 1 1 2 2 2 2 3 3 3 3 4 4 4 4)))
    (is (= (map get-col-num (range 1 10) (repeat 3))
           '(1 2 3 1 2 3 1 2 3)))
    (is (= (map get-col-num (range 1 17) (repeat 4))
           '(1 2 3 4 1 2 3 4 1 2 3 4 1 2 3 4)))))

