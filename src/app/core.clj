;; The javafx application with a main function and an
;; overridden start method
;;
(ns app.core
  (:gen-class :extends javafx.application.Application)
  (:require
   [app.jfx :as jfx]
   [app.view :as view])
  (:import
   (javafx.application Application)
   (javafx.scene Scene)))

(defn -main
  [& args]
  (Application/launch app.core args))

(defn -start [this stage]
  (jfx/fx-window stage (app.view.Main.) ""))
