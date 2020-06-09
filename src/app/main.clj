(ns app.main
  (:require
   [app.core])
  (:import
   (javafx.application Application))
  (:gen-class))

(defn -main
  [& args]
  (Application/launch app.core args))
