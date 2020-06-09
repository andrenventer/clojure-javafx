(defproject app "0.2.0"
  :description "Clojure and JavaFX"
  :url "https://github.com/andrenventer/clojure-javafx"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.10.1"]
                 [org.openjfx/javafx-fxml "11.0.2"]]
  :aot :all
  :main app.main)
