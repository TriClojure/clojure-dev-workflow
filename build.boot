(set-env!
  :source-paths #{"src" "test"}
  :dependencies '[[org.clojure/clojure "1.9.0"]
                  [adzerk/boot-test    "1.2.0"  :scope "test"]])

(require '[adzerk.boot-test :refer :all])

(task-options!
  test {:include #"^.*-test$"})

