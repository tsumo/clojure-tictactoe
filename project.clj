(defproject clojure-tictactoe "1.0.0"
  :description "Tic-tac-toe in console"

  :url "https://github.com/tsumo"

  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}

  :dependencies [[org.clojure/clojure "1.10.0"]
                 [org.clojure/clojurescript "1.10.520"]
                 [reagent "0.8.1"]
                 [re-frame "0.10.5"]]

  :plugins [[lein-cljsbuild "1.1.7"]
            [lein-figwheel "0.5.18"]]

  :hooks [leiningen.cljsbuild]
  ; :cljsbuild {:builds []}

  :profiles {:dev {:cljsbuild
                   {:builds {:client {:figwheel {:on-jsload "tictactoe.web/run"}
                                      :compiler {:main "tictactoe.web"
                                                 :asset-path "js"
                                                 :optimizations :none
                                                 :source-map true
                                                 :source-map-timestamp true}}}}}
             :prod {:cljsbuild
                    {:builds {:client {:compiler {:optimizations :advanced
                                                  :elide-asserts true
                                                  :pretty-print false}}}}}}

  :figwheel {:repl false
             :css-dirs ["resources/public"]}

  :clean-targets ^{:protect false} ["resources/public/js"]

  :cljsbuild {:builds {:client {:source-paths ["src"]
                                :compiler     {:output-dir "resources/public/js"
                                               :output-to "resources/public/js/client.js"}}}}

  :main ^:skip-aot tictactoe.core

  :repl-options {:init-ns tictactoe.core})

