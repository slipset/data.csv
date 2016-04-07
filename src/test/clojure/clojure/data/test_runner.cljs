(ns clojure.data.test-runner
  (:require
   [clojure.data.csv-test]
   [cljs.test :refer-macros [run-tests]]))

(enable-console-print!)
(run-tests 'clojure.data.csv-test)
