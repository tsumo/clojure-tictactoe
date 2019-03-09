(defproject clojure-tictactoe "1.0.0"
  :description "Tic-tac-toe in console"
  :url "https://github.com/tsumo"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :dependencies [[org.clojure/clojure "1.10.0"]]
  :main ^:skip-aot clojure-tictactoe.core
  :repl-options {:init-ns clojure-tictactoe.core})
