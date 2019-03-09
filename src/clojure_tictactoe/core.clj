(ns clojure-tictactoe.core
  (:require [clojure-tictactoe.model :refer :all]
            [clojure-tictactoe.cli :refer :all])
  (:gen-class))


(defn -main
  "Console game entry point"
  ([]
   (cli-loop \X (gen-board 3)))
  ([& args]
   (cli-loop \X (gen-board (first args)))))

