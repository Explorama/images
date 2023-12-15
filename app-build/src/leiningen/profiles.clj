{:system {:plugins [[lein-pprint "1.3.2"]
                    [rewrite-clj "1.1.47"]
                    [org.slf4j/jcl-over-slf4j "1.7.30"]
                    [commons-io "2.13.0"]
                    [org.clojure/data.json "2.4.0"]
                    [lein-ancient "0.7.0"]
                    [lein-cloverage "1.2.4"]
                    [cloverage "1.2.4" :exclusions [org.clojure/clojure org.clojure/tools.reader org.clojure/tools.cli]]
                    [org.clojure/tools.cli "1.0.219"]
                    [org.clojure/tools.reader "1.3.6"]
                    [org.apache.commons/commons-lang3 "3.10"]] ;; otherwise, transitive dependencies of lein-v and lein-nvd clash
          :pedantic? :warn
          :cloverage {:summary? true
                      :text? false
                      :html? true}}
 :pedantic-abort {:pedantic? :abort}}