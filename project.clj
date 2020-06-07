(defproject app "0.1.0-SNAPSHOT"
  :description "Clojure and JavaFX"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.10.1"]

                 ;; taken from fn-fx:
                 ;; - https://github.com/fn-fx/fn-fx/blob/36c7659ef3d9b88b8bcf71fecd792c0d829a2d38/project.clj#L37-L42
                 ;;[org.openjfx/javafx-controls "11.0.2"]
                 ;;[org.openjfx/javafx-swing "11.0.2"]
                 ;;[org.openjfx/javafx-media "11.0.2"]
                 [org.openjfx/javafx-fxml "11.0.2"]
                 ;;[org.openjfx/javafx-web "11.0.2"]
                 ;;[org.openjfx/javafx-graphics "11.0.2"]
                 ]
  :aot :all
  :main app.core)
