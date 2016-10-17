(defproject app "0.1.0-SNAPSHOT"
  :description "Clojure and JavaFX"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.7.0"]
                 [com.oracle/javafx-runtime "2.2.3"]
                 [org.clojure/tools.namespace "0.2.11"]]
  :aot :all
  :main app.core)
