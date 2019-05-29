(ns tictactoe.core
  (:require [tictactoe.model :refer :all]
            [tictactoe.cli :refer :all])
  (:gen-class))


(defn -main
  "Console game entry point"
  ([]
   (cli-loop \X (gen-board 3)))
  ([& args]
   (cli-loop \X (gen-board (first args)))))

