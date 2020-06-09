;; The javafx application with an overridden start method
;;
(ns app.core
  (:gen-class
   :extends javafx.application.Application)
  (:require
   [app.jfx]
   [app.view])
  (:import
   (javafx.scene Scene)))

(defn -start [this stage]
  (app.jfx/fx-window stage (app.view.Main.) ""))
