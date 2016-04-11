;; NOTE: This project.clj file exists purely to make it easier to
;; develop and test data.csv locally. The pom.xml file is the
;; "system of record" as far as the project version is concerned.

(defproject org.clojure/data.csv "0.1.4-SNAPSHOT"
  :description "A Clojure library for reading and writing comma separated value (csv) files"
  :parent [org.clojure/pom.contrib "0.1.2"]
  :url "https://github.com/clojure/data.csv"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :source-paths ["src/main/clojure"]
  :test-paths ["src/test/clojure"]
  :plugins [[lein-cljsbuild "1.1.3"]]
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [org.clojure/clojurescript "1.8.40"]]
  :min-lein-version "2.0.0"
  :cljsbuild
  {:builds [{:id "dev"
             :source-paths ["src/main/clojure"]
             :compiler {:output-to "out/main.js"
                        :output-dir "out"
                        :optimizations :simple
                        :pretty-print true}}
            {:id "whitespace"
             :source-paths ["src/main/clojure" "src/test/clojure"]
             :compiler {:output-to "target/test/tests-whitespace.js"
                        :output-dir "target/test/out-whitespace"
                        :optimizations :whitespace}}
            {:id "simple"
             :source-paths ["src/main/clojure" "src/test/clojure"]
             :notify-command ["node" "target/test/tests-simple.js"]
             :compiler {:optimizations :simple
                        :output-to "target/test/tests-simple.js"
                        :output-dir "target/test/out-simple"}}
            {:id "advanced"
             :source-paths ["src/main/clojure" "src/test/clojure"]
             :compiler {:optimizations :advanced
                        :output-to "target/test/tests-advanced.js"
                        :output-dir "target/test/out-advanced"}}]
   :test-commands
   {"simple" ["node" "target/test/tests-simple.js"]
    "advanced" ["node" "target/test/tests-advanced.js"]}})

